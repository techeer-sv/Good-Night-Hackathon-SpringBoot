package chanyoung.GoodNightHackathon.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantResponse {
    private String name;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

}
