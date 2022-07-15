package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long n_id;

   private String title;
   private String notes;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "n_id"), name = "id",nullable = false)
    @JsonIgnore
   private User user;

}
