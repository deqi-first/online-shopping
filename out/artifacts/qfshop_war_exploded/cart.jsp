<%--
  Created by IntelliJ IDEA.
  User: deqi5
  Date: 2022/4/20
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css.map">
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function sub(cid, cnum, pprice) {
            if (cnum == 1) {
                if (confirm("当前商品数量为1，是否要移除？")) {
                    window.location.href = "cart?method=delete&cid=" + cid;
                }
            } else {
                cnum = cnum - 1;
                window.location.href = "cart?method=updateCart&cid=" + cid + "&cnum=" + cnum + "&pprice=" + pprice;
            }
        }

        function add(cid, cnum, pprice) {
            if (confirm("是否增加？")) {
                cnum = cnum + 1;
                window.location.href = "cart?method=updateCart&cid=" + cid + "&cnum=" + cnum + "&pprice=" + pprice;
            }
        }

        function delCart(cid) {
            if (confirm("是否要删除购物车数据？")) {
                window.location.href = "cart?method=delete&cid=" + cid;
            }
        }

        function createOrder(cid, uid) {
            if (confirm("是否要生成订单？")) {
                window.location.href = "order?method=showOrder&cid=" + cid + "&uid=" + uid;
            }
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <h3>我的购物车：<small>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</small></h3>
    </div>
    <div class="row">
        <c:if test="${empty cartList}">
            <h3>购物车空空如也，快去添加商品吧！！</h3>
        </c:if>
        <c:if test="${!empty cartList}">
            <div class="col-xs-10 col-xs-offset-1">
                <table class="table table-bordered table-striped table-hover table-responsive">
                    <tr>
                        <th>序号</th>
                        <th>商品名称</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>小计</th>
                        <th>操作</th>
                    </tr>
                    <c:set value="0" var="sum"></c:set>
                    <c:forEach items="${cartList}" var="c" varStatus="i">
                        <tr>
                            <th>${i.count}</th>
                            <th>${c.product.pname}</th>
                            <th>${c.product.pprice}</th>
                            <th>
                                <div class="input-group">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button"
                                            onclick="sub(${c.cid},${c.cnum},${c.product.pprice})">-</button>
                                </span>
                                    <input type="text" class="form-control" id="num_count${i.count}"
                                           value="${c.cnum}"
                                           readonly="readonly">
                                    <span class="input-group-btn">
                                    <button class="btn btn-default" type="button"
                                            onclick="add(${c.cid},${c.cnum},${c.product.pprice})">+</button>
                                </span>
                                </div>
                            </th>
                            <th>￥${c.ccount}</th>
                            <th>
                                <button type="button" class="btn btn-default" onclick="delCart(${c.cid})">删除</button>
                                <button type="button" class="btn btn-danger" onclick="createOrder(${c.cid},${c.uid})">
                                    结算
                                </button>
                            </th>
                        </tr>
                        <c:set var="sum" value="${sum+c.ccount}"></c:set>
                    </c:forEach>
                </table>
            </div>
        </c:if>
    </div>
    <div class="row">
        <div class="pull-right">
            <div>
                <a class="btn btn-default btn-lg"
                   href="${pageContext.request.contextPath}/cart?method=clearCart">清空购物车</a>&nbsp;
                <a href="${pageContext.request.contextPath}/address?method=show&uid=${loginUser.uid}"
                   class="btn btn-danger btn-lg">添加收获地址</a>
            </div>
            <div>
                商品金额总计：<span id="total" class="text-danger"><b>￥${sum}</b></span>
            </div>
        </div>
    </div>
</div>
</body>
</html>
