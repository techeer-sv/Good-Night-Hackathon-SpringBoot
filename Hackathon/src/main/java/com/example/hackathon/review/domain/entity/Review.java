package com.example.hackathon.review.domain.entity;

import com.example.hackathon.global.entity.BaseTimeEntity;
import com.example.hackathon.restaurant.domain.entity.Restaurant;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "review")
@NoArgsConstructor
public class Review extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id" , nullable = false)
    private Restaurant restaurant;
    // 제목
    @Column(name = "title",nullable = false, length = 100)
    private String title;

    // 내용
    @Lob
    @Column(name = "content")
    private String content;

    @Builder
    public Review (Restaurant restaurant, String title, String content) {
        this.restaurant = restaurant;
        this.title = title;
        this.content = content;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}
