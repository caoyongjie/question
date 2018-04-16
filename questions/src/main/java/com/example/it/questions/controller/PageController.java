package com.example.it.questions.controller;/*
* By 小曹 In 2018/4/3 9:25
**/

import com.example.it.questions.pojo.Interview;
import com.example.it.questions.service.InteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PageController {
    @Autowired
    InteService service;


    //面试题分页
    @RequestMapping("/webList")
    public Map webList(String func,@RequestParam(value = "page")int page, @RequestParam(value = "rows")int size){

        Map<String,Object> map = new HashMap<String,Object>();
        Pageable pageable = new PageRequest(page-1,size, Sort.Direction.ASC,"id");
        Page<Interview> pg=null;
        if (func==null || func.isEmpty()){
            pg=service.findAllByCategory("前端",pageable);
        }else {
            pg=service.findAll(func,pageable);
        }
        map.put("total",pg.getTotalElements());
        map.put("rows",pg.getContent());
        return map;
    }
    //面试题分页
    @RequestMapping("/javaList")
    public Map javaList(String func,@RequestParam(value = "page")int page, @RequestParam(value = "rows")int size){

        Map<String,Object> map = new HashMap<String,Object>();
        Pageable pageable = new PageRequest(page-1,size, Sort.Direction.ASC,"id");
        Page<Interview> pg=null;
        if (func==null || func.isEmpty()){
            pg=service.findAllByCategory("后端",pageable);
        }else {
            pg=service.findAll(func,pageable);
        }
        map.put("total",pg.getTotalElements());
        map.put("rows",pg.getContent());
        return map;
    }
}
