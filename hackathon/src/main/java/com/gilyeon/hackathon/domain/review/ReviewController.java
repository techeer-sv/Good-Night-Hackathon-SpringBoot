package com.gilyeon.hackathon.domain.review;

import com.gilyeon.hackathon.domain.review.dto.ReviewInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("review/{id}")
    public ResponseEntity<ReviewInfo> getReviewID(@PathVariable Long id) {
        ReviewInfo reviewInfo = reviewService.getReviewDetail(id);

        return ResponseEntity.ok(reviewInfo);
    }
}
