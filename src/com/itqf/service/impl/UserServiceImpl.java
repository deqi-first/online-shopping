package com.itqf.service.impl;

import com.itqf.dao.UserDao;
import com.itqf.dao.impl.UserDaoImpl;
import com.itqf.entity.User;
import com.itqf.service.UserService;
import com.itqf.utils.Constants;
import com.itqf.utils.EmailUtils;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean checkUser(String name) {
        User user = userDao.selectUserByUname(name);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public int register(User user) {
        int result = 0;
        result = userDao.insert(user);
        EmailUtils.sendEmail(user);
        return result;
    }

    @Override
    public int activeUser(String code) {
        User user = null;
        //1.查找激活码
        user = userDao.selectUserCode(code);
        //2.判断是否激活
        if (user == null) {
            return 0;
        }
        if (user.getStatus() == Constants.USER_ACTIVE) {
            return 2;
        }
        int i = userDao.updateStatusByid(user.getUid());
        //3. 进行激活操作
        if (i > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public User login(String username, String password) {
        User user = null;
        user = userDao.selectUserByUname(username);
        if(user!=null && user.getUpassword().equals(password)){
            return user;
        }
        return user;
    }
}
