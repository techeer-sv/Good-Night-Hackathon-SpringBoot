package com.project.hackathon.domain.review.dto;

import lombok.*;
import java.time.LocalDateTime;

@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDetailResponse {
    private Long id;
    // 리뷰 이름
    private String title;
    // 리뷰 내용
    private String content;
    private String restaurant;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ReviewDetailResponse(String message) {
        // 메시지만 필요한 경우에 사용하는 생성자
        this.title = message;
    }
}
