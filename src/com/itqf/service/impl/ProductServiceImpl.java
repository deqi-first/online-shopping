package com.itqf.service.impl;

import com.itqf.dao.ProductDao;
import com.itqf.dao.impl.ProductDaoImpl;
import com.itqf.entity.PageBean;
import com.itqf.entity.Product;
import com.itqf.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public PageBean<Product> goodsList(int pageIndex, int pageSize, int type) {
        ProductDao productDao = new ProductDaoImpl();
        List<Product> list = productDao.selectProductByPage(((pageIndex-1)*pageSize),pageSize,type);
        long count = productDao.selectCountByTid(type);
        PageBean<Product> productPageBean = new PageBean<Product>(list,pageIndex,pageSize,count);
        return productPageBean;
    }

    @Override
    public Product goodDetail(int pid) {
        Product product = null;
        ProductDao productDao = new ProductDaoImpl();
        product = productDao.select(pid);
        return product;
    }
}
