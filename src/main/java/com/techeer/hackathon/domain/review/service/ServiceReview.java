package com.techeer.hackathon.domain.review.service;

import com.techeer.hackathon.domain.review.dto.CreateReviewDTO;
import com.techeer.hackathon.domain.review.dto.InquiryReviewDTO;
import com.techeer.hackathon.domain.review.dto.mapper.ReviewMapper;
import com.techeer.hackathon.domain.review.entity.Review;
import com.techeer.hackathon.domain.review.repository.RepositoryReview;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class ServiceReview {
    private final RepositoryReview Rev_Repo;
    private final ReviewMapper Rev_Mapper;

    public Review insertReview(CreateReviewDTO createReviewDTO) {
        return Rev_Repo.save(Rev_Mapper.ReviewDtoToEntity(createReviewDTO));
    }

    public InquiryReviewDTO getReview(Long id) {
        Review review = Rev_Repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Review not found"));
        return Rev_Mapper.ReviewEntityToDto(review);
    }

    public void deleteReview(Long id) {
        Review review = Rev_Repo.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Review is not found"));
        review.setDeleted(true);
        Rev_Repo.delete(review);
    }
}
