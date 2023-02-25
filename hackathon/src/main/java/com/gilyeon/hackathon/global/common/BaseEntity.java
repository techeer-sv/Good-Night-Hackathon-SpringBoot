package com.gilyeon.hackathon.global.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}

//@CreatedDate
//Entity가 생성되어 저장될 때의 시간을 자동으로 저장한다.

//@LastModifiedDate
//조회한 Entity의 값을 변경할 때 시간을 자동으로 저장한다.

//@EntityListeners
//Entity의 Lifecycle과 관련된 이벤트들을 듣게해준다.

//@MappedSuperclass
//엔티티 클래스는 엔티티끼리만 상속할 수 있다. BaseEntity는 이름만 엔티티지 사실 엔티티가 아니라 일반 클래스다. 따라서 엔티티 클래스가 일반 클래스를 상속하기 위해서는 일반 클래스에 이 애노티에션을 붙여야한다.