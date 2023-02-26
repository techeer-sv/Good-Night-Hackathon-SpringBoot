package com.example.hackathon.restaurant.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String category;

    @Column(nullable = false)
    private Boolean isDeleted;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Builder
    public Restaurant(String name, String category) {
        this.name = name;
        this.category = category;
        this.isDeleted = false;
    }

    public void updateCategory(String category) {
        this.category = category;
    }

    public void delete() {
        this.isDeleted = true;
    }
}
