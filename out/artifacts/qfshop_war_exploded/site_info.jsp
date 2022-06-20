<%--
  Created by IntelliJ IDEA.
  User: deqi5
  Date: 2022/4/21
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"/>
    <script src="js/jquery-3.5.1.js"/>
    <script>
        $(function () {
            window.open("/address?", "workAreaFrame")
        });
    </script>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="self_info_body">
    <div style="position: relative;overflow: auto">
        <p style="text-align: center">订单中心</p>
        <ul id="navigation" class="nav" style="float: left">
<%--            <li role="presentation" class="active"><a href="#">--%>
<%--                工作台</a></li>--%>
            <li><a href="">待付款</a></li>
            <li><a href="">待发货</a></li>
            <li><a href="">待收获</a></li>
            <li><a href="">待评价</a></li>
            <li><a href="${pageContext.request.contextPath}/address?method=show&uid=${loginUser.uid}">收货地址</a></li>
            <li><a href="">退款/售后</a></li>
            <li><a href="">足迹</a></li>
        </ul>
    </div>
    <div id="workArea" style="position:absolute;top:0px;left:18%;width:82%;height:100%;">
        <iframe style="border-width:0px;width:100%;height:100%;" name="workAreaFrame">
        </iframe>
    </div>
</div>
</body>
</html>
