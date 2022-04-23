<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="#">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css.map" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        var bool = true;

        $(function () {
            <%--    ajax判断用户名是否重复--%>
            $("#username").change(function () {
                $.get("user", "username=" + this.value + "&method=check", function (data) {
                    if (data == 1) {
                        $("#usernameMsg").html("用户名已经存在").css("color", "red");
                        bool = false;
                    } else {
                        $("#usernameMsg").html("用户名可用").css("color", "green");
                        bool = true;
                    }
                })
            });
           //ajax判断邮箱格式是否正确
            $("#email").change(function () {
                $.get("user", "uemail=" + this.value + "&method=checkEmail", function (data) {
                    if (data == 1) {
                        $("#uemailMsg").html("邮箱格式正确").css("color", "green");
                        bool = true;
                    } else {
                        $("#uemailMsg").html("邮箱格式输入不正确").css("color", "red");
                        bool = false;
                    }
                })
            });
            //ajax判断密码是否是6位
            $("#password").change(function () {
                if (this.value.length > 6 || this.value.length < 1) {
                    $("#upasswordMsg").html("密码格式错误,请输入6位字符").css("color", "red");
                    bool = false;
                } else {
                    $("#upasswordMsg").html("密码可用").css("color", "green");
                    bool = true;
                }
            });
            $("#registerBtn").attr("disabled",(!bool));
        })

    </script>
</head>
<body>
<div class="register modal-dialog">
    <div class="modal-content">
        <%--        注册框的头部--%>
        <div class="register_header modal-header">
            <div class="header">
                <div class="col-xs-6 h3" style="text-align: left">用户注册</div>
                <div class="col-xs-6" style="text-align: right"><a href="index.jsp">首页</a></div>
            </div>
            <hr>
        </div>
        <%--    注册框的中部--%>
        <div class="regiser_body">
            <form action="/qfshop_war_exploded/user?method=register" method="post">
                <div class="modal-body">
                    <%--   用户名--%>
                    <div class="form-group">
                        <label class="control-label col-xs-9 " style="text-align: left">用户名：</label>
                        <div class="col-xs-3" style="text-align: right">
                            <p class="text-danger"><span class="help-block" id="usernameMsg"></span></p>
                        </div>
                        <input type="text" class="form-control" name="uname" id="username" placeholder="Username">
                    </div>
                    <%--    密码--%>
                    <div class="form-group">
                        <label class="control-label">密码：</label>
                        <input type="text" class="form-control" name="upassword" id="password" placeholder="Password">
                        <p class="text-danger"><span class="help-block" id="upasswordMsg">请不输入6位以上字符</span></p>
                    </div>
                    <%--    确认密码--%>
                    <div class="form-group">
                        <label class="control-label">确认密码：</label>
                        <input type="text" class="form-control" name="pwd2" id="pwd2" placeholder="Password Again">
                        <p class="text-danger"><span class="help-block" id="pwd2Msg">两次输入要一致</span></p>

                    </div>
                    <%--    邮箱--%>
                    <div class="form-group">
                        <label class="control-label">邮箱：</label>
                        <input type="text" class="form-control" name="uemail" id="email" placeholder="Email">
                        <p class="text-danger"><span class="help-block" id="uemailMsg">请填写正确格式</span></p>
                    </div>
                    <div class="form-group">
                        <label class="control-label">性别：</label>
                        <input type="radio" id="checkbox" name="usex" value="男">男
                        <input type="radio" id="checkbox2" name="usex" value="女">女
                    </div>
                </div>
                <%--    注册框的尾部--%>
                <div class="register_footer">
                    <div class="modal-footer">
                        <input type="submit" class="btn-primary" id="registerBtn" value="注册"/>
                        <input type="reset" value="重置" class="btn btn-default">
                    </div>
                </div>
            </form>
        </div>
        <div>${registerMsg}</div>
        <div id="notnull" class="text-danger"></div>
    </div>
</div>
</body>
</html>
