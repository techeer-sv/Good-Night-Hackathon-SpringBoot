package com.techeer.goodnight.domain.restaurant.service;

import com.techeer.goodnight.domain.restaurant.repository.RestaurantRepository;
import com.techeer.goodnight.domain.restaurant.dto.request.RestaruantCreateRequestDto;
import com.techeer.goodnight.domain.restaurant.dto.request.RestaruantUpdateRequestDto;
import com.techeer.goodnight.domain.restaurant.dto.response.RestaruantResponseDto;
import com.techeer.goodnight.domain.restaurant.entity.Restaurant;
import com.techeer.goodnight.domain.restaurant.exception.RestaurantIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Page<RestaruantResponseDto> getRestaurants(Pageable pageable, Optional<String> categoryName) {
        Page<Restaurant> restaurants = restaurantRepository.findAllWithCategoryName(pageable, categoryName);

        return restaurants.map(RestaruantResponseDto::new);
    }

    public RestaruantResponseDto create(RestaruantCreateRequestDto createRestaurantReq) {
        Restaurant restaurant = createRestaurantReq.toEntity();
        restaurantRepository.save(restaurant);

        return new RestaruantResponseDto(restaurant);
    }

    public RestaruantResponseDto findById(long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(RestaurantIdNotFoundException::new);

        return new RestaruantResponseDto(restaurant);
    }

    public Restaurant findByIdInner(long id) {
        return restaurantRepository.findById(id).orElseThrow(RestaurantIdNotFoundException::new);
    }

    public RestaruantResponseDto patchById(long id, RestaruantUpdateRequestDto patchRestaurantReq) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(RestaurantIdNotFoundException::new);

        restaurant.setCategoryName(patchRestaurantReq.getCategoryName());
        restaurantRepository.save(restaurant);

        return new RestaruantResponseDto(restaurant);
    }


    public void deleteById(long id) {
        Restaurant restaurant = this.findByIdInner(id);

        restaurant.setIsDeleted(true);
        restaurant.setDeletedAt(LocalDateTime.now());

        restaurantRepository.save(restaurant);
    }
}