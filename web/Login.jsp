<%--
  Created by IntelliJ IDEA.
  User: deqi5
  Date: 2022/4/15
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-wideh,initial-scale">
    <link rel="stylesheet" href=css/login.css>
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <title>登录</title>
    <script type="text/javascript">
        $(function () {
            $("#pagecode").click(function () {
                $("#pagecode").attr("src","/qfshop_war_exploded/code?method=createCode&t="+Math.random());
            });
        })
    </script>
</head>

<body>
<section>
    <!--背景色-->
    <div class="color"></div>
    <div class="color"></div>
    <div class="color"></div>
    <div class="box">
        <!--背景圆-->
        <div class="circlre" style="--x:0"></div>
        <div class="circlre" style="--x:1"></div>
        <div class="circlre" style="--x:2"></div>
        <div class="circlre" style="--x:3"></div>
        <div class="circlre" style="--x:4"></div>
        <!--登录框-->
        <div class="container">
            <div class="form">
                <h2>登录</h2>
                <form action="/qfshop_war_exploded/user?method=login" method="post">
                    <div class="inputBox">
                        <input type="text" placeholder="姓名" name="username">
                    </div>
                    <div class="inputBox">
                        <input type="password" placeholder="密码" name="password">
                    </div>
                    <div class="inputBox">
                        <input type="text" placeholder="验证码" name="code"> <p><img id="pagecode" src="/qfshop_war_exploded/code?method=createCode" alt="">
                    </p>
                    </div>
                   <div >
                       <input type="checkbox" id="autoLogin" name="auto" />2周内自动登录
                       <span id="autoLoginMsg" ></span>
                   </div>
                    <div class="inputBox">
                        <input type="submit" value="登录">
                    </div>
                    <p class="forget">没有账户？
                        <a href="Register.jsp">点击注册</a>
                    </p>
                    <span class="text-danger">${msg}</span>
                </form>

            </div>
        </div>
    </div>
</section>
</body>

</html>
