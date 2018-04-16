package com.example.it.questions.serviceimpl;/*
* By 小曹 In 2018/3/27 12:52
**/



import com.example.it.questions.dao.UserRepository;
import com.example.it.questions.pojo.User;
import com.example.it.questions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepostory;
    @Override
    public User findUserByUserNameAndAndPassword(String username, String password) {
        return userRepostory.findUserByUserNameAndAndPassword(username,password);
    }

    @Override
    public int saveUser(User user) {
        try {
            userRepostory.saveAndFlush(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public User findByUserName(String username) {
        return userRepostory.findByUserName(username);
    }
}
