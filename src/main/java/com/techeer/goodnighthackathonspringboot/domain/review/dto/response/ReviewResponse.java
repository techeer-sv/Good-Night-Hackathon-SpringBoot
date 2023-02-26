package com.techeer.goodnighthackathonspringboot.domain.review.dto.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewResponse {
    private String restaurantName;
    private String title;
    private String contents;
}
