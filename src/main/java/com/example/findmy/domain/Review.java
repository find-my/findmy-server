package com.example.findmy.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Review extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @ColumnDefault("1")
    private int score;

    private String review;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User createdById;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User createdForId;
}
