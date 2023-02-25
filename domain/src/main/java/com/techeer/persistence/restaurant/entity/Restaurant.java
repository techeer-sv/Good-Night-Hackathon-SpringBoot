package com.techeer.persistence.restaurant.entity;

import com.techeer.common.domain.BaseEntity;

import javax.persistence.*;

import com.techeer.persistence.review.entity.Review;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "restaurant")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
  @NonNull
  private List<Review> reviewList = new ArrayList<>();


  @Builder
  public Restaurant(String name,  String description) {
    this.name = name;
    this.description = description;
  }
}
