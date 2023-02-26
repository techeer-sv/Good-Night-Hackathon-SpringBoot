package com.project.hackathon.domain.restaurant.entity;

import com.project.hackathon.global.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "restaurant")
@NoArgsConstructor
public class Restaurant extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    // 레스토랑 카테고리
    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "is_removed", nullable = false)
    private boolean isRemoved;

    @Builder
    public Restaurant(
            String title,
            Category category
    ) {
        this.title = title;
        this.category = category;
        this.isRemoved = false;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
    public void deleteRestaurant() { //soft delete
        this.isRemoved = true;
    }
}