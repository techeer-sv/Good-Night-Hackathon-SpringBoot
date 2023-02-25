package com.example.goodnight.domain.review.controller;

import com.example.goodnight.domain.review.dto.request.ReviewDto;
import com.example.goodnight.domain.review.dto.request.ReviewReqDto;
import com.example.goodnight.domain.review.dto.response.ReviewResDto;
import com.example.goodnight.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/api/v1/reviews/{id}")
    public ReviewResDto getReview(@PathVariable Long id) {
        return reviewService.getReview(id);
    }

    @PostMapping("/api/v1/reviews")
    public void createReview(@RequestBody ReviewDto dto) {
        reviewService.addReview(dto);
    }

    @PutMapping("/api/v1/reviews")
    public void updateReview(@RequestBody ReviewReqDto dto) {
        reviewService.updateReview(dto.getId(), dto.getTitle(), dto.getContent());
    }
    @DeleteMapping("/api/v1/reviews/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.removeReview(id);
    }
}
