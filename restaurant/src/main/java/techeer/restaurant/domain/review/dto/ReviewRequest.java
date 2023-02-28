package techeer.restaurant.domain.review.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class ReviewRequest {

    private final Long restaurantId;
    private final String title;
    private final String content;
}
