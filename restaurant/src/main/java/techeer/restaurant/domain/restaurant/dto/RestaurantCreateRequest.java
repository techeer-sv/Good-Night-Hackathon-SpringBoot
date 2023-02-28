package techeer.restaurant.domain.restaurant.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import techeer.restaurant.domain.restaurant.entity.Category;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@RequiredArgsConstructor
public class RestaurantCreateRequest {

    private final String name;
    private final Category category;

}
