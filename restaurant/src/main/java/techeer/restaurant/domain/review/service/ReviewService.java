package techeer.restaurant.domain.review.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import techeer.restaurant.domain.restaurant.dto.RestaurantInfo;
import techeer.restaurant.domain.restaurant.entity.Restaurant;
import techeer.restaurant.domain.restaurant.repository.RestaurantRepository;
import techeer.restaurant.domain.review.dto.ReviewInfo;
import techeer.restaurant.domain.review.dto.ReviewRequest;
import techeer.restaurant.domain.review.dto.UpdateReviewRequest;
import techeer.restaurant.domain.review.entity.Review;
import techeer.restaurant.domain.review.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    public ReviewInfo createReview(ReviewRequest request) {
        Review newReview = convertReviewFromRequest(request);
        Review savedReview = reviewRepository.save(newReview);
        return mapReviewEntityToReviewInfoResponse(savedReview);
    }

    private Review convertReviewFromRequest(ReviewRequest request) {
        Restaurant foundRestaurant = getRestaurantById(request.getRestaurantId());

        return Review.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .restaurant(foundRestaurant)
                .build();
    }

    private Restaurant getRestaurantById(Long restaurantId) {
        return restaurantRepository.findRestaurantById(restaurantId);
    }

    private ReviewInfo mapReviewEntityToReviewInfoResponse(Review review) {
        return ReviewInfo.builder()
                .title(review.getTitle())
                .content(review.getContent())
                .restaurant(review.getRestaurant().getName())
                .build();
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public void updateReviewInfo(Long id, UpdateReviewRequest request) {
        Review review = reviewRepository.findReviewById(id);
        review.updateTitle(request.getTitle());
        review.updateContent(request.getContent());
        reviewRepository.save(review);
    }

    public ReviewInfo findReviewInfoById(Long id) {
        Review review = findReviewById(id);
        reviewRepository.save(review);
        return mapReviewEntityToReviewInfoResponse(review);
    }

    public Review findReviewById(Long id) {
        return reviewRepository.findReviewById(id);
    }

    public List<ReviewInfo> getReviews(int page, String title, String content, String sort) {
        PageRequest pageRequest = PageRequest.of(page - 1, 5, Sort.Direction.fromString(sort), "createdAt");

        Page<Review> reviewsPage = null;


        if (title != null && content != null && sort.equals("desc")) {
            reviewsPage = reviewRepository.findByTitleContainingIgnoreCaseAndContentContainingIgnoreCaseOrderByCreatedAtDesc(title,content,pageRequest);
        } else if (title != null && content != null && sort.equals("asc")) {
            reviewsPage = reviewRepository.findByTitleContainingIgnoreCaseAndContentContainingIgnoreCaseOrderByCreatedAtAsc(title,content,pageRequest);
        } else if (title != null && sort.equals("desc")) {
            reviewsPage = reviewRepository.findByTitleContainingIgnoreCaseOrderByCreatedAtDesc(title, pageRequest);
        } else if (title != null && sort.equals("asc")) {
            reviewsPage = reviewRepository.findByTitleContainingIgnoreCaseOrderByCreatedAtAsc(title, pageRequest);
        } else if (content != null && sort.equals("desc")) {
            reviewsPage = reviewRepository.findByContentContainingIgnoreCaseOrderByCreatedAtDesc(content, pageRequest);
        } else if (content != null && sort.equals("asc")) {
            reviewsPage = reviewRepository.findByContentContainingIgnoreCaseOrderByCreatedAtAsc(content, pageRequest);
        } else if (sort.equals("desc")) {
            reviewsPage = reviewRepository.findAllByOrderByCreatedAtDesc(pageRequest);
        } else if (sort.equals("asc")) {
            reviewsPage = reviewRepository.findAllByOrderByCreatedAtAsc(pageRequest);
        }


        List<Review> reviews = reviewsPage.getContent();
        List<ReviewInfo> reviewInfos = new ArrayList<>();
        for(int i = 0; i < reviews.size(); i++) {
            reviewInfos.add(mapReviewEntityToReviewInfoResponse(reviews.get(i)));
        }
        return reviewInfos;
    }
}
