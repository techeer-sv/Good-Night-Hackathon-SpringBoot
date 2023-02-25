package com.techeergroup2.goodnight.domain.review.controller;

import com.techeergroup2.goodnight.domain.review.domain.Review;
import com.techeergroup2.goodnight.domain.review.dto.ReviewCreateRequest;
import com.techeergroup2.goodnight.domain.review.dto.ReviewCreateResponse;
import com.techeergroup2.goodnight.domain.review.dto.ReviewGetResponse;
import com.techeergroup2.goodnight.domain.review.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RequestMapping("/api/v1/reviews")
@AllArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    //    CREATE

//     id is the restaurant id
    @PostMapping("{id}")
    public ReviewCreateResponse createReview(@PathVariable Long id, @RequestBody ReviewCreateRequest request) {
        return reviewService.createReview(id, request);
    }

//    READ
    @GetMapping("{id}")
    public ReviewCreateResponse getReview(@PathVariable Long id) {
        return reviewService.getReview(id);
    }

//    UPDATE
    @PutMapping("{id}")
    public ReviewCreateResponse updateReview(@PathVariable Long id, @RequestBody ReviewCreateRequest request) {
        return reviewService.updateReview(id, request);
    }

//    DELETE
    @DeleteMapping ("{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

//    GET ALL
    @GetMapping
    public List<Review> getAllReviews(Pageable pageable) {
        return reviewService.getAllReviews(pageable);
    }
}
