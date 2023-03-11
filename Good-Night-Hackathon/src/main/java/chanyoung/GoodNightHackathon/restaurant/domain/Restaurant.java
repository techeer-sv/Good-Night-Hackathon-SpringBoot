package chanyoung.GoodNightHackathon.restaurant.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor // 기본생성자 추가

public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private String category;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    private Boolean isDeleted;

    @Builder
    public Restaurant(String name, String category) {
        this.name = name;
        this.category = category;
        this.isDeleted = false;
    }

    public void update (String category) {
        this.category = category;
        System.out.println(this.category);
    }

    public void delete() {
        this.isDeleted = true;
    }
}
