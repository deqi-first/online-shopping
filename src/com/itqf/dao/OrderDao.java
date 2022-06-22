package com.itqf.dao;

import com.itqf.entity.Orders;

public interface OrderDao {
    public int addOrder(Orders orders);
    public Orders selectOrder(int uid);
}
