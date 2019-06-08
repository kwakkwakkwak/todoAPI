package com.study.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query(value = "SELECT * FROM Todo ORDER BY IF(ISNULL(PARENT), id, PARENT), id ", nativeQuery = true)
    public List<Todo> findAllByOrdOrderBy();

}

