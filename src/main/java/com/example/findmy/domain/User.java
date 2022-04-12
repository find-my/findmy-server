package com.example.findmy.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseTimeEntity{
    // User table id 컬럼은 autoincrement x
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    private String password;

    private String avatar;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<ReComment> reComments = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Scrap> scraps = new ArrayList<>();

    @OneToMany(mappedBy = "createdById", orphanRemoval = true)
    private List<Review> writtenReviews = new ArrayList<>();

    @OneToMany(mappedBy = "createdForId", orphanRemoval = true)
    private List<Review> receivedReviews = new ArrayList<>();
}
