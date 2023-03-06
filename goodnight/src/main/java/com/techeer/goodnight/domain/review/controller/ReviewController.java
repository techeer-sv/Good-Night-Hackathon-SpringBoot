package com.techeer.goodnight.domain.review.controller;

import com.techeer.goodnight.domain.review.service.ReviewService;
import com.techeer.goodnight.domain.review.dto.request.ViewCreateRequestDto;
import com.techeer.goodnight.domain.review.dto.request.ViewUpdateRequestDto;
import com.techeer.goodnight.domain.review.dto.response.ReviewResponseDto;
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

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    @Resource(name = "reviewService")
    private final ReviewService reviewService;

    @GetMapping()
    public ResponseEntity<Page<ReviewResponseDto>> getReviews(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC)Pageable pageable,
            @RequestParam(value = "keyword", required = false) Optional<String> keyword
    ) {
        return new ResponseEntity<>(reviewService.findAll(pageable, keyword), HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<ReviewResponseDto> create(@RequestBody final ViewCreateRequestDto reviewReq) {
        return new ResponseEntity<>(reviewService.create(reviewReq), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> getReview(@PathVariable long id) {
        return new ResponseEntity<>(reviewService.findById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> patchReview(
            @PathVariable long id,
            @RequestBody ViewUpdateRequestDto patchReviewReq) {
        return new ResponseEntity<>(reviewService.patchById(id, patchReviewReq), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable long id) {
        reviewService.deleteById(id);
    }
}