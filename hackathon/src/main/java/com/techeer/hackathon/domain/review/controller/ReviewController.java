package com.techeer.hackathon.domain.review.controller;

import com.techeer.hackathon.domain.review.dto.ReviewCreate;
import com.techeer.hackathon.domain.review.service.ReviewService;
import com.techeer.hackathon.global.result.ResultCode;
import com.techeer.hackathon.global.result.ResultResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
