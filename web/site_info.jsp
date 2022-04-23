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
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="self_info_body">
    <div class="nav navbar-left">
        <p style="text-align: center">订单中心</p>
       <ul>
           <li><a href="">待付款</a></li>
           <li><a href="">待发货</a></li>
           <li><a href="">待收获</a></li>
           <li><a href="">待评价</a></li>
           <li><a href="${pageContext.request.contextPath}/address?method=show&uid=${loginUser.uid}">收货地址</a></li>
           <li><a href="">退款/售后</a></li>
           <li><a href="">足迹</a></li>
       </ul>
    </div>

</div>
</body>
</html>
