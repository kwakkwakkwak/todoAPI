package com.study.domain.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query(value = "SELECT * FROM Todo WHERE seq = ?1 ORDER BY IF(ISNULL(PARENT), id, PARENT), id ", nativeQuery = true)
    public List<Todo> findALLBySeq(int seq);

}

