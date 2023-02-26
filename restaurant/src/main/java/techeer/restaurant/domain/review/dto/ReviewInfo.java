package techeer.restaurant.domain.review.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import techeer.restaurant.domain.restaurant.entity.Restaurant;
import techeer.restaurant.domain.review.entity.Review;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ReviewInfo {

    private Long reviewId;
    private String restaurantName;
    private String title;
    private String content;
    private LocalDateTime createdAt;


    @Builder
    public ReviewInfo(
            Long reviewId, String restaurantName, String title, String content, LocalDateTime createdAt) {
        this.reviewId = reviewId;
        this.restaurantName = restaurantName;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static ReviewInfo of(
            Review entity
    ) {
        return ReviewInfo.builder()
                .reviewId(entity.getId())
                .restaurantName(entity.getRestaurant().getName())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
