package com.example.hackathon.review.controller;

import com.example.hackathon.global.dto.ResultResponse;
import com.example.hackathon.global.dto.code.ResultCode;
import com.example.hackathon.review.dto.ReviewCreateDTO;
import com.example.hackathon.review.service.ReviewService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/review")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ResultResponse> createReview(@RequestBody ReviewCreateDTO request) {
        reviewService.createReview(request);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.CREATE_REVIEW_SUCCESS));
    }

}
