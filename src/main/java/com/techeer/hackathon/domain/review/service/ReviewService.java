package com.techeer.hackathon.domain.review.service;

import com.techeer.hackathon.domain.review.dto.ReviewCreateDto;
import com.techeer.hackathon.domain.review.dto.ReviewUpdateDto;
import com.techeer.hackathon.domain.review.dto.mapper.ReviewMapper;
import com.techeer.hackathon.domain.review.entity.Review;
import com.techeer.hackathon.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository R_Repository;
    private final ReviewMapper R_Mapper;

    public Review insertReview(ReviewCreateDto reviewCreateDto) {
        return R_Repository.save(R_Mapper.DtoToEntity(reviewCreateDto));
    }

    public Review updateReview(ReviewUpdateDto reviewUpdate) {
        Review updateReview = R_Repository.findById(reviewUpdate.getId()).orElseThrow(NullPointerException::new);
        updateReview.update(reviewUpdate);
        return R_Repository.save(updateReview);
    }

    public void deleteReview(Long id) {
        Review review = R_Repository.findById(id).orElseThrow(NullPointerException::new);
        R_Repository.deleteById(review.getId());
    }

    public Review findOneReview(Long id) {
        return R_Repository.findById(id).orElseThrow(RuntimeException::new);
    }


    public Object findReviewsBySearch(Integer page, Integer size, String title, String content) {
        Pageable pageable = PageRequest.of(page, size);
        return R_Mapper.reviewResponseListFromEntity(R_Repository.findAllBySearch(title, content ,pageable));

    }
}
