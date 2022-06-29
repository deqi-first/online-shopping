package com.itqf.service;

import com.itqf.entity.Orders;

public interface OrderService {
    public void addOrder(Orders orders);
    public Orders findOrderByUid(int uid);
}
