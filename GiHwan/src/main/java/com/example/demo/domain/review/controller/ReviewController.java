package com.example.demo.domain.review.controller;

import com.example.demo.domain.restaurant.dao.RestaurantRepository;
import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.domain.review.dto.ReviewCreateResponse;
import com.example.demo.domain.review.dto.ReviewInfo;
import com.example.demo.domain.review.dto.ReviewUpdateRequest;
import com.example.demo.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

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

    @GetMapping("/reviews/{id}")
    public ResponseEntity<ReviewInfo> getReviewDetail(@PathVariable Long id){
        ReviewInfo reviewInfo = reviewService.getReviewDetail(id);
        return ResponseEntity.ok(reviewInfo);
    }

    @PutMapping("/reviews")
    public ResponseEntity<ReviewInfo> updateReview(@RequestBody ReviewUpdateRequest reviewUpdateRequest){
        ReviewInfo reviewInfo = reviewService.updateReview(reviewUpdateRequest);
        return ResponseEntity.ok(reviewInfo);
    }
}
