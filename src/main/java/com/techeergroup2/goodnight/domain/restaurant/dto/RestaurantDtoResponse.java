package com.techeergroup2.goodnight.domain.restaurant.dto;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RestaurantDtoResponse {
    private String name;
    private String category;
    private LocalDateTime createDateTime;


}
