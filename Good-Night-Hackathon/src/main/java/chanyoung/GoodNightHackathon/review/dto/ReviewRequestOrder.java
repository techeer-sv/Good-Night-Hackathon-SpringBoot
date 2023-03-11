package chanyoung.GoodNightHackathon.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReviewRequestOrder {
    private String title;
    private String content;
    private Boolean orderType;
}

