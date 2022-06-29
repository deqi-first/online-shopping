package com.itqf.controller;

import com.itqf.entity.Address;
import com.itqf.entity.Cart;
import com.itqf.entity.Orders;
import com.itqf.entity.Product;
import com.itqf.service.AddressService;
import com.itqf.service.CartService;
import com.itqf.service.ProductService;
import com.itqf.service.impl.AddressServiceImpl;
import com.itqf.service.impl.CartServiceImpl;
import com.itqf.service.impl.ProductServiceImpl;
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
    public String showOrder(HttpServletRequest req, HttpServletResponse resp){
        int cid = Integer.parseInt(req.getParameter("cid"));
        int uid = Integer.parseInt(req.getParameter("uid"));
        Orders orders = new Orders();
        //根据cid查找购物车记录
        CartService cartService = new CartServiceImpl();
        Cart cartByCid = cartService.findCartByCid(cid);
        //根据查找到的购物车记录获得pid，商品编号
        int pid = cartByCid.getPid();
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findGoodDetailByPid(pid);
        req.setAttribute("MyOrderProduct",product);
        cartByCid.setProduct(product);
        orders.setOcount(cartByCid.getCcount());
        orders.setUid(uid);
        //查找默认收获地址
        AddressService addressService = new AddressServiceImpl();
        Address address = addressService.findDefaultAddressByUid(uid);
        req.setAttribute("MyOrderAddress",address);
        orders.setAid(address.getAid());
        Date date=new Date();
        orders.setOtime(date);
        orders.setOstate(0);
        //把生成的订单放到request作用域中
        req.setAttribute("MyOrder",orders);
        return Constants.FORWARD+Constants.FLAG+"/createOrder.jsp";
    }
    public String createOrder(HttpServletRequest req,HttpServletResponse resp){

        return Constants.FORWARD+Constants.FLAG+"/createOrder.jsp";
    }
}
