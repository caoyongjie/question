package com.example.it.questions.utile;/*
* By 小曹 In 2017/12/28 11:38
*
*本地cookie
*
**/

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LocalSessionProvider {
    //存储数据
    public void setAttribute(HttpServletRequest request,HttpServletResponse response, String name, String value) {
        request.getSession().setAttribute(name, value);
    }

    //取数据
    public String getAttribute(HttpServletRequest request,HttpServletResponse response,String name) {
        HttpSession session = request.getSession(false);
        if(session !=null) {
            return (String) session.getAttribute(name);
        }else {
            return null;
        }
    }

    //获取sessoinId
    public String getSessionId(HttpServletRequest request, HttpServletResponse response) {
        return request.getSession().getId();
    }


}
