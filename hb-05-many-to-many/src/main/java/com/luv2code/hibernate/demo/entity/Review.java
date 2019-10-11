package com.luv2code.hibernate.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="comment")
    private String comment;

    public Review(String comment) {
        this.comment = comment;
    }

    public Review() {
    }
}
