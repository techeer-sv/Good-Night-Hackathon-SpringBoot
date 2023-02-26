package com.example.hackathon.review;

import com.example.hackathon.restaurant.domain.entity.Restaurant;
import com.example.hackathon.review.domain.entity.Review;
import com.example.hackathon.review.dto.ReviewChange;
import com.example.hackathon.review.dto.ReviewCreateDTO;
import com.example.hackathon.review.dto.ReviewInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ReviewMapper {
    public Review toEntity (ReviewCreateDTO request, Restaurant restaurant) {
        return Review.builder()
                .restaurant(restaurant)
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public Review toEntity (ReviewChange request, Restaurant restaurant) {
        return Review.builder()
                .restaurant(restaurant)
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public ReviewInfo toDto(Review review) {
        return ReviewInfo.builder()
                .RestaurantName(review.getRestaurant().getName())
                .title(review.getTitle())
                .content(review.getContent())
                .build();
    }

    public List<ReviewInfo> toDtoList(List<Review> list){
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }

}
