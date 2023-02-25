package techeer.restaurant.domain.restaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import techeer.restaurant.domain.review.entity.Review;
import techeer.restaurant.global.domain.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurant")
public class Restaurant extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "restaurant_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews = new ArrayList<>();

/*    public void updateCategory(RestaurantUpdateRequest restaurantUpdateRequest) {
        this.category = restaurantUpdateRequest.getCategory();
    }*/

    @Builder
    public Restaurant(String name, Category category) {
        this.name = name;
        this.category = category;
        this.isActive = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant restaurant = (Restaurant) o;
        return Objects.equals(id, restaurant.id)
                && Objects.equals(name, restaurant.name)
                && Objects.equals(category, restaurant.category);
    }

    public void deleteRestaurant() {
        this.activeOff();
    }


}
