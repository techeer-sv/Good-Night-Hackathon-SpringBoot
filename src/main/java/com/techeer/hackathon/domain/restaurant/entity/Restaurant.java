package com.techeer.hackathon.domain.restaurant.entity;

import com.techeer.hackathon.global.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="restaurant")
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @Builder
    public Restaurant(String category, String name, boolean deleted) {

        this.category = category;
        this.name = name;
        this.deleted = false;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}