package com.techeer.hackathon.domain.review.entity;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.global.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="review")
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "restaurant", nullable = false)
    private Restaurant restaurant;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public review(String title, String content){
        this.title = title;
        this.content = content;
    }
}