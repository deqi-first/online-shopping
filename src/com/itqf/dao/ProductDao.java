package com.itqf.dao;

import com.itqf.entity.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> selectProductByPage(int startRow,int pageSize,int type);
    public long selectCountByTid(int type);
    public Product select(int pid);
}
