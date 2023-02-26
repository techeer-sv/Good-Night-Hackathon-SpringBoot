package com.techeer.goodnighthackathonspringboot.domain.review.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewInfo {
    private Long id;
    private Long restaurantId;
    private String title;
    private String contents;
}
