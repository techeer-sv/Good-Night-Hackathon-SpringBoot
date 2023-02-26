package com.techeer.hackathon.domain.restaurant.service;

import com.techeer.hackathon.domain.restaurant.dto.RegisterRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.repository.RepositoryRestaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceRestaurant {
    private final RepositoryRestaurant Res_Repo;
    private final RestaurantMapper Res_Mapper;

    public Restaurant insertRestaurant(RegisterRestaurantDTO registerRestaurantDTO) {
        return Res_Repo.save(Res_Mapper.DtoToEntity(registerRestaurantDTO));
    }

    public List<Restaurant> getAllRestaurants(){
        return Res_Repo.findAll();
    }

}
