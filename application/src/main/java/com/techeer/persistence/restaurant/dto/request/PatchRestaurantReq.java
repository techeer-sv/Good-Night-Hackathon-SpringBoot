package com.techeer.persistence.restaurant.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PatchRestaurantReq {
    private String categoryName;

}
