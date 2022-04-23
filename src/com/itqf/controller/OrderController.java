package com.itqf.controller;

import com.itqf.entity.Orders;
import com.itqf.service.AddressService;
import com.itqf.service.CartService;
import com.itqf.service.impl.AddressServiceImpl;
import com.itqf.service.impl.CartServiceImpl;
import com.itqf.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "OrderController",value = "/order")
public class OrderController extends BaseServlet{
    public String createOrder(HttpServletRequest req,HttpServletResponse resp){
        int cid = Integer.parseInt(req.getParameter("cid"));
        int uid = Integer.parseInt(req.getParameter("uid"));
        Orders orders = new Orders();
//        orders.setAid(aid);
        orders.setUid(uid);
//        orders.setOcount(ccount);
        Date date=new Date();
        orders.setOtime(date);
        orders.setOstate(0);
        return Constants.FORWARD+Constants.FLAG+"/createOrder.jsp";
    }
}
