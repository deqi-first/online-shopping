package com.itqf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Orders implements Serializable {

    private static final long serialVersionUID = 5L;
    private String oid;
    private int aid;
    private int uid;
    private BigDecimal ocount;
    private Address address;
    private LocalDateTime otime;
    private int ostate;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public BigDecimal getOcount() {
        return ocount;
    }

    public void setOcount(BigDecimal ocount) {
        this.ocount = ocount;
    }

    public LocalDateTime getOtime() {
        return otime;
    }

    public void setOtime(LocalDateTime otime) {
        this.otime = otime;
    }

    public int getOstate() {
        return ostate;
    }

    public void setOstate(int ostate) {
        this.ostate = ostate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", aid=" + aid +
                ", uid=" + uid +
                ", ocount=" + ocount +
                ", otime=" + otime +
                ", ostate=" + ostate +
                '}';
    }
}
