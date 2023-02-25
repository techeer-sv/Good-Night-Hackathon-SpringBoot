package techeer.restaurant.domain.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techeer.restaurant.domain.review.dto.ReviewInfo;
import techeer.restaurant.domain.review.dto.ReviewRequest;
import techeer.restaurant.domain.review.entity.Review;
import techeer.restaurant.global.domain.response.ResultResponse;
import techeer.restaurant.global.domain.response.code.ResultCode;

import javax.validation.Valid;

@RequestMapping("/api/v1/review")
@RestController
@RequiredArgsConstructor
public class ReviewController {

    @PostMapping
    public ResponseEntity<ResultResponse> createReview(
            @Valid @RequestBody ReviewRequest request
    ) {
        ReviewInfo reviewInfo =
        return ResponseEntity.ok(ResultResponse.of(ResultCode.CREATE_REVIEW_SUCCESS_SUCCESS, reviewInfo));
    }


}
