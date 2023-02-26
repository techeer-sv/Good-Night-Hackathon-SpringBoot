package com.techeer.goodnighthackathonspringboot.domain.review.controller;

import com.techeer.goodnighthackathonspringboot.domain.review.dto.ReviewCreateRequest;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.ReviewInfo;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.ReviewUpdateRequest;
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
    public ResponseEntity<ReviewInfo> register(
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
}
