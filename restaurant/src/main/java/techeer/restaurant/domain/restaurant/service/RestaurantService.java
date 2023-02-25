package techeer.restaurant.domain.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import techeer.restaurant.domain.restaurant.dto.RestaurantCreateRequest;
import techeer.restaurant.domain.restaurant.dto.RestaurantInfo;
import techeer.restaurant.domain.restaurant.dto.RestaurantInfoList;
import techeer.restaurant.domain.restaurant.entity.Restaurant;
import techeer.restaurant.domain.restaurant.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {


    private final RestaurantRepository restaurantRepository;
    public RestaurantInfoList getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAllRestaurant();
        List<RestaurantInfo> restaurantInfos = new ArrayList<>();
        for(int i = 0; i < restaurants.size(); i++) {
            restaurantInfos.add(RestaurantInfo.builder()
                    .name(restaurants.get(i).getName())
                    .category(restaurants.get(i).getCategory())
                    .createdAt(restaurants.get(i).getCreatedAt())
                    .updatedAt(restaurants.get(i).getUpdatedAt())
                    .build());
        }

        return new RestaurantInfoList(restaurantInfos);
    }


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


    public RestaurantInfo findRestaurantInfoById(Long id) {
        Restaurant foundRestaurant = findRestaurantById(id);
        restaurantRepository.save(foundRestaurant);
        return mapRestaurantEntityToRestaurantInfoResponse(foundRestaurant);
    }


    public void deleteRestaurant(Long id) {
        Restaurant foundRestaurant = findRestaurantById(id);
        foundRestaurant.deleteRestaurant();
        restaurantRepository.save(foundRestaurant);
    }


    private Restaurant findRestaurantById(Long id) {
        return restaurantRepository.findRestaurantById(id);
    }
}
