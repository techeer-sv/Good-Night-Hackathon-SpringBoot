package com.techeer.hackaton.domain.review.controller;

import com.techeer.hackaton.domain.review.dto.ReviewCreateRequest;
import com.techeer.hackaton.domain.review.dto.ReviewInfo;
import com.techeer.hackaton.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/reviews")
    public ResponseEntity<ReviewInfo> createReview(@RequestBody ReviewCreateRequest reviewCreateRequest) {
        reviewService.createReview(reviewCreateRequest);
        return ResponseEntity.ok(ReviewInfo.builder()
                        .content(reviewCreateRequest.getContent())
                        .title(reviewCreateRequest.getTitle())
                        .restaurantId(reviewCreateRequest.getRestaurantId())
                .build());
    }
}
