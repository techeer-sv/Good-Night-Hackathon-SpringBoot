package com.techeergroup2.goodnight.domain.review.controller;

import com.techeergroup2.goodnight.domain.review.dto.ReviewCreateRequest;
import com.techeergroup2.goodnight.domain.review.dto.ReviewCreateResponse;
import com.techeergroup2.goodnight.domain.review.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/reviews")
@AllArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    //    CREATE
    @PostMapping("{id}")
    public ReviewCreateResponse createReview(@PathVariable Long id, @RequestBody ReviewCreateRequest request) {
        return reviewService.createReview(id, request);
    }

}
