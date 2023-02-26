package com.example.hackathon.restaurant.domain.entity;

import com.example.hackathon.global.entity.BaseTimeEntity;
import com.example.hackathon.review.domain.entity.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "restaurant")
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Restaurant extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id" , nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    // Review 와 1:n 관계
    // cascade = 엔티티 상태가 변화했을 때 관계가 있는 엔티티에게도 상태 변화 전파
    // orphanRemoval = 부모와 관계가 끊어진 자식을 자동으로 제거해주는 옵션
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @Builder
    public Restaurant(String name, Category category) {
        this.name = name;
        this.category = category;
        this.isActive = true;
    }

    public void deleteRestaurant() { this.activeOff();}
}
