package com.techeer.hackathon.domain.review.dto.mapper;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.repository.RepositoryRestaurant;
import com.techeer.hackathon.domain.review.dto.CreateReviewDTO;
import com.techeer.hackathon.domain.review.dto.InquiryReviewDTO;
import com.techeer.hackathon.domain.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class ReviewMapper {
    private final RepositoryRestaurant Res_Repo;
    public Review ReviewDtoToEntity(CreateReviewDTO createReviewDTO) {
        Restaurant restaurant = Res_Repo.findById(createReviewDTO.getRestaurantId()).orElseThrow(RuntimeException::new);
        return Review.builder()
                .title(createReviewDTO.getTitle())
                .content(createReviewDTO.getContent())
                .restaurant(restaurant)
                .build();
    }
    public InquiryReviewDTO ReviewEntityToDto(Review review) {
        return InquiryReviewDTO.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .restaurantName(review.getRestaurant().getName())
                .build();
    }

    public List<InquiryReviewDTO> inquiryReviewDTOListFromEntity(Page<Review> reviewPage) {
        List<InquiryReviewDTO> inquiryReviewDTOList = reviewPage.stream().map(this::ReviewEntityToDto).collect(Collectors.toList());
        return inquiryReviewDTOList;
    }
}
