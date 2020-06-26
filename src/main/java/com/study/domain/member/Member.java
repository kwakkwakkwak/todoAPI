package com.study.domain.member;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Data
@Entity
@Table(name ="Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "seq")
    Integer seq ;

    @Column (name ="id", unique = true)
    String id;

    @Column(name ="password")
    String password;

}
