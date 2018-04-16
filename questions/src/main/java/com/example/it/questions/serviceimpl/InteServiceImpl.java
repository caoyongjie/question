package com.example.it.questions.serviceimpl;/*
* By 小曹 In 2018/3/27 12:52
**/

import com.example.it.questions.dao.InterRepository;
import com.example.it.questions.pojo.Interview;
import com.example.it.questions.service.InteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
public class InteServiceImpl implements InteService {
    @Autowired
    InterRepository repository;



    @Override
    public int addProblem(Interview interview) {
        try {
            repository.saveAndFlush(interview);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }


    @Override
    public Page<Interview> findAllByCategory(String category,Pageable pageable) {
        return repository.findAllByCategory(category,pageable);
    }

    @Override
    public Page<Interview> findAll(String func, Pageable pageable) {
        Specification<Interview> specification = new Specification<Interview>() {

            /**
             * 构造断言
             * @param root 实体对象引用
             * @param query 规则查询对象
             * @param cb 规则构建对象
             * @return 断言
             */
            @Override
            public Predicate toPredicate(Root<Interview> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                if(StringUtils.isNotBlank(func)){ //添加断言
                    Predicate likeNickName = cb.like(root.get("func").as(String.class),"%"+func+"%");
                    predicates.add(likeNickName);
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
        return repository.findAll(specification,pageable);
    }


}
