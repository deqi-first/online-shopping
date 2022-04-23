package com.itqf.controller;

import com.itqf.entity.Address;
import com.itqf.entity.User;
import com.itqf.service.AddressService;
import com.itqf.service.impl.AddressServiceImpl;
import com.itqf.utils.Constants;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AddressController",value = "/address")
public class AddressController extends BaseServlet {
   public String show(HttpServletRequest req,HttpServletResponse resp){
       HttpSession session = req.getSession();
       User user = (User)session.getAttribute("loginUser");
       if(user==null){
           session.setAttribute("msg","请先登录");
           return Constants.FORWARD+Constants.FLAG+"/Login.jsp";
       }
       AddressService addressService=new AddressServiceImpl();
       List<Address> addressList= addressService.findAddressByUid(user.getUid());
       session.setAttribute("addressList",addressList);
       return Constants.FORWARD+Constants.FLAG+"/address.jsp";
   }
   public String showModal(HttpServletRequest req,HttpServletResponse resp){
        int aid = Integer.parseInt(req.getParameter("aid"));
        AddressService service = new AddressServiceImpl();
        Address address = service.findAddressByAid(aid);
        if(address==null){
            return Constants.FORWARD+Constants.FLAG+"/Login.jsp";
        }
        req.getSession().setAttribute("updateaddress",address);
       return Constants.FORWARD+Constants.FLAG+"/updateAddress.jsp";
   }
   public String updateAddressByAid(HttpServletRequest req,HttpServletResponse resp){
       int aid = Integer.parseInt(req.getParameter("aid"));
       User user = (User)req.getSession().getAttribute("loginUser");
       Map<String, String[]> parameterMap = req.getParameterMap();
       Address address = new Address();
       try {
           BeanUtils.populate(address, parameterMap);
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (InvocationTargetException e) {
           e.printStackTrace();
       }
       address.setAid(aid);
       AddressService service= new AddressServiceImpl();
       service.updateAddressByAid(address);
       return Constants.FORWARD+Constants.FLAG+"/address?method=show";
   }
   public String deleteAddress(HttpServletRequest req,HttpServletResponse resp){
       int aid = Integer.parseInt(req.getParameter("aid"));
       AddressService service= new AddressServiceImpl();
       service.deleteAddressByAid(aid);
       return Constants.FORWARD+Constants.FLAG+"/address?method=show";
   }
   public String addAddress(HttpServletRequest req,HttpServletResponse resp){
       User user = (User)req.getSession().getAttribute("loginUser");
       Map<String, String[]> parameterMap = req.getParameterMap();
       Address address = new Address();
       try {
           BeanUtils.populate(address, parameterMap);
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (InvocationTargetException e) {
           e.printStackTrace();
       }
       address.setUid(user.getUid());
       address.setAstate(0);
       AddressService service= new AddressServiceImpl();
       service.addAddress(address);
       return Constants.FORWARD+Constants.FLAG+"/address?method=show";
   }
   public String setAddressToDefault(HttpServletRequest req,HttpServletResponse resp){
       int aid = Integer.parseInt(req.getParameter("aid"));
       int uid = Integer.parseInt(req.getParameter("uid"));
       AddressService service= new AddressServiceImpl();
       service.setAddressToDefault(aid,uid);
       return Constants.FORWARD+Constants.FLAG+"/address?method=show";
   }
}
