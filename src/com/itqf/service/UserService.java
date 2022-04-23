package com.itqf.service;

import com.itqf.entity.User;

public interface UserService {
    //检测用户名是否存在
    public boolean checkUser(String name);
    //注册
    public int register(User user);
    //激活
    public int activeUser(String code);
    //登录
    public User login(String username,String password);
}
