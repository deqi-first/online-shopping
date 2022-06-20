<%--
  Created by IntelliJ IDEA.
  User: deqi5
  Date: 2022/4/19
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div>
    <ol class="breadcrumb">
        <li><a href="#">小米商城</a></li>
        <li><a href="${pageContext.request.contextPath}/product?method=show&tid=${product.tid}">手机</a></li>
        <li></li>
    </ol>
</div>
<div class="container">
    <div class="row">
        <div class="col-xs-6">
            <a href="#" class="thumbnail">
                <img src="${pageContext.request.contextPath}/${product.pimage}" alt="">
            </a>
        </div>
        <div class="col-xs-6">
            <div class="panel panel-default">
                <div class="panel-heading">商品详情</div>
                <div class="panel-body">
                    <h3>商品名称: <small>${product.pname}</small></h3>
                    <div>
                        <p>价格：${product.pprice}</p>
                        <p>上市时间：${product.ptime}</p>
                        <p>热销指数：
                            <c:forEach begin="1" end="${product.pstate}">
                                <img src="image/hot.png" alt="" width="20" height="20">
                            </c:forEach></p>
                        <p>详细介绍:${product.pinfo}</p>
                        <div>
                        <button type="button" class="btn btn-warning">
                            <a href="${pageContext.request.contextPath}/cart?method=addCart&pid=${product.pid}">加入购物车</a></button>&nbsp;
                        <button type="button" class="btn btn-danger"><a href="#">直接购买</a></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
