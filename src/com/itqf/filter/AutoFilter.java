package com.itqf.filter;

import com.itqf.entity.User;
import com.itqf.service.UserService;
import com.itqf.service.impl.UserServiceImpl;
import com.itqf.utils.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/Login.jsp")
public class AutoFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String content = null;
            for (Cookie cookie : cookies) {
                //如果获取到cookie的名字对于Constants.AUTO_NAME
                if (cookie.getName().equals(Constants.AUTO_NAME)) {
                    //就获取这个cookie的value值
                    content = cookie.getValue();
                }
            }
            if (content != null) {
                String[] split = content.split(Constants.FLAG);
                String username = split[0];
                String password = split[1];

                UserService userService = new UserServiceImpl();
                User user=userService.login(username, password);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("loginUser",user);
                    HttpServletResponse response = (HttpServletResponse)resp;
                    response.sendRedirect(request.getContextPath()+"/index.jsp");
                }else{
                    chain.doFilter(req, resp);
                }
            }
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
