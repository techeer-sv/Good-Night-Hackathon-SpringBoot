package com.project.hackathon.domain.restaurant.dto;

import java.time.LocalDateTime;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class RestaurantInfo {

    // 게시판 제목
    private String title;
    // 게시글 작성자 이름
    private String userName;
    // 게시판 작성 일시
    private LocalDateTime createdDate;
    // 이미지 첨부 여부
    private boolean hasImages;

    @Builder
    public RestaurantInfo(
            String title, String userName, LocalDateTime createdDate, boolean hasImages) {
        this.title = title;
        this.userName = userName;
        this.createdDate = createdDate;
        this.hasImages = hasImages;
    }
}
