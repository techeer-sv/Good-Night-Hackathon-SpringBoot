package com.techeer.hackathon.domain.review.controller;

import com.techeer.hackathon.domain.review.dto.ReviewCreate;
import com.techeer.hackathon.domain.review.dto.ReviewInfo;
import com.techeer.hackathon.domain.review.dto.ReviewUpdateRequest;
import com.techeer.hackathon.domain.review.service.ReviewService;
import com.techeer.hackathon.global.result.ResultCode;
import com.techeer.hackathon.global.result.ResultResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/review")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ResultResponse> createReview(
            @RequestBody ReviewCreate request
    ) {
        reviewService.createReview(request);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.REVIEW_CREATE_SUCCESS));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultResponse> getReview(
            @PathVariable Long id) {
        return ResponseEntity.ok(ResultResponse.of(ResultCode.GET_REVIEW_SUCCESS, reviewService.getReview(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResultResponse> deleteReview(
            @PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.DELETE_REVIEW_SUCCESS));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResultResponse> updateReview(
            @RequestBody ReviewUpdateRequest reviewUpdateRequest
    ) {
        reviewService.updateReview(reviewUpdateRequest);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.UPDATE_REVIEW_SUCCESS));
    }

    @GetMapping("/{restaurantName}/{page}")
    public ResponseEntity<ResultResponse> getReview(
            @PathVariable String restaurantName, @PathVariable Integer page, @RequestParam(defaultValue = "20") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
        List<ReviewInfo> reviews = reviewService.getReviews(restaurantName, pageRequest);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.GET_ALL_REVIEW_SUCCESS, reviews));
    }

}
