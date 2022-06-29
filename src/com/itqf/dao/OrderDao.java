package com.itqf.dao;

import com.itqf.entity.Orders;

import java.util.List;

public interface OrderDao {
    public void insertOrder(Orders orders);
    public Orders selectOrder(int oid);
    public List<Orders> selectOrderListByUid(int uid);
}
