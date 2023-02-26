package com.techeer.hackathon.domain.restaurant.service;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateDto;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponseDto;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantUpdateDto;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository R_Repository;
    private final RestaurantMapper R_Mapper;

    public Restaurant insertRestaurant(RestaurantCreateDto restaurantCreateDto) {
        return R_Repository.save(R_Mapper.DtoToEntity(restaurantCreateDto));
    }



    public Restaurant findOneRestaurant(Long id) {
        return R_Repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Restaurant updateRestaurant(RestaurantUpdateDto restaurantUpdate) {
        Restaurant restaurant = IsRestaurantExisted(restaurantUpdate.getId());
        restaurant.update(restaurantUpdate);
        return R_Repository.save(restaurant);
    }

    @Transactional
    public void deleteRestaurant(Long id) {
        Restaurant restaurant = IsRestaurantExisted(id);
        restaurant.delete();
    }

    private Restaurant IsRestaurantExisted(Long id){
        Restaurant foundRestaurant = R_Repository.findById(id).orElseThrow(NullPointerException::new);
        return foundRestaurant;
    }

    public List<RestaurantResponseDto> findAllRestaurant(Integer size, Integer offSet){
        Pageable pageable = PageRequest.of(offSet, size);
        return R_Mapper.restaurantResponseListFromEntity(R_Repository.findRestaurants(pageable));
    }

    public Object findRestaurantsByCategory(String category, Integer size, Integer offset) {
        Pageable pageable = PageRequest.of(offset, size);
        return R_Mapper.restaurantResponseListFromEntity(R_Repository.findByCategory(category,pageable));
    }
}