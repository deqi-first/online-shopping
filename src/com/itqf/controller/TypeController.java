package com.itqf.controller;

import com.alibaba.fastjson.JSON;
import com.itqf.entity.Type;
import com.itqf.service.TypeService;
import com.itqf.service.impl.TypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TypeController",value = "/type")
public class TypeController extends BaseServlet {
   public String findAllType(HttpServletRequest request,HttpServletResponse response){
       TypeService typeService = new TypeServiceImpl();
       List<Type> list = typeService.findAll();

        String json = JSON.toJSONString(list);
       return json;
   }
}
