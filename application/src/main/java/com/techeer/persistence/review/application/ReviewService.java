package com.techeer.persistence.review.application;

import com.techeer.persistence.restaurant.application.RestaurantService;
import com.techeer.persistence.restaurant.entity.Restaurant;
import com.techeer.persistence.review.dao.ReviewRepository;

import com.techeer.persistence.review.dto.request.PatchReviewReq;
import com.techeer.persistence.review.dto.request.ReviewReq;
import com.techeer.persistence.review.dto.response.ReviewDTO;
import com.techeer.persistence.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


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

  @Transactional(readOnly = true)
  public Page<ReviewDTO> findAll(Pageable pageable, Optional<String> keyword) {
    if(keyword.isEmpty()) {
      Page<Review> reviews = reviewRepository.findAll(pageable);

      return reviews.map(review -> new ReviewDTO(review, review.getRestaurant()));
    }

    Page<Review> reviews = reviewRepository.findAllWithKeyword(pageable, keyword);

    return reviews.map(review -> new ReviewDTO(review, review.getRestaurant()));
  }

  public ReviewDTO findById(long id) {
    Review review = reviewRepository.findById(id).orElseThrow();

    return new ReviewDTO(review, review.getRestaurant());
  }


  public ReviewDTO patchById(long id, PatchReviewReq patchReviewReq) {
    Review review = reviewRepository.findById(id).orElseThrow();

    review.setTitle(patchReviewReq.getTitle());
    review.setDescription(patchReviewReq.getDescription());

    reviewRepository.save(review);

    return new ReviewDTO(review, review.getRestaurant());
  }

  public void deleteById(long id) {
    reviewRepository.deleteById(id);
  }
}
