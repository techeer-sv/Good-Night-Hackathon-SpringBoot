package com.techeer.hackathon.domain.restaurant.dto;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class InquiryRestaurantDTO {
    private Long id;
    private String name;
    private String category;

}