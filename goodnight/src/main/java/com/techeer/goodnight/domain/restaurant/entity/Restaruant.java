package com.techeer.goodnight.domain.restaurant.entity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Getter
@Table(name = "Restaurant")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaruant {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @NotNull
    private String name;

    private String content;

    private Boolean activated;

    public void update(String name, String content, Boolean activated){
        this.name = name;
        this.content = content;
        this.activated = activated;
    }
}