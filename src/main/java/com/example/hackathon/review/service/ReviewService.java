package com.example.hackathon.review.service;

import com.example.hackathon.restaurant.domain.entity.Restaurant;
import com.example.hackathon.restaurant.service.RestaurantService;
import com.example.hackathon.review.domain.entity.Review;
import com.example.hackathon.review.domain.repository.ReviewRepository;
import com.example.hackathon.review.dto.ReviewRequest;
import com.example.hackathon.review.dto.ReviewResponse;
import com.example.hackathon.review.dto.ReviewUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository repository;
    private final RestaurantService restaurantService;

    public ReviewResponse save(ReviewRequest request) {
        Restaurant restaurant = restaurantService.findEntity(request.getRestaurantId());
        Review entity = repository.save(request.toEntity(restaurant));
        return ReviewResponse.of(entity);
    }

    public List<ReviewResponse> findAllWithPagination(
            Integer page,
            Integer size,
            String title,
            String content,
            boolean descending
    ) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                descending ? Sort.by("createdAt").descending() : Sort.by("createdAt").ascending()
        );

        return repository.findAllWithFieldQuery(
                        title,
                        content,
                        pageRequest
                )
                .stream()
                .map(ReviewResponse::of)
                .collect(Collectors.toList());
    }

    private Review findEntity(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("리뷰를 찾을 수 없습니다."));
    }

    public ReviewResponse findById(Integer id) {
        return ReviewResponse.of(findEntity(id));
    }

    @Transactional
    public ReviewResponse update(Integer id, ReviewUpdateRequest request) {
        Review entity = findEntity(id);
        entity.update(request);
        return ReviewResponse.of(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
