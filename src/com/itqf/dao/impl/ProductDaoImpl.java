package com.itqf.dao.impl;

import com.itqf.dao.ProductDao;
import com.itqf.entity.Product;
import com.itqf.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());

    @Override
    public List<Product> selectProductByPage(int startRow, int pageSize, int type) {
        List<Product> list = null;
        String sql = "select p_id as pid,t_id as tid,p_name as pname,p_time as ptime,p_image as pimage,p_price as pprice,p_state as pstate,p_info as pinfo from product where t_id = ? limit ?,?;";
        try {
            list  = queryRunner.query(sql,new BeanListHandler<Product>(Product.class),type,startRow,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public long selectCountByTid(int type) {
        Long count = null;
        String sql = "select count(1) from product where t_id = ?";
        try {
           count= (Long) queryRunner.query(sql,new ScalarHandler(),type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Product select(int pid) {
        Product product = null;
        String sql = "select p_id as pid,t_id as tid,p_name as pname,p_time as ptime,p_image as pimage,p_price as pprice,p_state as pstate,p_info as pinfo from product where p_id = ?";
        try {
           product = queryRunner.query(sql,new BeanHandler<Product>(Product.class),pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
