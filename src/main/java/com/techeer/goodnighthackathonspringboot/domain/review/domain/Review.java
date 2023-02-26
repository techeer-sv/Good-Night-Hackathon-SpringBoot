package com.techeer.goodnighthackathonspringboot.domain.review.domain;

import com.techeer.goodnighthackathonspringboot.domain.restaurant.domain.Restaurant;
import com.techeer.goodnighthackathonspringboot.global.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "review")
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "contents", nullable = false)
    private String contents;

    @Builder
    public Review(Restaurant restaurant, String title, String contents) {
        this.restaurant = restaurant;
        this.title = title;
        this.contents = contents;
        this.isActivated = true;
    }

    public void update(String title, String contents){
        this.title = title;
        this.contents = contents;
    }
}
