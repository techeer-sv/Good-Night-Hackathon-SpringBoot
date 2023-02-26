package com.example.demo.domain.review.entity;

import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.domain.review.dto.request.ReviewUpdateRequest;
import com.example.demo.global.entity.TimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class Review extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Builder
    public Review(String title, String content, Restaurant restaurant) {
        this.title = title;
        this.content = content;
        this.restaurant = restaurant;
    }

    public void update(ReviewUpdateRequest reviewUpdateRequest) {
        this.title = reviewUpdateRequest.getTitle();
        this.content = reviewUpdateRequest.getContent();
    }
}
