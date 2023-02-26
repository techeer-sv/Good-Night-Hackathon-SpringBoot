package com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@AllArgsConstructor
@Getter
@RequiredArgsConstructor
public class RestaurantCreateRequest {
    @NotBlank(message = "레스토랑 이름은 필수입니다.")
    private String name;

    @NotBlank(message = "레스토랑 카테고리는 필수입니다.")
    private String category;

}
