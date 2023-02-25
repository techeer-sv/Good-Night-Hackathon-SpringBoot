package techeer.restaurant.domain.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import techeer.restaurant.domain.restaurant.dto.RestaurantCreateRequest;
import techeer.restaurant.domain.restaurant.dto.RestaurantInfo;
import techeer.restaurant.domain.restaurant.entity.Restaurant;
import techeer.restaurant.domain.restaurant.repository.RestaurantRepository;

@Service
@RequiredArgsConstructor
public class RestaurantService {


    private final RestaurantRepository restaurantRepository;

    public RestaurantInfo createRestaurant(RestaurantCreateRequest restaurantCreateRequest) {
        Restaurant newRestaurant = convertRestaurantFromRequest(restaurantCreateRequest);
        Restaurant savedRestaurant = restaurantRepository.save(newRestaurant);
        return mapRestaurantEntityToRestaurantInfoResponse(savedRestaurant);
    }

    private RestaurantInfo mapRestaurantEntityToRestaurantInfoResponse(Restaurant savedRestaurant) {
        return RestaurantInfo.builder()
                .name(savedRestaurant.getName())
                .category(savedRestaurant.getCategory())
                .createdAt(savedRestaurant.getCreatedAt())
                .updatedAt(savedRestaurant.getUpdatedAt())
                .build();
    }


    private Restaurant convertRestaurantFromRequest(RestaurantCreateRequest restaurantCreateRequest) {
        return Restaurant.builder()
                .name(restaurantCreateRequest.getName())
                .category(restaurantCreateRequest.getCategory())
                .build();
    }
}
