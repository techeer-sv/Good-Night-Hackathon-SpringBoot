package com.techeer.hackathon.domain.restaurant.service;

import com.techeer.hackathon.domain.restaurant.dto.InquiryRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.dto.RegisterRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.dto.UpdateRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.repository.RepositoryRestaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<InquiryRestaurantDTO> getRestaurantsByCategory(String category) {
        List<Restaurant> restaurants = Res_Repo.findByCategoryAndDeletedFalse(category);
        return restaurants.stream()
                .map(Res_Mapper::DtoFromEntity)
                .collect(Collectors.toList());
    }

//    public InquiryRestaurantDTO getRestaurant(Long id) {
//        Restaurant restaurant = Res_Repo.findById(id)
//                .orElseThrow(() -> new NotFoundException("Restaurant not found"));
//
//        return Res_Mapper.DtoFromEntity(restaurant);
//    }
    public Restaurant getRestaurantByIdAndDeletedIsFalse(Long id) {
        Optional<Restaurant> optionalRestaurant = Res_Repo.findByIdAndDeletedIsFalse(id);
        if (optionalRestaurant.isEmpty()) {
            throw new RuntimeException();
        }
        return optionalRestaurant.get();
    }

    public UpdateRestaurantDTO updateRestaurantCategory(Long id, String newCategory){
        Restaurant restaurant = Res_Repo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Restaurant not found with id " + id));
        restaurant.setCategory(newCategory);
        Res_Repo.save(restaurant);
        return Res_Mapper.UpdateFromEntity(restaurant);
    }

}
