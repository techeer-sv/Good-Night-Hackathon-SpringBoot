package com.techeer.hackathon.domain.restaurant.service;

import com.techeer.hackathon.domain.restaurant.dto.RegisterRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.repository.RepositoryRestaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ServiceRestaurant {
    private final RepositoryRestaurant Res_Repo;
    private final RestaurantMapper Res_Mapper;

    public Restaurant insertRestaurant(RegisterRestaurantDTO registerRestaurantDTO) {
        return Res_Repo.save(Res_Mapper.DtoToEntity(registerRestaurantDTO));
    }

    public List<Restaurant> getAllRestaurants(){
        return Res_Repo.findAll();
    }

    public void deleteRestaurant(Long id) {
        Restaurant restaurant = getRestaurantById(id);
        restaurant.setDeleted(true);
        Res_Repo.save(restaurant);
    }

    private Restaurant getRestaurantById(Long id) {
        return Res_Repo.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new NotFoundException("Restaurant no found"));
    }

}
