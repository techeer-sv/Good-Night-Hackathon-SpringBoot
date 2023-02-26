package com.techeer.hackathon.domain.review.mapper;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.review.dto.ReviewCreate;
import com.techeer.hackathon.domain.review.dto.ReviewInfo;
import com.techeer.hackathon.domain.review.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review toEntity(ReviewCreate request, Restaurant restaurant) {
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

//    public RestaurantResponse toDto(Restaurant restaurant) {
//
//        return RestaurantResponse.builder()
//                .category(restaurant.getCategory().name())
//                .name(restaurant.getName())
//                .createdAt(restaurant.getCreatedAt())
//                .build();
//    }
//
//    public List<RestaurantResponse> toDtoList(List<Restaurant> list) {
//        return list.stream().map(this::toDto).collect(Collectors.toList());
//    }
}
