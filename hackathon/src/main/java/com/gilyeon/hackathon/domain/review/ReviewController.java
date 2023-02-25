package com.gilyeon.hackathon.domain.review;

import com.gilyeon.hackathon.domain.restaurant.dto.RestaurantInfo;
import com.gilyeon.hackathon.domain.review.dto.ReviewCreateRequest;
import com.gilyeon.hackathon.domain.review.dto.ReviewInfo;
import com.gilyeon.hackathon.domain.review.dto.ReviewUpdateRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/review")
    public ResponseEntity<ReviewInfo> craeteReview(@RequestBody ReviewCreateRequest reviewCreateRequest){
        reviewService.createReview(reviewCreateRequest);
        return ResponseEntity.ok(ReviewInfo.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .createdDate(reviewCreateRequest.getCreateDate())
                .build());
    }

    @PutMapping("/review")
    public ResponseEntity<ReviewInfo> updateReview(@RequestBody ReviewUpdateRequest reviewUpdateRequest) {
        ReviewInfo reviewInfo = reviewService.updateRestaurant(reviewUpdateRequest);
        return ResponseEntity.ok(reviewInfo);
    }


}
