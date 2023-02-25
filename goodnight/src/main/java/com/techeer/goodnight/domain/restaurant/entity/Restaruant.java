package com.techeer.goodnight.domain.restaurant.entity;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import com.techeer.goodnight.global.domain.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "Restaurant")
public class Restaruant extends BaseTimeEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String content;

    public void update(String name, String content){
        this.name = name;
        this.content = content;
    }

    public void delete(){
        this.activeOff();
    }

}