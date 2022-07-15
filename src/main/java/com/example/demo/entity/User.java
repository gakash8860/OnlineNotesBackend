package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String name;
    private String phoneNumber;
    private String password;




    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Notes> notes;


    public User(String name, String email,String phoneNumber,String password) {
        this.email = email;
        this.name = name;
        this.password=password;
        this.phoneNumber= phoneNumber;
    }
}
