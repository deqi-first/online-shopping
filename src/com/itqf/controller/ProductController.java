package com.itqf.controller;

import com.itqf.entity.PageBean;
import com.itqf.entity.Product;
import com.itqf.service.ProductService;
import com.itqf.service.impl.ProductServiceImpl;
import com.itqf.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "ProductController",value = "/product")
public class ProductController extends BaseServlet {

    public String  show(HttpServletRequest req, HttpServletResponse resp) {
        int tid = Integer.parseInt(req.getParameter("tid"));
        int pageSize = 8;
        String pageIndex = req.getParameter("pageIndex");
        int page = 1;
        if(pageIndex!=null){
            page = Integer.parseInt(pageIndex);
        }
        //调用业务逻辑获取要展示的商品列表
        ProductService productService = new ProductServiceImpl();
        PageBean<Product> productPageBean = productService.goodsList(page,pageSize,tid);
        req.setAttribute("pageBean",productPageBean);
        return Constants.FORWARD+Constants.FLAG+"/goodsList.jsp";
    }

    public String goodDetail(HttpServletRequest req, HttpServletResponse resp){
       int pid =Integer.parseInt(req.getParameter("pid"));
       ProductService productService = new ProductServiceImpl();
       Product product = productService.goodDetail(pid);
        req.setAttribute("product",product);
        return Constants.FORWARD+Constants.FLAG+"/goodDetail.jsp";
    }

}
