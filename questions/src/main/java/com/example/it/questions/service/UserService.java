package com.example.it.questions.service;/*
* By 小曹 In 2018/3/27 12:51
**/


import com.example.it.questions.pojo.User;

public interface UserService {
    User findUserByUserNameAndAndPassword(String username, String password);
    int saveUser(User user);
    User findByUserName(String username);

}
