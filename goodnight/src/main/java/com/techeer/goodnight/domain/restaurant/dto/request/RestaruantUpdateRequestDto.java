package com.techeer.goodnight.domain.restaurant.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaruantUpdateRequestDto {
    private String categoryName;

}