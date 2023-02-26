package com.techeer.hackathon.domain.review.controller;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateDto;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantUpdateDto;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.service.RestaurantService;
import com.techeer.hackathon.domain.review.dto.ReviewCreateDto;
import com.techeer.hackathon.domain.review.dto.ReviewResponseDto;
import com.techeer.hackathon.domain.review.dto.ReviewUpdateDto;
import com.techeer.hackathon.domain.review.dto.mapper.ReviewMapper;
import com.techeer.hackathon.domain.review.entity.Review;
import com.techeer.hackathon.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/review")
@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService R_Service;
    private final ReviewMapper R_Mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ReviewResponseDto> createReview(
            @RequestBody @Valid ReviewCreateDto reviewCreateDto){
    Review insertReview = R_Service.insertReview(reviewCreateDto);
        return new ResponseEntity(R_Mapper.DtoFromEntity(insertReview), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ReviewResponseDto> updateReview(
            @Valid @RequestBody ReviewUpdateDto reviewUpdate){
        Review updateReview = R_Service.updateReview(reviewUpdate);
        return new ResponseEntity<>(R_Mapper.DtoFromEntity(updateReview), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReview(@PathVariable Long id) {
        R_Service.deleteReview(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> findOneReview(@PathVariable Long id) {
        Review findReview = R_Service.findOneReview(id);
        return new ResponseEntity<>(R_Mapper.DtoFromEntity(findReview), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> findReviewsBySearch(
            @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String title, @RequestParam(required = false) String content) {
        return ResponseEntity.ok(R_Service.findReviewsBySearch(page, size, title, content));
    }

}