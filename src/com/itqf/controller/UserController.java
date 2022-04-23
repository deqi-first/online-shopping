package com.itqf.controller;

import cn.dsna.util.images.ValidateCode;
import com.itqf.entity.User;
import com.itqf.service.UserService;
import com.itqf.service.impl.UserServiceImpl;
import com.itqf.utils.Constants;
import com.itqf.utils.MD5Utils;
import com.itqf.utils.RandomUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 用户模块的controller*/
@WebServlet(name = "UserController", value = "/user")
public class UserController extends BaseServlet {

    public String check(HttpServletRequest req, HttpServletResponse resp) {
        //1.获取用户名
        //2.调用业务逻辑判断用户名是否存在
        //3.响应字符串 1 存在 0 不存在
        String username = req.getParameter("username");
        if (username == null) {
            return Constants.HAS_USER;
        }
        UserService userService = new UserServiceImpl();
        boolean b = userService.checkUser(username);
        if (b) {
            return Constants.HAS_USER;
        }
        return Constants.NOT_HAS_USER;
    }

    public String register(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String[]> parameterMap = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        user.setStatus(Constants.USER_NOT_ACTIVE);//未激活0激活1
        user.setUcode(RandomUtils.createActive());//账号类型
        user.setUrole(Constants.ROLE_CUSTOMER);//用户0管理员1
//        //对密码加密处理
//        user.setUpassword(MD5Utils.md5(user.getUpassword()));
        UserService userService = new UserServiceImpl();
        try {
            userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("registerMsg", "注册失败！");
            return Constants.FORWARD + Constants.FLAG + "/Register.jsp";
        }
        return Constants.FORWARD + Constants.FLAG + "/registerSuccess.jsp";
    }

    public String active(HttpServletRequest req, HttpServletResponse resp) {
        //1.获取激活码
        String code = req.getParameter("c");

        //2.调用激活的业务逻辑
        UserService userService = new UserServiceImpl();
        int i = userService.activeUser(code);
        //3.响应（激活失败（code没有找到）、已经激活、激活成功）
        if (i == 0) {
            req.setAttribute("msg", "未激活成功");
        } else if (i == 1) {
            req.setAttribute("msg", "激活成功，请登录");
        } else {
            req.setAttribute("msg", "已经激活过了");
        }
        return Constants.FORWARD + Constants.FLAG + "/message.jsp";
    }

    public String login(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        String auto = req.getParameter("auto");
        HttpSession session = req.getSession();
        String codes = (String) session.getAttribute("codes");
        if (code == null || !code.equalsIgnoreCase(codes)) {
            req.setAttribute("msg", "验证码输入错误，请重新输入");
            return Constants.FORWARD + Constants.FLAG + "/Login.jsp";
        }
        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);
        if (user == null) {
            req.setAttribute("msg", "账号输入错误，请重新输入");
            return Constants.FORWARD + Constants.FLAG + "/Login.jsp";
        }
        if(user.getStatus()==Constants.USER_NOT_ACTIVE){
            req.setAttribute("msg", "账号未激活，请查看邮箱激活账号");
            return Constants.FORWARD + Constants.FLAG + "/Login.jsp";
        }
        session.setAttribute("loginUser",user);
        if (auto == null) {
            Cookie cookie = new Cookie(Constants.AUTO_NAME,"");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }else {
            String content = username+Constants.FLAG+password;
            Cookie cookie = new Cookie(Constants.AUTO_NAME,content);
            cookie.setPath("/");
            cookie.setMaxAge(14*24*60*60);//2周内保存
            resp.addCookie(cookie);
        }

        return Constants.FORWARD + Constants.FLAG + "/LoginSuccess.jsp";
    }

    public String loginOut(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        session.removeAttribute("loginUser");

        Cookie cookie = new Cookie(Constants.AUTO_NAME,"");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        return Constants.FORWARD+Constants.FLAG+"/Login.jsp";
    }
    public String checkEmail(HttpServletRequest req, HttpServletResponse resp){
        String uemail = req.getParameter("uemail");
        boolean result = isEmail(uemail);
        if(result){
            return "1";
        }
        return "0";
    }
    public static boolean isEmail(String string) {
        if (string == null)
            return false;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        if (m.matches())
            return true;
        else
            return false;
    }

}
