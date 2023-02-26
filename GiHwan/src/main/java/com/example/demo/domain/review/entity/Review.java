package com.example.demo.domain.review.entity;

import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.domain.review.dao.ReviewRepository;
import com.example.demo.global.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="review")
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Builder
    public Review(String title, String content, Restaurant restaurant){
        this.title=title;
        this.content=content;
        this.restaurant=restaurant;
    }

}
