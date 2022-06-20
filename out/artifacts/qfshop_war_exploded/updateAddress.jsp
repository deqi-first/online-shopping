<%--
  Created by IntelliJ IDEA.
  User: deqi5
  Date: 2022/4/21
  Time: 14:41
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
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span>×</span></button>
                <h4 class="modal-title">修改地址</h4>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/address?method=updateAddressByAid&aid=${updateaddress.aid}" method="post" class="form-horizontal">
                    <div class="form-control">
                        <label class="col-xs-2 control-label">收货人</label>
                        <div class="col-xs-10">
                            <input type="text" name="aname" value="${updateaddress.aname}">
                        </div>
                    </div>
                    <div class="form-control">
                        <label class="col-xs-2 control-label">手机号码</label>
                        <div class="col-xs-10">
                            <input type="text" name="aphone" value="${updateaddress.aphone}">
                        </div>
                    </div>
                    <div class="form-control">
                        <label class="col-xs-2 control-label">收获地址</label>
                        <div class="col-xs-10">
                            <input type="text" name="adetail" value="${updateaddress.adetail}">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-danger" type="submit">修改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
