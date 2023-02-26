package com.example.demo.domain.restaurant.dto.response;

import com.example.demo.global.enumpkg.Category;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponse {
    private Long id;
    private String name;

    private Category category;

    private LocalDateTime createdAt;

}
