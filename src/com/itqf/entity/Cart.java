package com.itqf.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cart implements Serializable {
    private static final long serialiVersionUID = 3L;
    private int cid;
    private int pid;
    private Product product;
    private int uid;
    private BigDecimal ccount;//购物车小计
    private int cnum;//购物车商品数量

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public BigDecimal getCcount() {
        BigDecimal pprice = product.getPprice();
        BigDecimal bigDecimal = new BigDecimal(cnum);
        return pprice.multiply(bigDecimal);
    }

    public void setCcount(BigDecimal ccount) {
        this.ccount = ccount;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", pid=" + pid +
                ", uid=" + uid +
                ", ccount=" + ccount +
                ", cnum=" + cnum +
                '}';
    }
}
