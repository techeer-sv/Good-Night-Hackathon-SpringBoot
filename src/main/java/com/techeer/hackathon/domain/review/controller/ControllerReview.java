package com.techeer.hackathon.domain.review.controller;

import com.techeer.hackathon.domain.review.dto.CreateReviewDTO;
import com.techeer.hackathon.domain.review.dto.InquiryReviewDTO;
import com.techeer.hackathon.domain.review.dto.UpdateReviewDTO;
import com.techeer.hackathon.domain.review.dto.mapper.ReviewMapper;
import com.techeer.hackathon.domain.review.entity.Review;
import com.techeer.hackathon.domain.review.service.ServiceReview;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1/review")
@RestController
@RequiredArgsConstructor
public class ControllerReview {
    private final ServiceReview Rev_Serv;
    private final ReviewMapper Rev_Mapper;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<InquiryReviewDTO> createReview(
            @RequestBody @Valid CreateReviewDTO createReviewDTO) {
        Review insertReview = Rev_Serv.insertReview(createReviewDTO);
        return new ResponseEntity(Rev_Mapper.ReviewEntityToDto(insertReview), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InquiryReviewDTO> getReview(@PathVariable Long id) {
        InquiryReviewDTO review = Rev_Serv.getReview(id);
        return ResponseEntity.ok().body(review);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable("id") Long id) {
        Rev_Serv.deleteReview(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InquiryReviewDTO> updateReview(@PathVariable Long id, @RequestBody UpdateReviewDTO updateReviewDTO) {
        InquiryReviewDTO result = Rev_Serv.updateReview(id, updateReviewDTO);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
