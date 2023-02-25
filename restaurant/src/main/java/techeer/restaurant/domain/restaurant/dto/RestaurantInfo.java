package techeer.restaurant.domain.restaurant.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import techeer.restaurant.domain.restaurant.entity.Category;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class RestaurantInfo {

    private String name;

    private Category category;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updatedAt;

    @Builder
    public RestaurantInfo(String name, Category category, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }



}
