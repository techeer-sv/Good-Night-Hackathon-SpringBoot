package com.techeer.goodnighthackathonspringboot.domain.restaurant.entity;

import com.techeer.goodnighthackathonspringboot.global.domain.BaseEntity;
import jdk.jfr.Category;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "restaurant")
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Builder
    public Restaurant(String name, Category category){
        this.name = name;
        this.category = category;
    }

    public void delete(){
        this.activeOff();
    }

}
