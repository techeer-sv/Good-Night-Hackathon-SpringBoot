package com.techeer.hackaton.domain.review.controller;

import com.techeer.hackaton.domain.review.dto.ReviewCreateRequest;
import com.techeer.hackaton.domain.review.dto.ReviewCreateResponse;
import com.techeer.hackaton.domain.review.dto.ReviewInfo;
import com.techeer.hackaton.domain.review.dto.ReviewUpdateRequest;
import com.techeer.hackaton.domain.review.repository.ReviewRepository;
import com.techeer.hackaton.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;

    @PostMapping("/reviews")
    public ResponseEntity<ReviewCreateResponse> createReview(@RequestBody ReviewCreateRequest reviewCreateRequest) {
        reviewService.createReview(reviewCreateRequest);
        return ResponseEntity.ok(ReviewCreateResponse.builder()
                        .content(reviewCreateRequest.getContent())
                        .title(reviewCreateRequest.getTitle())
                .build());
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<ReviewInfo> getReviewDetail(@PathVariable Long id) {
        ReviewInfo reviewInfo = reviewService.getReviewDetail(id);

        return ResponseEntity.ok(reviewInfo);
    }

    @PutMapping("/reviews")
    public ResponseEntity<ReviewInfo> updateReview(@RequestBody ReviewUpdateRequest reviewUpdateRequest) {
        ReviewInfo reviewInfo = reviewService.updateReview(reviewUpdateRequest);
        return ResponseEntity.ok(reviewInfo);
    }
}
