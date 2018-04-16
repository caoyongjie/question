package com.example.it.questions.utile;/*
* By 小曹 In 2018/4/2 17:53
**/

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebFilter
public class WebUserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("过滤器启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getServletPath();
        if (url.equals("/") || url.indexOf(".")!=-1 || url.equals("/logout") || url.equals("/selUser") || url.equals("/zhuCe") || url.equals("/userList")){
            chain.doFilter(request, response);
        }else {
            LocalSessionProvider sessionProvider=new LocalSessionProvider();
            String str=sessionProvider.getAttribute(request,response,Constants.USER_NAME);
                if (str==null){
                    response.setContentType("text/html;charset=gb2312");
                    PrintWriter out = response.getWriter();
                    out.println("<script language='javascript' type='text/javascript'>");
                    out.println("window.location.href='" + request.getContextPath() + "/'");
                    out.println("</script>");
                }else {
                    chain.doFilter(request, response);
                }
            }
        }
        @Override
        public void destroy() {

        }
}
