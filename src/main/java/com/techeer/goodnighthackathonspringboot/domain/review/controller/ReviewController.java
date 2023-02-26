package com.techeer.goodnighthackathonspringboot.domain.review.controller;

import com.techeer.goodnighthackathonspringboot.domain.review.dto.request.ReviewCreateRequest;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.ReviewInfo;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.request.ReviewUpdateRequest;
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

    @PatchMapping("/{id}")
    public ResponseEntity<ReviewInfo> update(ReviewUpdateRequest request){
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
    public R
}
