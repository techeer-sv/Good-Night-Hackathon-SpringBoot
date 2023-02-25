package techeer.restaurant.domain.review.entity;

import lombok.Getter;
import techeer.restaurant.domain.restaurant.entity.Restaurant;
import techeer.restaurant.global.domain.BaseEntity;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Table(name = "review")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "review_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

}
