package com.study.domain;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name ="Todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    Integer id ;

    @Column (name ="text")
    String text;

    @Column(name ="status")
    Boolean status;

    @Column(name ="parent")
    Integer parent;

}
