package com.techeer.hackathon.domain.review.mapper;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.review.dto.ReviewCreate;
import com.techeer.hackathon.domain.review.dto.ReviewInfo;
import com.techeer.hackathon.domain.review.dto.ReviewUpdateRequest;
import com.techeer.hackathon.domain.review.entity.Review;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewMapper {
    public Review toEntity(ReviewCreate request, Restaurant restaurant) {
        return Review.builder()
                .restaurant(restaurant)
                .content(request.getContent())
                .title(request.getTitle())
                .build();
    }

    public Review toEntity(ReviewUpdateRequest request, Restaurant restaurant) {
        return Review.builder()
                .restaurant(restaurant)
                .content(request.getContent())
                .title(request.getTitle())
                .build();
    }



    public ReviewInfo toDto(Review review) {
        return ReviewInfo.builder()
                .restaurantName(review.getRestaurant().getName())
                .content(review.getContent())
                .title(review.getTitle())
                .build();
    }

    public List<ReviewInfo> toDtoList(List<Review> list) {
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }
}
