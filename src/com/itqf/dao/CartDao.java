package com.itqf.dao;

import com.itqf.entity.Cart;

import java.math.BigDecimal;
import java.util.List;

public interface CartDao {
    //查找当前uid和pid是否存在
    public Cart selectCartByuidtid(int uid, int pid);

    //插入数据
    public int insert(Cart cart);

    //更新数据
    public int update(Cart cart);

    //查询所有
    public List<Cart> selectCartByuid(int uid);

    //删除c_id=cid的商品
    public void deleteCartByCid(int cid);

    //删除u_id = uid的商品
    public void deleteCartByUid(int uid);

    //修改商品
    public void updateCartByCid(Double count, int cnum, int cid);
}
