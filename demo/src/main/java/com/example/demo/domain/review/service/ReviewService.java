package com.example.demo.domain.review.service;

import com.example.demo.domain.review.dto.request.ReviewCreateRequest;
import com.example.demo.domain.review.dto.request.ReviewSearchRequest;
import com.example.demo.domain.review.dto.request.ReviewUpdateRequest;
import com.example.demo.domain.review.dto.response.ReviewResponse;

import java.util.List;

public interface ReviewService {
    // 리뷰 생성
    public ReviewResponse createReview(Long restaurantId, ReviewCreateRequest reviewDto);

    // 리뷰 수정
    public ReviewResponse updateReview(Long restaurantId, Long id, ReviewUpdateRequest reviewDto);

    // 리뷰 조회 - list
    public List<ReviewResponse> getReviews(int page, int size, ReviewSearchRequest reviewDto);

    // 리뷰 조회 - detail
    public ReviewResponse getReviewById(Long restaurantId, Long reviewId);

    // 리뷰 삭제
    public void deleteReview(Long restaurantId, Long reviewId);
}
