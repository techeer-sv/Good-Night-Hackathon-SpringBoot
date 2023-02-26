package com.project.hackathon.domain.review.service;

import com.project.hackathon.domain.review.dto.ReviewCreateRequest;
import com.project.hackathon.domain.review.dto.ReviewDetailResponse;
import com.project.hackathon.domain.review.dto.ReviewUpdateRequest;
import com.project.hackathon.domain.review.entity.Review;
import com.project.hackathon.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    public ReviewDetailResponse create(ReviewCreateRequest reviewCreateRequest) {
        Review newReview =
                Review.builder()
                        .title(reviewCreateRequest.getTitle())
                        .content(reviewCreateRequest.getContent())
                        .restaurant(reviewCreateRequest.getRestaurant())
                        .build();
        reviewRepository.save(newReview);
        return ReviewDetailResponse.builder()
                .id(newReview.getId())
                .title(newReview.getTitle())
                .content(newReview.getContent())
                .restaurant(reviewCreateRequest.getRestaurant())
                .createdAt(newReview.getCreatedAt())
                .build();
    }

    @Transactional
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Transactional
    public List<Review> getAllReviewsByCreatedAt() {
        return reviewRepository.findAllByOrderByCreatedAt();
    }

    @Transactional
    public List<Review> getAllReviewsByCreatedAtDesc() {
        return reviewRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional(readOnly = true)
    public Page<ReviewDetailResponse> search(String keyword, Pageable pageable) {
        Page<Review> reviews = reviewRepository.findContainingTitleOrContentReviewWithPagination(pageable, keyword);
        return reviews.map(review -> ReviewDetailResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .build());
    }

    @Transactional
    public ReviewDetailResponse update(Long id, ReviewUpdateRequest reviewUpdateRequest) {
        Review review = reviewRepository.findById(id).orElseThrow(null);
        review.setTitle(reviewUpdateRequest.getTitle());
        review.setContent(reviewUpdateRequest.getContent());
        review.setUpdatedAt();

        Review savedReview = reviewRepository.save(review);
        return new ReviewDetailResponse(
                savedReview.getId(),
                savedReview.getTitle(),
                savedReview.getContent(),
                savedReview.getRestaurant(),
                savedReview.getCreatedAt(),
                savedReview.getUpdatedAt()
        );
    }

    @Transactional
    public void delete(Long id) {
        Review review = reviewRepository.findReviewById(id).orElseThrow(null);
        review.deleteReview();
        reviewRepository.save(review);
    }
}