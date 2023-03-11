package chanyoung.GoodNightHackathon.review.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewResponse {
    private String restaurantName;
    private String title;
    private String content;

}
