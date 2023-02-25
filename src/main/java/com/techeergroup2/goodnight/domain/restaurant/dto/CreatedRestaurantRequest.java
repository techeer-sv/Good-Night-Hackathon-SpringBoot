package com.techeergroup2.goodnight.domain.restaurant.dto;

import com.techeergroup2.goodnight.domain.restaurant.domain.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatedRestaurantRequest {

        private String name;
        private String category;

        public Restaurant toEntity() {
            return new Restaurant(name, category);
        }
}
