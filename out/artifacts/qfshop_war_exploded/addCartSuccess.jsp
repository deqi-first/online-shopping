<%--
  Created by IntelliJ IDEA.
  User: deqi5
  Date: 2022/4/20
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css.map">
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="modal-content">
    <div class="modal-header">添加提示</div>
    <div class="modal-body">添加成功！是否跳转到购物车？</div>
    <div class="modal-footer">
        <button class="btn-success"><a href="${pageContext.request.contextPath}/cart?method=show&uid=${loginUser.uid}">查看购物车</a></button>
        <button class="btn-default"><a href="${pageContext.request.contextPath}/index.jsp">返回首页</a></button>
    </div>
</div>
</body>
</html>
