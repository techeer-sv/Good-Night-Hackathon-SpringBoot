//package com.techeer.hackathon.domain.review.service;
//
//import com.techeer.hackathon.domain.restaurant.domain.entity.Restaurant;
//import com.techeer.hackathon.domain.restaurant.domain.repository.RestaurantRepository;
//import com.techeer.hackathon.domain.review.domain.entity.Review;
//import com.techeer.hackathon.domain.review.domain.repository.ReviewRepository;
//import com.techeer.hackathon.domain.review.dto.*;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.*;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class ReviewService {
//    private final ReviewRepository reviewRepository;
//    private final RestaurantRepository restaurantRepository;
//
//    @Transactional
//    public ReviewDetailResponseDto create(ReviewRequestDto reviewRequestDto) {
//        final Restaurant restaurant = loadRestaurantInfoWithId(reviewRequestDto.getRestaurantId());
//        final Review newReview =
//                Review.builder()
//                        .title(reviewRequestDto.getTitle())
//                        .content(reviewRequestDto.getContent())
//                        .restaurant(restaurant)
//                        .build();
//        reviewRepository.save(newReview);
//
//        return ReviewDetailResponseDto.builder()
//                .restaurantName(restaurant.getName())
//                .title(newReview.getTitle())
//                .content(newReview.getContent())
//                .build();
//    }
//
//    public ReviewDetailResponseDto getReviewDetail(Long ReviewId) {
//        Optional<Review> review = reviewRepository.findReviewById(ReviewId);
//        return ReviewDetailResponseDto.builder()
//                .title(review.get().getTitle())
//                .content(review.get().getContent())
//                .restaurantName(review.get().getRestaurant().getName())
//                .build();
//    }
//
//    public ReviewListResponseDto getReviewListPage(int page, int size, boolean isTimeReserved) {
//        final Pageable pageable = PageRequest.of(page, size);
//        List<ReviewPreviewInfo> reviewPreviewInfoList =
//                reviewRepository.findReviewPreviewInfoListPage(pageable, isTimeReserved);
//
//        return new ReviewListResponseDto(reviewPreviewInfoList);
//    }
//
//    public ReviewListResponseDto searchReviewWithTitleOrContent(
//            int page, int size, boolean isTimeReserved, String keyword) {
//        final Pageable pageable = PageRequest.of(page, size);
//        List<ReviewPreviewInfo> reviewPreviewInfoList = reviewRepository.getReviewListSearchTitleOrContent(
//                pageable, isTimeReserved, keyword);
//
//        return new ReviewListResponseDto(reviewPreviewInfoList);
//    }
//
//    @Transactional
//    public ReviewDetailResponseDto updateReview(ReviewUpdateRequestDto updateRequest){
//
//    }
//
//
//    private Restaurant loadRestaurantInfoWithId(Long restaurantId) {
//        return RestaurantRepository.findByRestaurantId(restaurantId);
//    }
//}
