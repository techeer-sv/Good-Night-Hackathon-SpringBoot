package com.example.goodnight.domain.review.domain;

import com.example.goodnight.domain.restaurant.domain.Restaurant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "review")
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
    @Builder
    public Review(String title, String content, Restaurant restaurant) {
        this.title = title;
        this.content = content;
        this.restaurant = restaurant;
    }
}
