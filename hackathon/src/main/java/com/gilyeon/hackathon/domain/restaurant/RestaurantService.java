package com.gilyeon.hackathon.domain.restaurant;

import com.gilyeon.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.gilyeon.hackathon.domain.restaurant.dto.RestaurantInfo;
import com.gilyeon.hackathon.domain.restaurant.dto.RestaurantUpdateRequest;
import com.gilyeon.hackathon.domain.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void createRestaurant(RestaurantCreateRequest restaurantCreateRequest) {
        Restaurant restaurant = mapRestaurantEntityCreateRequestToRestaurant(restaurantCreateRequest);
        restaurantRepository.save(restaurant);
    }

//    @Transactional(readOnly = true)
//    public RestaurantInfo getRestaurants() {
//        Restaurant foundRestaurant = restaurantRepository.findAll();
//
//        return
//    }

    @Transactional(readOnly = true)
    public RestaurantInfo getRestaurantDetail(Long id) {
        Restaurant findRestaurant = restaurantRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return mapRestaurantEntityToRestaurantInfo(findRestaurant);
    }
    

    @Transactional
    public RestaurantInfo updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest) {
        Restaurant findRestaurant = restaurantRepository.findById(restaurantUpdateRequest.getId())
                .orElseThrow(EntityNotFoundException::new);

        findRestaurant.update(restaurantUpdateRequest);

        Restaurant savedRestaurant = restaurantRepository.save(findRestaurant);

        return mapRestaurantEntityToRestaurantInfo(savedRestaurant);
    }

    @Transactional
    public void deleteRestaurant(Long id) {
        Restaurant findRestaurant = restaurantRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        findRestaurant.deleteRestaurant();
        restaurantRepository.save(findRestaurant);
    }


    public Restaurant mapRestaurantEntityCreateRequestToRestaurant(RestaurantCreateRequest restaurantCreateRequest) {
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
