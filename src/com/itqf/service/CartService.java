package com.itqf.service;

import com.itqf.entity.Cart;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    //添加购物车
    public void addCart(int uid,int pid);
    public List<Cart> show(int uid);
    public void deleteCartByCid(int cid);
    public void updateCartByCid(int cid,int cnum,String pprice);
    public void deleteCartByUid(int uid);
    public Cart findCartByCid(int cid);
}
