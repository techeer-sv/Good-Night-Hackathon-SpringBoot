package com.example.hackathon.review.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "review")
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private int id;

    // 제목
    @Column(name = "title",nullable = false, length = 100)
    private String title;

    // 내용
    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "is_activated", nullable = false)
    private boolean isActivated;

    @Builder
    public Review (String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}
