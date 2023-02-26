package com.techeer.hackathon.domain.restaurant.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponseDto {
    private String name;
    private String category;
    private LocalDateTime createdDate;
}
