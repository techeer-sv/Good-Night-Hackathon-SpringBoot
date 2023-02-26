package com.example.hackathon.review;

import com.example.hackathon.restaurant.domain.entity.Restaurant;
import com.example.hackathon.review.domain.entity.Review;
import com.example.hackathon.review.dto.ReviewChange;
import com.example.hackathon.review.dto.ReviewCreateDTO;
import org.springframework.stereotype.Component;


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

    /*
    public RestaurantResponse toDto(Restaurant restaurant) {
        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .category(restaurant.getCategory().name())
                .createdAt(restaurant.getCreatedDate())
                .build();
    }

    public List<RestaurantResponse> toDtoList (List<Restaurant> list) {
        // 스트림내 요소들에 대해 함수가 적용된 결과의 새로운 요소로 매핑해준다.
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }
     */
}
