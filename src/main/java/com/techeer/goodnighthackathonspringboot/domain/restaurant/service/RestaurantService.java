package com.techeer.goodnighthackathonspringboot.domain.restaurant.service;

import com.techeer.goodnighthackathonspringboot.domain.restaurant.dao.RestaurantRepository;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.domain.Restaurant;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.RestaurantPageInfo;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.RestaurantInfo;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.exception.NotFoundRestaurantException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper mapper;

    public RestaurantInfo create(RestaurantInfo restaurantInfo){
        Restaurant entity = Restaurant.builder()
                .name(restaurantInfo.getName())
                .category(restaurantInfo.getCategory())
                .build();
        return mapper.mapEntityToInfo(restaurantRepository.save(entity));
    }

    public RestaurantInfo update(RestaurantInfo restaurantInfo) {
        Restaurant foundRestaurant = restaurantRepository
                .findById(restaurantInfo.getId())
                .orElseThrow(NotFoundRestaurantException::new);
        foundRestaurant.update(restaurantInfo);
        return mapper.mapEntityToInfo(restaurantRepository.save(foundRestaurant));
    }

    @Transactional(readOnly = true)
    public RestaurantPageInfo getRestaurantByPagination(int offset, int size) {
        PageRequest pageRequest = PageRequest.of(offset, size);
        Page<Restaurant> restaurantByPagination = restaurantRepository.findRestaurantWithPagination(pageRequest);
        return mapper.mapEntityToRestaurantPageInfo(restaurantByPagination);
    }

    @Transactional(readOnly = true)
    public RestaurantInfo getOneRestaurant(Long id) {
        Restaurant foundRestaurant =
                restaurantRepository.findById(id)
                        .orElseThrow(NotFoundRestaurantException::new);
        return mapper.mapEntityToInfo(foundRestaurant);
    }

    public void delete(Long id) {
        Restaurant foundRestaurant =
                restaurantRepository.findById(id)
                        .orElseThrow(NotFoundRestaurantException::new);
        foundRestaurant.delete();
    }

}
