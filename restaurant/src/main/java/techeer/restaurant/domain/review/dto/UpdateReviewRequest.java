package techeer.restaurant.domain.review.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class UpdateReviewRequest {
    private final String title;
    private final String content;
}
