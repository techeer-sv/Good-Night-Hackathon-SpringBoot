package com.gilyeon.hackathon.domain.review;

import com.gilyeon.hackathon.domain.review.dto.ReviewCreateRequest;
import com.gilyeon.hackathon.domain.review.dto.ReviewInfo;
import com.gilyeon.hackathon.domain.review.dto.ReviewUpdateRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/review/{id}")
    public ResponseEntity<ReviewInfo> getReview(@PathVariable Long id) {
        ReviewInfo reviewInfo = reviewService.getReviewDetail(id);

        return ResponseEntity.ok(reviewInfo);
    }

    @PostMapping("/review/create")
    public ResponseEntity<ReviewInfo> craeteReview(@RequestBody ReviewCreateRequest reviewCreateRequest){
        reviewService.createReview(reviewCreateRequest);
        return ResponseEntity.ok(ReviewInfo.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .restaurantId(reviewCreateRequest.getRestaurantId())
                .build());
    }

    @PutMapping("/review/edit")
    public ResponseEntity<ReviewInfo> updateReview(@RequestBody ReviewUpdateRequest reviewUpdateRequest) {
        ReviewInfo reviewInfo = reviewService.updateRestaurant(reviewUpdateRequest);
        return ResponseEntity.ok(reviewInfo);
    }

    @DeleteMapping("/review/delete/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok(id+"번 리뷰가 삭제되었습니다.");
    }

    @GetMapping("/review/list")
    public ResponseEntity<List<ReviewInfo>> getReviewListByPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<ReviewInfo> reviewInfoList = reviewService.getReviewListByPagination(page, size);
        return ResponseEntity.ok(reviewInfoList);
    }

    @GetMapping("/review/search")
    public ResponseEntity<List<ReviewInfo>> getReviewListWithTitleOrContentByPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String keyword) {
        List<ReviewInfo> reviewInfoList =
                reviewService.getReviewListWithTitleOrContentByPagination(page, size, keyword);
        return ResponseEntity.ok(reviewInfoList);
    }

}
