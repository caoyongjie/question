package com.example.it.questions.controller;/*
* By 小曹 In 2018/3/29 8:01
**/

import com.example.it.questions.pojo.User;
import com.example.it.questions.service.UserService;
import com.example.it.questions.utile.Constants;
import com.example.it.questions.utile.LocalSessionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    LocalSessionProvider provider;

    @RequestMapping("/")
    public String login(){
        return "login";
    }
    @ResponseBody
    @RequestMapping("/selUser")
    public String selUser( String username,String password){
        User user=userService.findUserByUserNameAndAndPassword(username,password);
        if (user!=null){
            return "success";
        }
        return "error";
    }
    @ResponseBody
    @RequestMapping("/zhuCe")
    public String zhuCe( String username,String password){

        User user=userService.findByUserName(username);
        if (user!=null){
            return "用户已存在";
        }else {
            User u=new User();
            u.setUserName(username);
            u.setPassword(password);
            int i=userService.saveUser(u);
            if (i>0){
                return "注册成功";
            }else {
                return "注册失败";
            }
        }
    }

    @RequestMapping("/userList")
    public String userList(  String username, String password,HttpServletRequest request, HttpServletResponse response){
        provider.setAttribute(request,response,Constants.USER_NAME,username);
        provider.setAttribute(request,response,Constants.PASS_WORD,password);
        return "redirect:/homePage";
    }
    @RequestMapping("/homePage")
    public String web(HttpServletRequest request, HttpServletResponse response,ModelMap map) throws IOException {

        String name=provider.getAttribute(request,response, Constants.USER_NAME);
        String pwd=provider.getAttribute(request,response, Constants.PASS_WORD);
        if (name!=null && pwd!=null){
            map.addAttribute("name",name);
            map.addAttribute("pwd",pwd);
            return "index";
        }
        return  "redirect:/";
    }
    //退出登录
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String str=provider.getAttribute(request,response, Constants.USER_NAME);
        if (str!=null){
            request.getSession(false).invalidate();
        }
        return  "redirect:/";
    }
}
