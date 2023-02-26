package com.techeer.goodnighthackathonspringboot.domain.review.controller;

import com.techeer.goodnighthackathonspringboot.domain.review.dto.request.ReviewCreateRequest;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.ReviewInfo;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.request.ReviewUpdateRequest;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.response.ReviewPageInfo;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.response.ReviewResponse;
import com.techeer.goodnighthackathonspringboot.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/review")
@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewInfo> write(
            @Valid @RequestBody ReviewCreateRequest request
            ){
        return ResponseEntity.ok(reviewService.create(request));
    }

    @PatchMapping
    public ResponseEntity<ReviewInfo> update(@Valid @RequestBody ReviewUpdateRequest request){
        System.out.println(request.toString());
        return ResponseEntity.ok(reviewService.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getOne(@PathVariable Long id){
        return ResponseEntity.ok(reviewService.getOne(id));
    }

    @GetMapping("/page")
    public ResponseEntity<ReviewPageInfo> getReviewByPagination(
    @RequestParam(defaultValue = "0") int offset,
    @RequestParam(defaultValue = "10") int size,
    @RequestParam String cmd){
        ReviewPageInfo reviewPageInfo = reviewService.getReviewByPagination(offset, size, cmd);
        return ResponseEntity.ok(reviewPageInfo);
    }
}
