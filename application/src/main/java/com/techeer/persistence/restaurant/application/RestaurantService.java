package com.techeer.persistence.restaurant.application;

import com.techeer.persistence.restaurant.dao.RestaurantRepository;
import com.techeer.persistence.restaurant.dto.request.CreateRestaurantReq;
import com.techeer.persistence.restaurant.dto.request.PatchRestaurantReq;
import com.techeer.persistence.restaurant.dto.response.RestaurantDTO;
import com.techeer.persistence.restaurant.entity.Restaurant;
import com.techeer.persistence.restaurant.exception.RestaurantIdNotFoundException;
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

  public RestaurantDTO findById(long id) {
    Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(RestaurantIdNotFoundException::new);

    return new RestaurantDTO(restaurant);
  }

  public RestaurantDTO patchById(long id, PatchRestaurantReq patchRestaurantReq) {
    Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(RestaurantIdNotFoundException::new);

    restaurant.setCategoryName(patchRestaurantReq.getCategoryName());
    restaurantRepository.save(restaurant);

    return new RestaurantDTO(restaurant);
  }

}
