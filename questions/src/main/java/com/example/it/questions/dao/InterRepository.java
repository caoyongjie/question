package com.example.it.questions.dao;/*
* By 小曹 In 2018/3/28 12:26
**/

import com.example.it.questions.pojo.Interview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

import static org.hibernate.jpa.QueryHints.HINT_COMMENT;

@Repository
public interface InterRepository extends JpaRepository<Interview,Integer> {

    @QueryHints(value = { @QueryHint(name = HINT_COMMENT, value = "a query for pageable")})
    Page<Interview> findAllByCategory(String category,Pageable pageable);

    Page<Interview> findAll(Specification<Interview> spec, Pageable pageable);

}
