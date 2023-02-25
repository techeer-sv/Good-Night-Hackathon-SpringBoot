package techeer.restaurant.domain.review.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import techeer.restaurant.domain.restaurant.entity.Restaurant;

@Getter
@NoArgsConstructor
public class ReviewInfo {

    private String restaurant;
    private String title;
    private String content;

    @Builder
    public ReviewInfo(
            String restaurant, String title, String content) {
        this.restaurant = restaurant;
        this.title = title;
        this.content = content;
    }
}
