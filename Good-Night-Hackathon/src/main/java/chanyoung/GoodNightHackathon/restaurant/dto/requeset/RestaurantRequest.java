package chanyoung.GoodNightHackathon.restaurant.dto.requeset;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantRequest {
    private String name;
    private String category;
}
