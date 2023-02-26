package com.example.demo.domain.review.service;

import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.domain.restaurant.repository.RestaurantRepository;
import com.example.demo.domain.review.dto.request.ReviewCreateRequest;
import com.example.demo.domain.review.dto.request.ReviewSearchRequest;
import com.example.demo.domain.review.dto.request.ReviewUpdateRequest;
import com.example.demo.domain.review.dto.response.ReviewResponse;
import com.example.demo.domain.review.entity.Review;
import com.example.demo.domain.review.map.ToEntity;
import com.example.demo.domain.review.map.ToResponse;
import com.example.demo.domain.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ReviewRepository reviewRepository;

    private final ToEntity entity;

    private final ToResponse response;

    public ReviewServiceImpl(ToEntity entity, ToResponse response){
        this.entity = entity;
        this.response = response;
    }

    @Transactional
    public ReviewResponse createReview(Long restaurantId, ReviewCreateRequest reviewDto) {
        Restaurant foundRestaurant = restaurantRepository.findById(restaurantId).orElseThrow(EntityNotFoundException::new);
        Review foundReview = entity.toCreateEntity(reviewDto, foundRestaurant);
        Review savedReview = reviewRepository.save(foundReview);
        return response.toResponse(savedReview);
    }

    @Transactional
    public ReviewResponse updateReview(Long restaurantId, Long id, ReviewUpdateRequest reviewDto){
        Review foundReview = reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        foundReview.update(reviewDto);
        Review savedReview = reviewRepository.save(foundReview);

        return response.toResponse(savedReview);
    }

    @Transactional(readOnly = true)
    public List<ReviewResponse> getReviews(int page, int size, ReviewSearchRequest reviewDto){
        List<Review> reviews = null;

        if(reviewDto.getSearchType() == null)  {
            reviews = reviewRepository.findAllOrderByCreatedAtDesc((page-1)*size, size);
        }
        else if(reviewDto.getSearchType().toString().equals("title")) {
            reviews = reviewRepository.findAllContainingTitleOrderByCreatedAtDesc(
                    reviewDto.getSearchKeyword(),
                    (page-1)*size, size);
        } else if(reviewDto.getSearchType().toString().equals("content")) {
            reviews = reviewRepository.findAllContainingContentOrderByCreatedAtDesc(
                    reviewDto.getSearchKeyword(),
                    (page-1)*size, size);
        } else if(reviewDto.getSearchType().toString().equals("all")) {
            reviews = reviewRepository.findAllContainingTitleAndContentOrderByCreatedAtDesc(
                    reviewDto.getSearchKeyword(),
                    (page-1)*size, size);
        }
        List<ReviewResponse> reviewResponses = new ArrayList<>();
        reviews.forEach(s -> reviewResponses.add(response.toResponse(s)));
        return reviewResponses;
    }

    @Transactional(readOnly = true)
    public ReviewResponse getReviewById(Long restaurantId, Long reviewId){
        Review foundReview = reviewRepository.findById(reviewId).orElseThrow(EntityNotFoundException::new);
        return response.toResponse(foundReview);
    }

    @Transactional
    public void deleteReview(Long restaurantId, Long reviewId){
        Review review = reviewRepository.findById(reviewId).orElseThrow(EntityNotFoundException::new);
        reviewRepository.delete(review);
    }
}
