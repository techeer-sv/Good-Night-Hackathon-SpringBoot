package com.techeer.hackathon.domain.restaurant.dto;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor

public class inquiryRestaurant {
    private String name;
    private Restaurant category;
    private LocalDateTime createData;
}
