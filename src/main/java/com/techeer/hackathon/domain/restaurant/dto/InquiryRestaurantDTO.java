package com.techeer.hackathon.domain.restaurant.dto;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.global.BaseEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class InquiryRestaurantDTO {
    private Long id;
    private String name;
    private String category;
    private LocalDateTime createdAt;

}