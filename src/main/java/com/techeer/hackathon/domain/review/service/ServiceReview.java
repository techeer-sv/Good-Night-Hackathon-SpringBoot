package com.techeer.hackathon.domain.review.service;

import com.techeer.hackathon.domain.review.dto.CreateReviewDTO;
import com.techeer.hackathon.domain.review.dto.mapper.ReviewMapper;
import com.techeer.hackathon.domain.review.entity.Review;
import com.techeer.hackathon.domain.review.repository.RepositoryReview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceReview {
    private final RepositoryReview Rev_Repo;
    private final ReviewMapper Rev_Mapper;

    public Review insertReview(CreateReviewDTO createReviewDTO) {
        return Rev_Repo.save(Rev_Mapper.ReviewDtoToEntity(createReviewDTO));
    }
}
