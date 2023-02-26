package com.techeer.hackathon.domain.review.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewUpdateRequest {
    private Long id;
    private String title;
    private String content;
}
