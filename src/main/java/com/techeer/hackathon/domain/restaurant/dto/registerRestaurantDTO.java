package com.techeer.hackathon.domain.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor

public class registerRestaurant {
    private final LocalDateTime createDate;
    @NotNull
    private final String name;
    private final String category;
}
