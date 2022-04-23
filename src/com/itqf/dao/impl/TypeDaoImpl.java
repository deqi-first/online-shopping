package com.itqf.dao.impl;

import com.itqf.dao.TypeDao;
import com.itqf.entity.Type;
import com.itqf.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class TypeDaoImpl implements TypeDao {
    private QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
    @Override
    public List<Type> selectAll() {
        List<Type> list = null;
        String sql = "select t_id as tid,t_name as tname,t_info as tinfo from type limit 0,5;";
        try {
           list =  queryRunner.query(sql,new BeanListHandler<Type>(Type.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
