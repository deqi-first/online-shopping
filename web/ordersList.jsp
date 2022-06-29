<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<ol class="breadcrumb">
    <li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
    <li><a href="${pageContext.request.contextPath}/cart?method=show">购物车</a></li>
</ol>
<div class="nav nav-divider">
    <div class="container">
        <div class="row">
            <h3>订单列表</h3>
            <table class="table table-responsive table-hover table-striped table-condensed table-bordered">
                <tr>
                    <th>实付款</th>
                    <th>收获信息</th>
                    <th>订单编号</th>
                </tr>
                <c:forEach items="${MyOrdersList}" var="g" varStatus="i">
                    <tr>
                        <th>${g.ocount}</th>
                        <th>${g.address.aname}-${g.address.aphone}-${g.address.adetail}</th>
                        <th>${g.oid}</th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>

