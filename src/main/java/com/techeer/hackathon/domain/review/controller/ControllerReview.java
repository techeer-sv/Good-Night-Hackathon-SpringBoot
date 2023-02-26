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
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/search")
    public ResponseEntity<Object> getReviewsForSearch(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content) {
        return ResponseEntity.ok(Rev_Serv.getReviewForSearch(page, size, title, content));
    }

    @GetMapping("/list")
    public List<InquiryReviewDTO> getReviewsByCreatedTime() {
        List<Review> reviews = Rev_Serv.getReviewsByCreatedTime();
        return reviews.stream()
                .map(this::mapToInquiryReviewDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/list/reverse")
    public List<InquiryReviewDTO> getReviewsByReverseCreatedTime() {
        List<Review> reviews = Rev_Serv.getReviewsByReverseCreatedTime();
        return reviews.stream()
                .map(this::mapToInquiryReviewDTO)
                .collect(Collectors.toList());
    }
    private InquiryReviewDTO mapToInquiryReviewDTO(Review review) {
        return InquiryReviewDTO.builder()
                .id(review.getId())
                .restaurantName(review.getRestaurant().getName())
                .title(review.getTitle())
                .content(review.getContent())
                .build();
    }
}
