package com.project.hackathon.domain.review.controller;


import com.project.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.project.hackathon.domain.restaurant.dto.RestaurantDetailResponse;
import com.project.hackathon.domain.restaurant.entity.Restaurant;
import com.project.hackathon.domain.restaurant.service.RestaurantService;
import com.project.hackathon.domain.review.dto.ReviewCreateRequest;
import com.project.hackathon.domain.review.dto.ReviewDetailResponse;
import com.project.hackathon.domain.review.entity.Review;
import com.project.hackathon.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
}