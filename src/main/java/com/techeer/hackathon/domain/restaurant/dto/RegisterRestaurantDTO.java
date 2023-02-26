package com.techeer.hackathon.domain.restaurant.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor

public class RegisterRestaurantDTO {
    private final LocalDateTime createDate;
    @NotNull
    private final String name;
    @NotNull
    private final String category;
}
