package com.project.hackathon.domain.review.service;

import com.project.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.project.hackathon.domain.restaurant.dto.RestaurantDetailResponse;
import com.project.hackathon.domain.restaurant.dto.RestaurantInfo;
import com.project.hackathon.domain.restaurant.dto.RestaurantUpdateRequest;
import com.project.hackathon.domain.restaurant.entity.Restaurant;
import com.project.hackathon.domain.restaurant.repository.RestaurantRepository;
import com.project.hackathon.domain.review.dto.ReviewCreateRequest;
import com.project.hackathon.domain.review.dto.ReviewDetailResponse;
import com.project.hackathon.domain.review.entity.Review;
import com.project.hackathon.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewDetailResponse create(ReviewCreateRequest reviewCreateRequest) {
        Review newReview =
                Review.builder()
                        .title(reviewCreateRequest.getTitle())
                        .content(reviewCreateRequest.getContent())
                        .build();

        reviewRepository.save(newReview);

        return ReviewDetailResponse.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .build();
    }
//
//    public RestaurantDetailResponse getRestaurantDetail(Long restaurantId) {
//        Restaurant restaurant =
//                RestaurantRepository.findRestaurantById(restaurantId);
//        return RestaurantDetailResponse.builder()
//                .title(restaurant.getTitle())
//                .category(restaurant.getCategory())
//                .createdAt(restaurant.getCreatedAt())
//                .build();
//    }
//
//    public List<RestaurantInfo> restaurantInfoList = new ArrayList<>();
//    public RestaurantDetailResponse getBoardListPage(int page, int size) {
//        final Pageable pageable = PageRequest.of(page, size);
//        Page<Restaurant> restaurantPageInfoList =
//                restaurantRepository.findRestaurantWithPagination(pageable);
//        return new RestaurantDetailResponse();
//    }
//
//    @Transactional
//    public RestaurantDetailResponse updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest) {
//        Long id = restaurantUpdateRequest.getId();
//        Restaurant restaurant =
//                restaurantRepository.findRestaurantById(id).orElseThrow(null);
//
//        return RestaurantDetailResponse.builder()
//                .title(restaurant.getTitle())
//                .category(restaurant.getCategory())
//                .createdAt(restaurant.getCreatedAt())
//                .build();
//    }
//
//    public void deleteRestaurant(Long restaurantId) {
//        Restaurant restaurant = RestaurantRepository.findRestaurantById(restaurantId);
//        restaurant.deleteRestaurant();
//        restaurantRepository.save(restaurant);
//    }
}