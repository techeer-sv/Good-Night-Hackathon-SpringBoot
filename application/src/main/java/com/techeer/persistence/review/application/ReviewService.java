package com.techeer.persistence.review.application;

import com.techeer.persistence.restaurant.application.RestaurantService;
import com.techeer.persistence.restaurant.entity.Restaurant;
import com.techeer.persistence.review.dao.ReviewRepository;

import com.techeer.persistence.review.dto.request.ReviewReq;
import com.techeer.persistence.review.dto.response.ReviewDTO;
import com.techeer.persistence.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

  private final ReviewRepository reviewRepository;
  private final RestaurantService restaurantService;


  public ReviewDTO create(ReviewReq reviewReq) {
    Restaurant restaurant = restaurantService.findByIdInner(reviewReq.getRestaurantId());

    Review review = reviewReq.toEntity(restaurant);

    reviewRepository.save(review);

    return new ReviewDTO(review, restaurant);
  }
}
