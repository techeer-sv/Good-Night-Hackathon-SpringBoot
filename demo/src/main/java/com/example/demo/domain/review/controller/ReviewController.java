package com.example.demo.domain.review.controller;

import com.example.demo.domain.review.dto.request.ReviewCreateRequest;
import com.example.demo.domain.review.dto.request.ReviewSearchRequest;
import com.example.demo.domain.review.dto.request.ReviewUpdateRequest;
import com.example.demo.domain.review.dto.response.ReviewResponse;
import com.example.demo.domain.review.service.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/restaurants")
@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewServiceImpl reviewServiceImpl;

    @PostMapping("{restaurantId}/reviews")
    public ResponseEntity<ReviewResponse> createRestaurant(@PathVariable Long restaurantId, @RequestBody ReviewCreateRequest reviewCreateRequest) {
        ReviewResponse reviewResponse = reviewServiceImpl.createReview(restaurantId, reviewCreateRequest);
        return ResponseEntity.ok(reviewResponse);
    }

    @GetMapping("{restaurantId}/reviews")
    public ResponseEntity<List<ReviewResponse>> getRestaurants(
            @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size,
            @ModelAttribute ReviewSearchRequest reviewSearchRequest) {
        List<ReviewResponse> reviewResponse = reviewServiceImpl.getReviews(page, size, reviewSearchRequest);
        return ResponseEntity.ok(reviewResponse);
    }

    @GetMapping("{restaurantId}/reviews/{id}")
    public ResponseEntity<ReviewResponse> getRestaurantById(@PathVariable Long restaurantId, @PathVariable Long id) {
        ReviewResponse reviewResponse = reviewServiceImpl.getReviewById(restaurantId, id);
        return ResponseEntity.ok(reviewResponse);
    }

    @PutMapping("{restaurantId}/reviews/{id}")
    public ResponseEntity<ReviewResponse> updateRestaurant(@PathVariable Long restaurantId, @PathVariable Long id, @RequestBody ReviewUpdateRequest reviewUpdateRequest) {
        ReviewResponse reviewResponse = reviewServiceImpl.updateReview(restaurantId, id, reviewUpdateRequest);
        return ResponseEntity.ok(reviewResponse);
    }

    @DeleteMapping("{restaurantId}/reviews/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long restaurantId, @PathVariable Long id) {
        reviewServiceImpl.deleteReview(restaurantId, id);
        return ResponseEntity.ok("ok");
    }

}
