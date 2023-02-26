package com.techeer.persistence.restaurant.dto.request;

import com.techeer.persistence.restaurant.entity.Restaurant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateRestaurantReq {

  private String name;

  private String categoryName;

  public Restaurant toEntity() {
    return Restaurant.builder()
            .name(name)
            .categoryName(categoryName)
            .build();
  }
}
