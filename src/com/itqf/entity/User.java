package com.itqf.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 4L;
    private int uid;
    private String uname;
    private String upassword;
    private String uemail;
    private String usex;
    private int status;
    private String ucode;
    private int urole;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    public int getUrole() {
        return urole;
    }

    public void setUrole(int urole) {
        this.urole = urole;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", uemail='" + uemail + '\'' +
                ", usex='" + usex + '\'' +
                ", status=" + status +
                ", ucode='" + ucode + '\'' +
                ", urole=" + urole +
                '}';
    }
}
