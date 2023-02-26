package com.techeer.goodnighthackathonspringboot.domain.review.service;

import com.techeer.goodnighthackathonspringboot.domain.restaurant.dao.RestaurantRepository;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.domain.Restaurant;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.exception.NotFoundRestaurantException;
import com.techeer.goodnighthackathonspringboot.domain.review.dao.ReviewRepository;
import com.techeer.goodnighthackathonspringboot.domain.review.domain.Review;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.request.ReviewCreateRequest;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.ReviewInfo;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.request.ReviewUpdateRequest;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.mapper.ReviewMapper;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.response.ReviewPageInfo;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.response.ReviewResponse;
import com.techeer.goodnighthackathonspringboot.domain.review.exception.NotFoundReviewException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewMapper mapper;

    public ReviewInfo create(ReviewCreateRequest request) {
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(NotFoundRestaurantException::new);
        Review review = Review.builder()
                .restaurant(restaurant)
                .title(request.getTitle())
                .contents(request.getContents())
                .build();
        return mapper.mapEntityToInfo(reviewRepository.save(review));
    }

    public ReviewInfo update(ReviewUpdateRequest request){
        Review review = reviewRepository.findById(request.getId())
                .orElseThrow(NotFoundReviewException::new);
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(NotFoundRestaurantException::new);
        review.update(restaurant, request.getTitle(), request.getContents());
        return mapper.mapEntityToInfo(reviewRepository.save(review));
    }

    public void delete(Long id){
        Review review = reviewRepository.findById(id).orElseThrow(NotFoundReviewException::new);
        reviewRepository.delete(review);
    }

    public ReviewResponse getOne(Long id){
        Review review = reviewRepository.findById(id)
                .orElseThrow(NotFoundReviewException::new);
        return ReviewResponse.builder()
                .restaurantName(review.getRestaurant().getName())
                .title(review.getTitle())
                .contents(review.getContents())
                .build();
    }

    @Transactional(readOnly = true)
    public ReviewPageInfo getReviewByPagination(int offset, int size, String cmd) {
        if (cmd.equals("desc")) {
            PageRequest pageRequest = PageRequest.of(offset, size);
            Page<Review> reviewByPagination = reviewRepository.findReviewWithPaginationOrderByCreatedOnAsc(pageRequest);
            return mapper.mapEntityToReviewPageInfo(reviewByPagination);
        }
        else {
            PageRequest pageRequest = PageRequest.of(offset, size);
            Page<Review> reviewByPagination = reviewRepository.findReviewWithPaginationOrderByCreatedOnDesc(pageRequest);
            return mapper.mapEntityToReviewPageInfo(reviewByPagination);
        }
    }
}
