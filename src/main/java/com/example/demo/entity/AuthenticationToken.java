package com.example.demo.entity;


import com.example.demo.entity.User;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tokens")
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String token;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToOne(targetEntity = com.example.demo.entity.User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User User;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUserModel() {
        return User;
    }

    public void setUserModel(User User) {
        this.User = User;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthenticationToken(User User) {
        this.User = User;
        this.createdDate = new Date();
        this.token = UUID.randomUUID().toString();
    }

    public AuthenticationToken() {
    }
}