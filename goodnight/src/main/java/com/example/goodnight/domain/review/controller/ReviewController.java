package com.example.goodnight.domain.review.controller;

import com.example.goodnight.domain.review.domain.Review;
import com.example.goodnight.domain.review.dto.request.ReviewDto;
import com.example.goodnight.domain.review.dto.request.ReviewReqDto;
import com.example.goodnight.domain.review.dto.response.ReviewAllResDto;
import com.example.goodnight.domain.review.dto.response.ReviewResDto;
import com.example.goodnight.domain.review.service.ReviewService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/api/v1/reviews")
    public List<ReviewAllResDto> getAllReviews(@RequestParam(value = "title") String title, @RequestParam(value = "content") String content) {
        return reviewService.getReviews(title, content);
    }


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
