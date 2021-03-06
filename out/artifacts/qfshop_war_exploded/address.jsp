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
        };
        $(function () {
            $("form").submit(
                function () {
                    if ($.trim($(":text:eq(0)").val()) == "" || $.trim($(":text:eq(1)").val()) == "" || $.trim($(":text:eq(2)").val()) == "") {
                        alert("请填写完整信息！")
                        return false;
                    }
                }
            )
        });


    </script>
</head>
<body>
<%--<jsp:include page="header.jsp"/>--%>
<ol class="breadcrumb">
    <li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
    <li><a href="${pageContext.request.contextPath}/cart?method=show">购物车</a></li>
</ol>
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
            <form action="${pageContext.request.contextPath}/address?method=addAddress" method="post">
                <div class="form-control">
                    <label class="col-xs-2 control-label">收货人</label>
                    <div class="col-xs-10">
                        <input type="text" name="aname" id="aname">
                    </div>
                </div>
                <div class="form-control">
                    <label class="col-xs-2 control-label">手机号码</label>
                    <div class="col-xs-10">
                        <input type="text" name="aphone" id="aphone">
                    </div>
                </div>
                <div class="form-control">
                    <label class="col-xs-2 control-label">收获地址</label>
                    <div class="col-xs-10">
                        <input type="text" name="adetail" id="adetail">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-danger" value="提交">

                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
