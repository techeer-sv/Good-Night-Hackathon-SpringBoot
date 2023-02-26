package com.techeer.hackathon.domain.review.service;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.repository.RepositoryRestaurant;
import com.techeer.hackathon.domain.review.dto.CreateReviewDTO;
import com.techeer.hackathon.domain.review.dto.InquiryReviewDTO;
import com.techeer.hackathon.domain.review.dto.UpdateReviewDTO;
import com.techeer.hackathon.domain.review.dto.mapper.ReviewMapper;
import com.techeer.hackathon.domain.review.entity.Review;
import com.techeer.hackathon.domain.review.repository.RepositoryReview;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceReview {
    private final RepositoryReview Rev_Repo;
    private final ReviewMapper Rev_Mapper;
    private final RepositoryRestaurant Res_Repo;

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

    public InquiryReviewDTO updateReview(Long id, UpdateReviewDTO updateReviewDTO) {
        Review review = Rev_Repo.findById(id)
                .orElseThrow(() -> new RuntimeException());

        review.setTitle(updateReviewDTO.getTitle());
        review.setContent(updateReviewDTO.getContent());

        Restaurant restaurant = Res_Repo.findById(review.getRestaurant().getId())
                .orElseThrow(() -> new RuntimeException());
        InquiryReviewDTO inquiryReviewDTO = InquiryReviewDTO.builder()
                .id(review.getId())
                .restaurantName(restaurant.getName())
                .title(review.getTitle())
                .content(review.getContent())
                .build();
        return inquiryReviewDTO;
    }

    public Object getReviewForSearch(Integer page, Integer size, String title, String content) {
        Pageable pageable = PageRequest.of(page, size);
        return Rev_Mapper.inquiryReviewDTOListFromEntity(Rev_Repo.findAllBySearch(title, content, pageable));
    }

    public List<Review> getReviewsByCreatedTime() {
        return Rev_Repo.findAllByOrderByCreatedAtAsc();
    }

    public List<Review> getReviewsByReverseCreatedTime() {
        return Rev_Repo.findAllByOrderByCreatedAtDesc();
    }

}
