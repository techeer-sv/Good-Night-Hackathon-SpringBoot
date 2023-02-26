package com.techeer.persistence.restaurant.dto.response;

import com.techeer.persistence.restaurant.entity.Restaurant;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantDTO {

  private long id;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private String name;

  private String categoryName;

  @Builder
  public RestaurantDTO(Restaurant restaurant) {
    this.id = restaurant.getId();
    this.createdAt = restaurant.getCreatedAt();
    this.updatedAt = restaurant.getUpdatedAt();
    this.name = restaurant.getName();
    this.categoryName = restaurant.getCategoryName();
  }
}
