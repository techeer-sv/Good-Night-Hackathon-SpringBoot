package com.techeer.goodnight.domain.restaurant.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
@AllArgsConstructor
public class RestaruantCreateRequestDto {
    @NonNull
    private String name;

    private String content;

    private Boolean activated;
}