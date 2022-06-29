package com.itqf.service;

import com.itqf.entity.Orders;
import java.util.List;

public interface OrderService {
    public void addOrder(Orders orders);
    public Orders findOrderByUid(int oid);
    public List<Orders> findOrderListByUid(int uid);
}
