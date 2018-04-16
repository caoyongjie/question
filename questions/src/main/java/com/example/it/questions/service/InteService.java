package com.example.it.questions.service;/*
* By 小曹 In 2018/3/27 12:51
**/
import com.example.it.questions.pojo.Interview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface InteService {

    int addProblem(Interview interview);
    Page<Interview> findAllByCategory(String category,Pageable pageable);
    Page<Interview> findAll(String category, Pageable pageable);
}
