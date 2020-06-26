package com.study.domain.todo;

import com.study.domain.member.Member;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @Column(name ="parent", updatable=false, insertable=false)
    Integer parent;

    @ManyToOne
    @JoinColumn(name = "seq")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "parent")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Todo todo;
}
