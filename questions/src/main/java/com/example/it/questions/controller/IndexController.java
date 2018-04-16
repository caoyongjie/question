package com.example.it.questions.controller;/*
* By 小曹 In 2018/4/2 15:06
**/

import com.example.it.questions.pojo.Interview;
import com.example.it.questions.service.InteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    InteService service;


    @RequestMapping("/java")
    public String java(ModelMap map){

        map.addAttribute("java","后端");
        return "java";
    }
    @RequestMapping("/web")
    public String web(ModelMap map){
        map.addAttribute("web","前端");
        return "web";
    }
    @ResponseBody
    @RequestMapping("/webAdd")
    public String webAdd(Interview interview){
        if (interview.getAnswer()==null || interview.getAnswer().isEmpty()){
           interview.setFlag("未解答");
        }else {
            interview.setFlag("已解答");
        }
        interview.setCategory("前端");
        int b=service.addProblem(interview);
        if (b!=0){
            return "新增成功";
        }
        return "新增失败";
    }
    @ResponseBody
    @RequestMapping("/javaAdd")
    public String javaAdd(Interview interview){
        if (interview.getAnswer()==null || interview.getAnswer().isEmpty()){
            interview.setFlag("未解答");
        }else {
            interview.setFlag("已解答");
        }
        interview.setCategory("后端");
        int b=service.addProblem(interview);
        if (b!=0){
            return "新增成功";
        }
        return "新增失败";
    }
    @ResponseBody
    @RequestMapping("/edit")
    public String edit(Interview interview){
        if (interview.getAnswer()==null || interview.getAnswer().isEmpty()){
            interview.setFlag("未解答");
        }else {
            interview.setFlag("已解答");
        }
        int b=service.addProblem(interview);
        if (b!=0){
            return "解答成功";
        }
        return "解答失败";
    }
}
