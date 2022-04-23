package com.itqf.dao.impl;

import com.itqf.dao.UserDao;
import com.itqf.entity.User;
import com.itqf.utils.C3p0Utils;
import com.itqf.utils.Constants;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

/*
 * 用户模块数据库访问的实现类*/
public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());

    @Override
    public User selectUserByUname(String username) {
        User user = null;
        String sql = "select u_id as uid,u_name as uname,u_password as upassword,u_email as uemail,u_sex as usex,u_status as status,u_code as ucode,u_role as urole from user where u_name = ?;";
        try {
            user = queryRunner.query(sql, new BeanHandler<User>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int insert(User user) {
        int result = 0;
        String sql = "insert into user(u_name,u_password,u_email,u_sex,u_status,u_code,u_role) values(?,?,?,?,?,?,?);";
        try {
            result = queryRunner.update(sql, user.getUname(), user.getUpassword(), user.getUemail(), user.getUsex(), user.getStatus(), user.getUcode(), user.getUrole());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User selectUserCode(String ucode) {
        User user = null;
        String sql = "select u_id as uid,u_name as uname,u_password as upassword,u_email as uemail,u_sex as usex,u_status as status,u_code as ucode,u_role as urole from user where u_code = ?;";
        try {
            user = queryRunner.query(sql, new BeanHandler<User>(User.class), ucode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int updateStatusByid(int id) {
        int result = 0;
        String sql = "update user set u_status = ? where u_id = ?";
        try {
            result = queryRunner.update(sql, Constants.USER_ACTIVE, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
