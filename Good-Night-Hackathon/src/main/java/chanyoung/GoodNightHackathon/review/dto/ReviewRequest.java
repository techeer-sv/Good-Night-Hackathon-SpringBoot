package chanyoung.GoodNightHackathon.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReviewRequest {
    private String title;
    private String content;
    private Long restaurant_id;
}
