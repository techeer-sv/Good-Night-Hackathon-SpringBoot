package chanyoung.GoodNightHackathon.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReviewRequestId {
    private String title;
    private String content;
    private Long id;
}
