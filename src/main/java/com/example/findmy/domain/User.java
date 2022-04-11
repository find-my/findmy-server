package com.example.findmy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseTimeEntity{
    @Id
    private String email;

    private String password;

    private String name;

    private String phone;

}
