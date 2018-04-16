package com.example.it.questions.dao;/*
* By 小曹 In 2018/3/28 12:24
**/

import com.example.it.questions.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUserNameAndAndPassword(String username, String password);
    User findByUserName(String username);
}
