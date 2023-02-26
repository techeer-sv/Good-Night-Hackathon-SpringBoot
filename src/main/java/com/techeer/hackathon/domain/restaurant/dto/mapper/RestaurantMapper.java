package com.techeer.hackathon.domain.restaurant.dto.mapper;

import com.techeer.hackathon.domain.restaurant.dto.RegisterRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.dto.InquiryRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.dto.UpdateRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class RestaurantMapper {
    public Restaurant DtoToEntity(RegisterRestaurantDTO registerRestaurantDTO) {
        return Restaurant.builder()
                .name(registerRestaurantDTO.getName())
                .category(registerRestaurantDTO.getCategory())
                .build();
    }

    public InquiryRestaurantDTO DtoFromEntity(Restaurant restaurant) {
        return InquiryRestaurantDTO.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .category(restaurant.getCategory())
                .createdAt(restaurant.getCreatedAt())
                .build();
    }

    public UpdateRestaurantDTO UpdateFromEntity(Restaurant restaurant) {
        return UpdateRestaurantDTO.builder()
                .category(restaurant.getCategory())
                .updatedAt(restaurant.getUpdatedAt())
                .build();
    }


}