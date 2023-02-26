package com.project.hackathon.domain.review.controller;


import com.project.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.project.hackathon.domain.restaurant.dto.RestaurantDetailResponse;
import com.project.hackathon.domain.restaurant.dto.RestaurantUpdateRequest;
import com.project.hackathon.domain.restaurant.entity.Category;
import com.project.hackathon.domain.restaurant.entity.Restaurant;
import com.project.hackathon.domain.restaurant.service.RestaurantService;
import com.project.hackathon.domain.review.dto.ReviewCreateRequest;
import com.project.hackathon.domain.review.dto.ReviewDetailResponse;
import com.project.hackathon.domain.review.dto.ReviewUpdateRequest;
import com.project.hackathon.domain.review.entity.Review;
import com.project.hackathon.domain.review.service.ReviewService;
import com.project.hackathon.global.dto.ResultResponse;
import lombok.RequiredArgsConstructor;
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

//    @GetMapping("/list/{category}")
//    public ResponseEntity<List<RestaurantDetailResponse>> loadRestaurantByCategory(@PathVariable Category category) {
//        List<RestaurantDetailResponse> restaurantDetailResponses = restaurantService.getRestaurantsByCategory(category);
//        return ResponseEntity.ok(restaurantDetailResponses);
//    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReviewDetailResponse> updateReview(
            @PathVariable Long id,
            @Valid @RequestBody ReviewUpdateRequest request) {
        ReviewDetailResponse reviewDetailResponse = reviewService.update(id, request);
        return ResponseEntity.ok(reviewDetailResponse);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<RestaurantDetailResponse> deleteRestaurant(
//            @PathVariable Long id) {
//        restaurantService.delete(id);
//        String message = ResultResponse.RESTAURANT_DELETE_SUCCESS.getMessage();
//        RestaurantDetailResponse response = new RestaurantDetailResponse(message);
//        return ResponseEntity.ok(response);
//    }
}