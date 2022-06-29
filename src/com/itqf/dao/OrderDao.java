package com.itqf.dao;

import com.itqf.entity.Orders;

public interface OrderDao {
    public void insertOrder(Orders orders);
    public Orders selectOrder(int uid);
}
