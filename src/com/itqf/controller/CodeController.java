package com.itqf.controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CodeController",value = "/code")
public class CodeController extends BaseServlet {
    public void createCode(HttpServletRequest req,HttpServletResponse resp){
        ValidateCode code = new ValidateCode(100,35,4,21);
        String codes = code.getCode();
        HttpSession session = req.getSession();
        session.setAttribute("codes",codes);
        try {
            code.write(resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
