package com.example.demo.domain.review.controller;

import com.example.demo.domain.review.dto.ReviewCreateResponse;
import com.example.demo.domain.review.service.ReviewService;
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
    public ResponseEntity<ReviewCreateResponse> createReview(@RequestBody ReviewCreateResponse reviewCreateResponse){
        ReviewCreateResponse createResponse = reviewService.createReview(reviewCreateResponse);
        return ResponseEntity.ok(createResponse);
    }
}
