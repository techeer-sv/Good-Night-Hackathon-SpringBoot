package com.techeer.hackaton.domain.review.controller;

import com.techeer.hackaton.domain.review.dto.ReviewCreateRequest;
import com.techeer.hackaton.domain.review.dto.ReviewCreateResponse;
import com.techeer.hackaton.domain.review.dto.ReviewInfo;
import com.techeer.hackaton.domain.review.dto.ReviewUpdateRequest;
import com.techeer.hackaton.domain.review.repository.ReviewRepository;
import com.techeer.hackaton.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/reviews")
    public ResponseEntity<ReviewCreateResponse> createReview(@RequestBody ReviewCreateRequest reviewCreateRequest) {
        reviewService.createReview(reviewCreateRequest);
        return ResponseEntity.ok(ReviewCreateResponse.builder()
                        .content(reviewCreateRequest.getContent())
                        .title(reviewCreateRequest.getTitle())
                .build());
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<ReviewInfo> getReviewDetail(@PathVariable Long id) {
        ReviewInfo reviewInfo = reviewService.getReviewDetail(id);

        return ResponseEntity.ok(reviewInfo);
    }

    @PutMapping("/reviews")
    public ResponseEntity<ReviewInfo> updateReview(@RequestBody ReviewUpdateRequest reviewUpdateRequest) {
        ReviewInfo reviewInfo = reviewService.updateReview(reviewUpdateRequest);
        return ResponseEntity.ok(reviewInfo);
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok("리뷰가 삭제되었습니다.");
    }

    @GetMapping("/reviews/list")
    public ResponseEntity<List<ReviewInfo>> getReviewListByPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<ReviewInfo> reviewInfoList = reviewService.getReviewListByPagination(page, size);
        return ResponseEntity.ok(reviewInfoList);
    }

    @GetMapping("/reviews/search/title")
    public ResponseEntity<List<ReviewInfo>> getReviewListWithTitleByPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String keyword
    ) {
        List<ReviewInfo> reviewInfoList =
                reviewService.getReviewListWithTitleByPagination(page, size, keyword);
        return ResponseEntity.ok(reviewInfoList);
    }

    @GetMapping("/reviews/search/content")
    public ResponseEntity<List<ReviewInfo>> getReviewListWithContentByPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String keyword
    ) {
        List<ReviewInfo> reviewInfoList =
                reviewService.getReviewListWithContentByPagination(page, size, keyword);
        return ResponseEntity.ok(reviewInfoList);
    }

}
