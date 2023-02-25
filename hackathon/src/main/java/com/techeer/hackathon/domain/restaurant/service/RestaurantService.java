package com.techeer.hackathon.domain.restaurant.service;

import com.techeer.hackathon.domain.restaurant.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantChange;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreate;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponse;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.entity.RestaurantCategory;
import com.techeer.hackathon.domain.restaurant.error.InvalidCategoryException;
import com.techeer.hackathon.domain.restaurant.error.RestaurantDuplicateException;
import com.techeer.hackathon.domain.restaurant.repository.RestaurantRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public void createRestaurant(RestaurantCreate restaurantCreate) {
        if(restaurantRepository.existsByName(restaurantCreate.getName())) {
            throw new RestaurantDuplicateException();
        }
        if(restaurantCreate.getCategory() == null) {
            throw new InvalidCategoryException();
        }
        restaurantRepository.save(restaurantMapper.toEntity(restaurantCreate));
    }

    public void changeCategory(RestaurantChange request) {
        if(request.getCategory() == null) {
            throw new InvalidCategoryException();
        }
        restaurantRepository.updateCategory(request.getId(), request.getCategory());
    }

    public List<RestaurantResponse> getRestaurantResponse(String categories) {
        String[] categoryArray = categories.split(",");
        List<RestaurantCategory> categoriesList = new ArrayList<>();
        for (String category : categoryArray) {
            if(RestaurantCategory.isValidCategory(category)) {
                categoriesList.add(RestaurantCategory.getCategory(category));
            }
            else throw new InvalidCategoryException();
        }
        List<Restaurant> restaurants = restaurantRepository.findByCategory(categoriesList);
        return restaurantMapper.toDtoList(restaurants);
    }
}
