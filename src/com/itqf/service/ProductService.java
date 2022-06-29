package com.itqf.service;

import com.itqf.entity.PageBean;
import com.itqf.entity.Product;

import java.util.List;

public interface ProductService {
    public PageBean<Product> goodsList(int pageIndex, int pageSize, int type);
    public Product findGoodDetailByPid(int pid);
}
