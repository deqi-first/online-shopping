package com.itqf.dao.impl;

import com.itqf.dao.CartDao;
import com.itqf.entity.Cart;
import com.itqf.entity.Product;
import com.itqf.utils.C3p0Utils;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartDaoImpl implements CartDao {
    private QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());

    @Override
    public Cart selectCartByuidtid(int uid, int pid) {
        Cart cart = null;
        String sql = "select p.p_id as pid,p.t_id as tid,p.p_name as pname,p.p_time as ptime,p.p_image as pimage,p.p_price as pprice,p.p_state as pstate,p.p_info as pinfo,c.c_id as cid,c.u_id as uid,c.c_count as ccount,c.c_num as cnum from product p join cart c on p.p_id = c.p_id where c.u_id = ? and c.p_id = ?";
        Map<String, Object> query = null;
        try {
            query = queryRunner.query(sql, new MapHandler(), uid, pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (query == null) {
            return null;
        }
        Product product = new Product();
        try {
            BeanUtils.populate(cart, query);
            BeanUtils.populate(product, query);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public int insert(Cart cart) {
        int result = 0;
        String sql = "insert into cart(p_id,u_id,c_count,c_num) values(?,?,?,?)";
        try {
            result = queryRunner.update(sql, cart.getPid(), cart.getUid(), cart.getCcount(), cart.getCnum());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int update(Cart cart) {
        int result = 0;
        String sql = "update cart set c_count=?,c_num=? where c_id=?";
        try {
            result = queryRunner.update(sql, cart.getCnum(), cart.getCcount(), cart.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Cart> selectCartByuid(int uid) {
        String sql = "select p.p_id as pid,p.t_id as tid,p.p_name as pname,p.p_time as ptime,p.p_image as pimage,p.p_price as pprice,p.p_state as pstate,p.p_info as pinfo,c.c_id as cid,c.u_id as uid,c.c_count as ccount,c.c_num as cnum from product p join cart c on p.p_id = c.p_id where c.u_id = ?";
        List<Map<String, Object>> list = null;
        try {
            list = queryRunner.query(sql, new MapListHandler(), uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (list == null) {
            return null;
        }
        List<Cart> cartList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            Cart cart = new Cart();
            Product product = new Product();
            try {
                BeanUtils.populate(cart, map);
                BeanUtils.populate(product, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            cart.setProduct(product);
            cartList.add(cart);
        }
        return cartList;
    }

    @Override
    public void deleteCartByCid(int cid) {
        String sql = "delete from cart where c_id =?;";
        try {
            queryRunner.update(sql, cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCartByUid(int uid) {
        String sql = "delete from cart where u_id =?";
        try {
            queryRunner.update(sql, uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCartByCid(Double count, int cnum, int cid) {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "update cart set c_count = ?,c_num = ? where c_id = ?;";
        try {
            queryRunner.update(sql, count, cnum, cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
