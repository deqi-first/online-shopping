package com.itqf.dao;

import com.itqf.entity.User;

/*
 * 用户模块数据库访问的接口*/
public interface UserDao {
    public User selectUserByUname(String username);
    public int insert(User user);
    public User selectUserCode(String ucode);
    public int updateStatusByid(int id);
}
