package com.example.hackathon.review.controller;

import com.example.hackathon.review.dto.ReviewRequest;
import com.example.hackathon.review.dto.ReviewResponse;
import com.example.hackathon.review.dto.ReviewUpdateRequest;
import com.example.hackathon.review.service.ReviewService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse save(
            @Validated @RequestBody ReviewRequest request
    ) {
        return service.save(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponse> findAll(
            @Min(value = 1) @Validated @RequestParam(required = false) Optional<Integer> page,
            @Min(value = 1) @Validated @RequestParam(required = false) Optional<Integer> size,
            @RequestParam(required = false) Optional<String> title,
            @RequestParam(required = false) Optional<String> content,
            @RequestParam(required = false) Optional<Boolean> descending
    ) {
        return service.findAllWithPagination(
                page.orElse(0),
                size.orElse(10),
                title.orElse(""),
                content.orElse(""),
                descending.orElse(false)
        );
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponse findById(
            @PathVariable Integer id
    ) {
        return service.findById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse update(
            @PathVariable Integer id,
            @RequestBody ReviewUpdateRequest request
    ) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Integer id
    ) {
        service.delete(id);
    }
}
