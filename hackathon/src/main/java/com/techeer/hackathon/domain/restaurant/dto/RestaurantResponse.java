package com.techeer.hackathon.domain.restaurant.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantResponse {
    String name;
    String category;
    LocalDateTime createdAt;
}
