package com.betinnapp.userservice.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {


    public User(String name, String nickname, String email, Date birthDate) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.birthDate = birthDate;
    }

    public User() {
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column
    private String nickname;

    @Column
    private String email;

    @Column
    private Date birthDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
