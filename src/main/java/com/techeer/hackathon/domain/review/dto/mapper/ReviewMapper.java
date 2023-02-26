package com.techeer.hackathon.domain.review.dto.mapper;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.repository.RestaurantRepository;
import com.techeer.hackathon.domain.review.dto.ReviewCreateDto;
import com.techeer.hackathon.domain.review.dto.ReviewResponseDto;
import com.techeer.hackathon.domain.review.entity.Review;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
@RequiredArgsConstructor
public class ReviewMapper {
    private final RestaurantRepository Rest_Repository;

    public Review DtoToEntity(ReviewCreateDto reviewCreateDto) {
        Restaurant restaurant = Rest_Repository.findById(reviewCreateDto.getRestaurantId()).orElseThrow(RuntimeException::new);
        return Review.builder()
                .title(reviewCreateDto.getTitle())
                .content(reviewCreateDto.getContent())
                .restaurant(restaurant)
                .build();
    }

    public ReviewResponseDto DtoFromEntity(Review review) {
        return ReviewResponseDto.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .restaurantName(review.getRestaurant().getName())
                .build();
    }

    public List<ReviewResponseDto> reviewResponseListFromEntity(Page<Review> reviewPage){
        List<ReviewResponseDto> reviewResponseList = reviewPage.stream().map(this::DtoFromEntity).collect(Collectors.toList());
        return reviewResponseList;
    }
}
