package com.techeer.persistence.restaurant.application;

import com.techeer.persistence.restaurant.dao.RestaurantRepository;
import com.techeer.persistence.restaurant.dto.request.CreateRestaurantReq;
import com.techeer.persistence.restaurant.dto.response.RestaurantDTO;
import com.techeer.persistence.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RestaurantService {
  private final RestaurantRepository restaurantRepository;

  public RestaurantDTO create(CreateRestaurantReq createRestaurantReq) {
    Restaurant restaurant = createRestaurantReq.toEntity();
    restaurantRepository.save(restaurant);

    return new RestaurantDTO(restaurant);
  }

}
