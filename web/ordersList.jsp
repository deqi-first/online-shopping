<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="nav nav-divider">
    <div class="container">
        <div class="row">
            <h3>订单列表</h3>
            <table class="table table-responsive table-hover table-striped table-condensed table-bordered">
                <tr>
                    <th>实付款</th>
                    <th>商品信息</th>
                    <th>手机号码</th>
                    <th>收获信息</th>
                    <th>订单编号</th>
                </tr>
                <c:forEach items="${addressList}" var="g" varStatus="i">
                    <tr>
                        <th>${i.count}</th>
                        <th>${g.aname}</th>
                        <th>${g.aphone}</th>
                        <th>${g.adetail}</th>
                        <th>
                            <button class="btn btn-danger" onclick="deleteAddress(${g.aid})">删除</button>
                            <button class="btn btn-default btn-sm" onclick="showmodal(${g.aid})">修改</button>
                            <button class="btn btn-primary" onclick="setAddressToDefault(${g.aid},${g.uid})">设为默认地址
                            </button>
                            <c:if test="${g.astate==1}">
                                <span class="badge" style="background-color: rgba(255,172,65,0.96)">默认</span>
                            </c:if>
                            <c:if test="${g.astate==0}">
                                <span class="badge" style="background-color: rgba(175,175,175,0.96)">普通</span>
                            </c:if>
                        </th>
                    </tr>
                </c:forEach>

            </table>

        </div>
    </div>
</div>
</body>
</html>

