package techeer.restaurant.domain.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techeer.restaurant.domain.restaurant.dto.RestaurantInfo;
import techeer.restaurant.domain.restaurant.entity.Category;
import techeer.restaurant.domain.review.dto.ReviewInfo;
import techeer.restaurant.domain.review.dto.ReviewRequest;
import techeer.restaurant.domain.review.dto.UpdateReviewRequest;
import techeer.restaurant.domain.review.entity.Review;
import techeer.restaurant.domain.review.service.ReviewService;
import techeer.restaurant.global.domain.response.ResultResponse;
import techeer.restaurant.global.domain.response.code.ResultCode;

import javax.validation.Valid;

import java.util.List;

import static techeer.restaurant.global.domain.response.code.ResultCode.*;

@RequestMapping("/api/v1/reviews")
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    @PostMapping
    public ResponseEntity<ResultResponse> createReview(
            @Valid @RequestBody ReviewRequest request
    ) {
        ReviewInfo reviewInfo = reviewService.createReview(request);
        return ResponseEntity.ok(ResultResponse.of(CREATE_REVIEW_SUCCESS, reviewInfo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultResponse> findReviewById(@PathVariable Long id) {
        ReviewInfo reviewInfo = reviewService.findReviewInfoById(id);
        return ResponseEntity.ok(ResultResponse.of(GET_ONE_REVIEW_SUCCESS, reviewInfo));
    }

    @GetMapping
    public ResponseEntity<ResultResponse> getReviews(@RequestParam(required = false, defaultValue = "1") int page,
                                   @RequestParam(required = false) String title,
                                   @RequestParam(required = false) String content,
                                   @RequestParam(required = false, defaultValue = "desc") String sort) {
        List<ReviewInfo> reviewInfos = reviewService.getReviews(page, title, content, sort);
        return ResponseEntity.ok(ResultResponse.of(GET_ALL_REVIEW_SUCCESS, reviewInfos));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResultResponse> updateReview(
            @PathVariable Long id,
            @RequestBody UpdateReviewRequest request
    ) {
        reviewService.updateReviewInfo(id, request);
        return ResponseEntity.ok(ResultResponse.of(UPDATE_RESTAURANT_SUCCESS, ""));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResultResponse> deleteRestaurant(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok(ResultResponse.of(DELETE_REVIEW_SUCCESS, ""));
    }

}
