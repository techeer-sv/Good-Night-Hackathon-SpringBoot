package com.techeer.hackathon.domain.restaurant.service;

import com.techeer.hackathon.domain.restaurant.dto.InquiryRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.dto.RegisterRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.repository.RepositoryRestaurant;
import lombok.RequiredArgsConstructor;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

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
