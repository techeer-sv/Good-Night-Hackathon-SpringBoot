package techeer.restaurant.domain.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techeer.restaurant.domain.review.dto.ReviewInfo;
import techeer.restaurant.domain.review.dto.ReviewRequest;
import techeer.restaurant.domain.review.dto.UpdateReviewRequest;
import techeer.restaurant.domain.review.service.ReviewService;
import techeer.restaurant.global.domain.response.ResultResponse;

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
    public ResponseEntity<ResultResponse> getReviews(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                     @RequestParam(required = false, defaultValue = "3") Integer size,
                                                     @RequestParam(required = false, defaultValue = "") String title,
                                                     @RequestParam(required = false, defaultValue = "") String content,
                                                     @RequestParam(required = false, defaultValue = "false") String descending) {
        List<ReviewInfo> reviewInfos = reviewService.findAllWithPagination(page, size, title, content, Boolean.parseBoolean(descending));
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
