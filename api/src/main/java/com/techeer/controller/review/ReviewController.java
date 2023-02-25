package com.techeer.controller.review;

import com.techeer.persistence.review.application.ReviewService;
import com.techeer.persistence.review.dto.request.ReviewReq;
import com.techeer.persistence.review.dto.response.ReviewDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Tag(name = "reviews", description = "리뷰 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    @Resource(name = "reviewService")
    private final ReviewService reviewService;


    @Operation(operationId = "createReview", description = "리뷰 생성")
    @PostMapping()
    public ResponseEntity<ReviewDTO> create(@RequestBody final ReviewReq reviewReq) {
        return new ResponseEntity<>(reviewService.create(reviewReq), HttpStatus.CREATED);
    }
}
