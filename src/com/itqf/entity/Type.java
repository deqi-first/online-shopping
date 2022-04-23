package com.itqf.entity;

import java.io.Serializable;

public class Type implements Serializable {
    private static final long serialVersionUID = 2L;
    private int tid;
    private String tname;
    private String tinfo;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTinfo() {
        return tinfo;
    }

    public void setTinfo(String tinfo) {
        this.tinfo = tinfo;
    }

    @Override
    public String toString() {
        return "Type{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tinfo='" + tinfo + '\'' +
                '}';
    }
}
