<%--
  Created by IntelliJ IDEA.
  User: deqi5
  Date: 2022/4/21
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css.map">
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function showmodal(aid) {
            window.location.href = "address?method=showModal&aid=" + aid;
        }

        function deleteAddress(aid) {
            if (confirm("是否删除该收获地址？")) {
                window.location.href = "address?method=deleteAddress&aid=" + aid;
            }
        }

        function setAddressToDefault(aid, uid) {
            if (confirm("是否设置为默认地址")) {
                window.location.href = "address?method=setAddressToDefault&aid=" + aid + "&uid=" + uid;
            }
        }
    </script>
</head>
<body>
<jsp:include page="site_info.jsp"/>
<div class="nav nav-divider">
    <div class="container">
        <div class="row">
            <h3>收货地址</h3>
            <table class="table table-responsive table-hover table-striped table-condensed table-bordered">
                <tr>
                    <th>序号</th>
                    <th>收货人</th>
                    <th>手机号码</th>
                    <th>所在地区详细地址</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${addressList}" var="g" varStatus="i">
                    <tr>
                        <th>${i.count}</th>
                        <th>${g.aname}</th>d
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
            <form action="${pageContext.request.contextPath}/address?method=addAddress" method="post">
                <div class="form-control">
                    <label class="col-xs-2 control-label">收货人</label>
                    <div class="col-xs-10">
                        <input type="text" name="aname">
                    </div>
                </div>
                <div class="form-control">
                    <label class="col-xs-2 control-label">手机号码</label>
                    <div class="col-xs-10">
                        <input type="text" name="aphone">
                    </div>
                </div>
                <div class="form-control">
                    <label class="col-xs-2 control-label">收获地址</label>
                    <div class="col-xs-10">
                        <input type="text" name="adetail">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-danger" type="submit">添加</button>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>
