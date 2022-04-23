<%--
  Created by IntelliJ IDEA.
  User: deqi5
  Date: 2022/4/17
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <meta charset="UTF-8">--%>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css.map">
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/type?method=findAllType",
                type: "GET",
                dataType: "json",
                success: function (data) {
                    for (var i in data) {
                        var a = "<li><a href='${pageContext.request.contextPath}/product?method=show&tid=" + data[i].tid + "'>" + data[i].tname + "</a></li>";
                        $("#goodsType").append(a);
                    }
                },
                error: function () {
                    alert("失败");
                }
            })
        })
    </script>
</head>
<body>

<div>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">myShop商城</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/Login.jsp">登录<span class="sr-only">(current)</span></a>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/Register.jsp">注册</a></li>
                    <li><a href="${pageContext.request.contextPath}/user?method=loginOut">注销</a></li>
                </ul>
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="搜索一下">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/site_info.jsp">个人中心</a></li>
                    <li><a href="${pageContext.request.contextPath}/cart?method=show&uid=${loginUser.uid}">购物车</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    <nav class="navbar navbar-default">
        <p>
        <ul id="goodsType" class="nav nav-tabs">
        </ul>
        </p>
    </nav>
</div>

</body>

</html>
