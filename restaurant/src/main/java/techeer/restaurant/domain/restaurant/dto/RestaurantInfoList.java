package techeer.restaurant.domain.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import techeer.restaurant.domain.restaurant.entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantInfoList {
    private List<RestaurantInfo> restaurantInfos = new ArrayList<>();

    public void addAllRestaurantInfo(List<RestaurantInfo> restaurantInfos) {
        this.restaurantInfos.addAll(restaurantInfos);
    }

    public void addRestaurantInfo(RestaurantInfo restaurantInfo) {
        this.restaurantInfos.add(restaurantInfo);
    }
}
