package com.itqf.controller;

import com.itqf.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter(Constants.TAG);
        if(method==null&method.equals("")){
            method = Constants.INDEX;
        }
        //1. 获取类的class对象
        Class clazz = this.getClass();
        try {
            Method method1 = clazz.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
            Object result = method1.invoke(this,req,resp);
            if(result != null){
                String str= (String)result;
                if(str.startsWith(Constants.FORWARD)){
                    String path = str.substring(str.indexOf(Constants.FLAG)+1);
                    req.getRequestDispatcher(path).forward(req,resp);
                }
                else if(str.startsWith(Constants.REDIRECT)){
                    String path = str.substring(str.indexOf(Constants.FLAG)+1);
                    resp.sendRedirect(path);
                }
                else {
                    resp.getWriter().println(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String index(HttpServletRequest req,HttpServletResponse resp){
        return Constants.FORWARD+Constants.FLAG+"/index.jsp";
    }
}
