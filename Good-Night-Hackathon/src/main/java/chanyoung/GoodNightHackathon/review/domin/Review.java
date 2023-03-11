package chanyoung.GoodNightHackathon.review.domin;

import chanyoung.GoodNightHackathon.restaurant.domain.Restaurant;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    @ManyToOne(targetEntity = Restaurant.class)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Builder
    public Review(String title, String content, Restaurant restaurant) {
        this.title = title;
        this.content = content;
        this.restaurant = restaurant;
    }

    public void update (String title, String content) {
        System.out.println("4");
        this.title = title;
        this.content = content;
    }
}
