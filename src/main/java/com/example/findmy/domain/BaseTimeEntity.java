package com.example.findmy.domain;

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
public abstract class BaseTimeEntity {

    @CreatedDate
//    @Column(columnDefinition = "datetime(6) default now(6)", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
//    @Column(columnDefinition = "datetime(6) default now(6)", nullable = false)
    private LocalDateTime modifiedDate;

}
