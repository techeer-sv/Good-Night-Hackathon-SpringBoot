package com.example.hackathon.global.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
public abstract class BaseTimeEntity {
    @CreatedDate private LocalDateTime createdDate;

    @LastModifiedDate private LocalDateTime updatedDate;

    @Getter
    @Column(name = "is_active", nullable = false)
    protected boolean isActive;

    public void activeOff() { this.isActive = false; }
}
