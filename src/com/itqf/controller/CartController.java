package com.itqf.controller;

import com.itqf.entity.Cart;
import com.itqf.entity.User;
import com.itqf.service.CartService;
import com.itqf.service.impl.CartServiceImpl;
import com.itqf.utils.Constants;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "CartController", value = "/cart")
public class CartController extends BaseServlet {
    public String addCart(HttpServletRequest req, HttpServletResponse resp) {
//        1.判断是否登录过
        User loginUser = (User) req.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            req.setAttribute("msg", "添加购物车必须先登录");
            return Constants.FORWARD + Constants.FLAG + "/Login.jsp";
        }
////        2.商品的id和用户的id
        int uid = loginUser.getUid();
        int pid = Integer.parseInt(req.getParameter("pid"));

//        3.调用业务逻辑添加购物车
        CartService cartService = new CartServiceImpl();
        cartService.addCart(uid, pid);

        return Constants.FORWARD + Constants.FLAG + "/addCartSuccess.jsp";
    }

    public String show(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession().getAttribute("loginUser");
        if (user == null) {
            req.setAttribute("msg", "查看购物车请先登录");
            return Constants.FORWARD + Constants.FLAG + "/Login.jsp";
        }
        CartService cartService = new CartServiceImpl();
        List<Cart> cartList = cartService.show(user.getUid());
        req.setAttribute("cartList", cartList);
        return Constants.FORWARD + Constants.FLAG + "/cart.jsp";
    }

    public String delete(HttpServletRequest req, HttpServletResponse resp) {
        int cid = Integer.parseInt(req.getParameter("cid"));
        CartService cartService = new CartServiceImpl();
        cartService.deleteCartByCid(cid);
        return Constants.FORWARD + Constants.FLAG + "/cart?method=show";
    }

    public String updateCart(HttpServletRequest req, HttpServletResponse resp) {
        int cnum = Integer.parseInt(req.getParameter("cnum"));
        String pprice = req.getParameter("pprice");
        int cid = Integer.parseInt(req.getParameter("cid"));
        CartService cartService = new CartServiceImpl();
        cartService.updateCartByCid(cid, cnum, pprice);
        return Constants.FORWARD + Constants.FLAG + "/cart?method=show";
    }

    public String clearCart(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User)req.getSession().getAttribute("loginUser");
        CartService cartService = new CartServiceImpl();
        cartService.deleteCartByUid(user.getUid());
        return Constants.FORWARD+Constants.FLAG+"/cart?method=show";
    }

}
