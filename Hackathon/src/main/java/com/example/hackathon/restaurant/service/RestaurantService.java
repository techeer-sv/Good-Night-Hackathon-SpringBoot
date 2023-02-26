package com.example.hackathon.restaurant.service;

import com.example.hackathon.restaurant.RestaurantMapper;
import com.example.hackathon.restaurant.domain.entity.Category;
import com.example.hackathon.restaurant.domain.entity.Restaurant;
import com.example.hackathon.restaurant.domain.repository.RestaurantRepository;
import com.example.hackathon.restaurant.dto.RestaurantChange;
import com.example.hackathon.restaurant.dto.RestaurantCreateDTO;
import com.example.hackathon.restaurant.dto.RestaurantResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public void createRestaurant(RestaurantCreateDTO restaurantCreateDTO) {
        restaurantRepository.save(restaurantMapper.toEntity(restaurantCreateDTO));
    }

    public void changeRestaurantCategory(RestaurantChange request) {
        restaurantRepository.updateCategory(request.getId(), request.getCategory());
    }

    public List<RestaurantResponse> getRestaurantResponse(String categories) {
        String[] categoryArray = categories.split(",");
        List<Category> categoryList = new ArrayList<>();
        for(String category : categoryArray) {
            if(Category.isVaildCategory(category)) {
                categoryList.add(Category.getCategory(category));
            }
        }
        List<Restaurant> restaurants = restaurantRepository.findByCategory(categoryList);
        return restaurantMapper.toDtoList(restaurants);
    }

    public void deleteRestaurant(Long id){
        restaurantRepository.softDeleteById(id);
    }
}
