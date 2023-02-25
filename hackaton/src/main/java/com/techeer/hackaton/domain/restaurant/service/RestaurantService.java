package com.techeer.hackaton.domain.restaurant.service;

import com.techeer.hackaton.domain.restaurant.dto.RestaurantCreateRequest;
import com.techeer.hackaton.domain.restaurant.dto.RestaurantInfo;
import com.techeer.hackaton.domain.restaurant.dto.RestaurantUpdateRequest;
import com.techeer.hackaton.domain.restaurant.entity.Restaurant;
import com.techeer.hackaton.domain.restaurant.entity.RestaurantCategory;
import com.techeer.hackaton.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void createRestaurant(RestaurantCreateRequest restaurantCreateRequest) {
        Restaurant restaurant = mapRestaurantCreateRequestToRestaurantEntity(restaurantCreateRequest);
        restaurantRepository.save(restaurant);
    }


    @Transactional(readOnly = true)
    public RestaurantInfo getRestaurantDetail(Long id) {
        Restaurant foundRestaurant = restaurantRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return mapRestaurantEntityToRestaurantInfo(foundRestaurant);
    }

    @Transactional(readOnly = true)
    public List<RestaurantInfo> getRestaurantListByPagination(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return restaurantRepository.findRestaurantsWithPagination(pageRequest).stream()
                .map(this::mapRestaurantEntityToRestaurantInfo)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RestaurantInfo> getRestaurantsByCategoryWithPagination(int page, int size, RestaurantCategory category) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return restaurantRepository.findRestaurantsByCategoryWithPagination(pageRequest, category).stream()
                .map(this::mapRestaurantEntityToRestaurantInfo)
                .collect(Collectors.toList());
    }

    @Transactional
    public RestaurantInfo updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest) {
        Restaurant foundRestaurant = restaurantRepository.findById(restaurantUpdateRequest.getId())
                .orElseThrow(EntityNotFoundException::new);

        foundRestaurant.update(restaurantUpdateRequest);

        Restaurant savedRestaurant = restaurantRepository.save(foundRestaurant);

        return mapRestaurantEntityToRestaurantInfo(savedRestaurant);
    }

    @Transactional
    public void deleteRestaurant(Long id) {
        Restaurant foundRestaurant = restaurantRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        foundRestaurant.deleteRestaurant();
        restaurantRepository.save(foundRestaurant);
    }

    public Restaurant mapRestaurantCreateRequestToRestaurantEntity(RestaurantCreateRequest restaurantCreateRequest) {
        return Restaurant.builder()
                .category(restaurantCreateRequest.getCategory())
                .name(restaurantCreateRequest.getName())
                .build();
    }

    public RestaurantInfo mapRestaurantEntityToRestaurantInfo(Restaurant restaurant) {
        return RestaurantInfo.builder()
                .createdDate(restaurant.getCreatedAt())
                .category(restaurant.getCategory())
                .name(restaurant.getName())
                .build();
    }

}
