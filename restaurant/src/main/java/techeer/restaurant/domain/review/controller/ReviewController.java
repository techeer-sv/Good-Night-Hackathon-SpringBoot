package techeer.restaurant.domain.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techeer.restaurant.domain.review.dto.ReviewInfo;
import techeer.restaurant.domain.review.dto.ReviewRequest;
import techeer.restaurant.domain.review.entity.Review;
import techeer.restaurant.domain.review.service.ReviewService;
import techeer.restaurant.global.domain.response.ResultResponse;
import techeer.restaurant.global.domain.response.code.ResultCode;

import javax.validation.Valid;

import static techeer.restaurant.global.domain.response.code.ResultCode.CREATE_REVIEW_SUCCESS;

@RequestMapping("/api/v1/review")
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


}
