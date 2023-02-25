package com.techeer.controller.review;

import com.techeer.persistence.review.application.ReviewService;
import com.techeer.persistence.review.dto.request.PatchReviewReq;
import com.techeer.persistence.review.dto.request.ReviewReq;
import com.techeer.persistence.review.dto.response.ReviewDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@Tag(name = "reviews", description = "리뷰 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    @Resource(name = "reviewService")
    private final ReviewService reviewService;

    @Operation(operationId = "getReviews", description = "리뷰 목록 조회")
    @GetMapping()
    public ResponseEntity<Page<ReviewDTO>> getReviews(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC)Pageable pageable,
            @RequestParam(value = "keyword", required = false) Optional<String> keyword
    ) {
        return new ResponseEntity<>(reviewService.findAll(pageable, keyword), HttpStatus.OK);
    }


    @Operation(operationId = "createReview", description = "리뷰 생성")
    @PostMapping()
    public ResponseEntity<ReviewDTO> create(@RequestBody final ReviewReq reviewReq) {
        return new ResponseEntity<>(reviewService.create(reviewReq), HttpStatus.CREATED);
    }

    @Operation(operationId = "getReview", description = "리뷰 조회")
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReview(@PathVariable long id) {
        return new ResponseEntity<>(reviewService.findById(id), HttpStatus.OK);
    }

    @Operation(operationId = "patchReview", description = "리뷰 수정")
    @PatchMapping("/{id}")
    public ResponseEntity<ReviewDTO> patchReview(
            @PathVariable long id,
            @RequestBody PatchReviewReq patchReviewReq) {
        return new ResponseEntity<>(reviewService.patchById(id, patchReviewReq), HttpStatus.OK);
    }
}
