package com.gilyeon.hackathon.domain.review;

import com.gilyeon.hackathon.domain.review.dto.ReviewCreateRequest;
import com.gilyeon.hackathon.domain.review.dto.ReviewInfo;
import com.gilyeon.hackathon.domain.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public ReviewInfo getReviewDetail(Long id) {
        Review findReview = reviewRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return mapReviewEntityToReviewInfo(findReview);
    }

    public Review mapReviewEntityCreateRequestToReview(ReviewCreateRequest reviewCreateRequest) {
        return Review.builder()
                .content(reviewCreateRequest.getContent())
                .title(reviewCreateRequest.getTitle())
                .build();
    }

    public ReviewInfo mapReviewEntityToReviewInfo(Review review) {
        return ReviewInfo.builder()
                .createdDate(review.getCreatedAt())
                .content(review.getContent())
                .title(review.getTitle())
                .build();
    }

}
