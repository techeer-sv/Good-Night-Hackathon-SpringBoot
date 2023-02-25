package techeer.restaurant.domain.restaurant.entity;

import lombok.Getter;
import techeer.restaurant.domain.review.entity.Review;
import techeer.restaurant.global.domain.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
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

}
