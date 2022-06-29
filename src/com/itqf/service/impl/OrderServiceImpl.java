package com.itqf.service.impl;

import com.itqf.dao.OrderDao;
import com.itqf.dao.impl.OrderDaoImpl;
import com.itqf.entity.Orders;
import com.itqf.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    @Override
    public void addOrder(Orders orders) {
        orderDao.insertOrder(orders);
    }

    @Override
    public Orders findOrderByUid(int uid) {
        Orders orders =null;
        orders = orderDao.selectOrder(uid);
        return orders;
    }
}
