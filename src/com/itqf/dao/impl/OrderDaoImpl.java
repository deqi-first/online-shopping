package com.itqf.dao.impl;

import com.itqf.dao.OrderDao;
import com.itqf.entity.Orders;
import com.itqf.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {
    private QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
    @Override
    public void insertOrder(Orders orders) {
        String sql = "insert into orders(o_id,a_id,u_id,o_count,o_time,o_state) values(?,?,?,?,?,?)";
        try {
            queryRunner.update(sql,orders.getOid(),orders.getAid(),orders.getUid(),orders.getOcount(),orders.getOtime(),orders.getOstate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Orders selectOrder(int uid) {
        String sql = "select o_id as oid,a_id as aid,u_id as  uid,o_count as ocount,o_time as otime,o_state as ostate from orders where u_id = ?";
        Orders orders = null;
        try {
          orders = queryRunner.query(sql,new BeanHandler<>(Orders.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
