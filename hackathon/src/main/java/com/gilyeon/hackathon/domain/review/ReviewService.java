package com.gilyeon.hackathon.domain.review;

import com.gilyeon.hackathon.domain.restaurant.RestaurantRepository;
import com.gilyeon.hackathon.domain.restaurant.RestaurantService;
import com.gilyeon.hackathon.domain.restaurant.entity.Restaurant;
import com.gilyeon.hackathon.domain.review.dto.ReviewCreateRequest;
import com.gilyeon.hackathon.domain.review.dto.ReviewInfo;
import com.gilyeon.hackathon.domain.review.dto.ReviewUpdateRequest;
import com.gilyeon.hackathon.domain.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;


    @Transactional(readOnly = true)
    public ReviewInfo getReviewDetail(Long id) {
        Review findReview = reviewRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return mapReviewEntityToReviewInfo(findReview);
    }

    @Transactional
    public void createReview(ReviewCreateRequest reviewCreateRequest) {
        Restaurant restaurant = restaurantRepository.findById(reviewCreateRequest.getRestaurantId())
            .orElseThrow(EntityNotFoundException::new);

        reviewRepository.save(reviewCreateRequest.toEntity(restaurant));
    }

    @Transactional
    public ReviewInfo updateRestaurant(ReviewUpdateRequest reviewUpdateRequest) {
        Review findReview = reviewRepository.findById(reviewUpdateRequest.getId())
                .orElseThrow(EntityNotFoundException::new);

        findReview.update(reviewUpdateRequest);
        Review saveReview = reviewRepository.save(findReview);

        return mapReviewEntityToReviewInfo(saveReview);
    }

    @Transactional
    public void deleteReview(Long id) {
        Review findReview = reviewRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        reviewRepository.delete(findReview);
    }

//    public Review mapReviewEntityCreateRequestToReview(ReviewCreateRequest reviewCreateRequest) {
//        return Review.builder()
//                .content(reviewCreateRequest.getContent())
//                .title(reviewCreateRequest.getTitle())
//                .build();
//    }

    public ReviewInfo mapReviewEntityToReviewInfo(Review review) {
        return ReviewInfo.builder()
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getModifiedAt())
                .content(review.getContent())
                .title(review.getTitle())
                .build();
    }

    @Transactional(readOnly = true)
    public List<ReviewInfo> getReviewListByPagination(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return reviewRepository.findReviewWithPagination(pageRequest).stream()
                .map(this::mapReviewEntityToReviewInfo)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ReviewInfo> getReviewListWithTitleOrContentByPagination(int page, int size, String title) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return reviewRepository.findReviewContainTitleOrContentWithPagination(pageRequest, title).stream()
                .map(this::mapReviewEntityToReviewInfo)
                .collect(Collectors.toList());
    }

}
