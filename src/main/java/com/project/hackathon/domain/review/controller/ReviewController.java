package com.project.hackathon.domain.review.controller;

import com.project.hackathon.domain.review.dto.ReviewCreateRequest;
import com.project.hackathon.domain.review.dto.ReviewDetailResponse;
import com.project.hackathon.domain.review.dto.ReviewUpdateRequest;
import com.project.hackathon.domain.review.entity.Review;
import com.project.hackathon.domain.review.service.ReviewService;
import com.project.hackathon.global.dto.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/{restaurant}/review")
@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;
    @PostMapping("/create")
    public ResponseEntity<ReviewDetailResponse> createReview(
            @Validated @RequestBody ReviewCreateRequest request,
            @PathVariable String restaurant) {
        ReviewDetailResponse reviewDetailResponse = reviewService.create(request);
        return ResponseEntity.ok(reviewDetailResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable String restaurant) {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/list/createdAt")
    public ResponseEntity<List<Review>> getAllReviewsByCreatedAt(@PathVariable String restaurant) {
        List<Review> reviews = reviewService.getAllReviewsByCreatedAt();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/list/createdAtDesc")
    public ResponseEntity<List<Review>> getAllReviewsByCreatedAtDesc() {
        List<Review> reviews = reviewService.getAllReviewsByCreatedAtDesc();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/search/{keyword}?page=0&size=10리&sort=id,desc")
    public ResponseEntity<Page<ReviewDetailResponse>> searchReviews(
            @PathVariable String keyword,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReviewDetailResponse> reviews = reviewService.search(keyword, pageable);
        return ResponseEntity.ok(reviews);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReviewDetailResponse> updateReview(
            @PathVariable Long id,
            @Valid @RequestBody ReviewUpdateRequest request) {
        ReviewDetailResponse reviewDetailResponse = reviewService.update(id, request);
        return ResponseEntity.ok(reviewDetailResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReviewDetailResponse> deleteReview(
            @PathVariable Long id) {
        reviewService.delete(id);
        String message = ResultResponse.REVIEW_DELETE_SUCCESS.getMessage();
        ReviewDetailResponse response = new ReviewDetailResponse(message);
        return ResponseEntity.ok(response);
    }
}