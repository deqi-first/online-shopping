package com.itqf.service.impl;

import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.itqf.dao.CartDao;
import com.itqf.dao.ProductDao;
import com.itqf.dao.impl.CartDaoImpl;
import com.itqf.dao.impl.ProductDaoImpl;
import com.itqf.entity.Cart;
import com.itqf.entity.Product;
import com.itqf.service.CartService;

import java.math.BigDecimal;
import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDao cartDao = new CartDaoImpl();

    @Override
    public void addCart(int uid, int pid) {
        Cart cart = cartDao.selectCartByuidtid(uid, pid);
        if (cart != null) {
            cart.setCnum(cart.getCnum() + 1);
            cartDao.update(cart);
        } else {
            ProductDao productDao = new ProductDaoImpl();
            Product product = productDao.select(pid);
            cart = new Cart();
            cart.setUid(uid);
            cart.setCnum(1);
            cart.setPid(pid);
            cart.setProduct(product);
        }
        cartDao.insert(cart);
    }

    @Override
    public List<Cart> show(int uid) {
        List<Cart> cartList = cartDao.selectCartByuid(uid);
        return cartList;
    }

    @Override
    public void deleteCartByCid(int cid) {
        cartDao.deleteCartByCid(cid);
    }

    @Override
    public void updateCartByCid(int cid, int cnum, String pprice) {
        Double ccount = Double.valueOf(pprice) * cnum;
        cartDao.updateCartByCid(ccount, cnum, cid);
    }

    @Override
    public void deleteCartByUid(int uid) {
        cartDao.deleteCartByUid(uid);
    }

    @Override
    public Cart findCartByCid(int cid) {
        return  cartDao.selectCartByCid(cid);
    }

}
