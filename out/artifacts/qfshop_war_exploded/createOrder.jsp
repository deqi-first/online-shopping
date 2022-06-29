<%--
  Created by IntelliJ IDEA.
  User: deqi5
  Date: 2022/4/21
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
       <div class="panel panel-default">
           <div class="panel-heading">
               订单详情
           </div>
           <div class="panel-body">
               <table class="table table-bordered table-condensed table-striped table-hover table-responsive">
                   <form action="${pageContext.request.contextPath}/order?method=addOrder" class="form-horizontal">
                       <tr>
                           <th>商品名称：</th>
                           <th><input type="text" value="${MyOrderProduct.pname}" readonly="readonly"></th>
                       </tr>
                       <tr>
                           <th>商品总价：</th>
                           <th><input type="text" value="${MyOrderProduct.pprice}" readonly="readonly"></th>
                       </tr>
                       <tr>
                           <th>订单创建时间：</th>
                           <th><input type="text" value="${MyOrder.otime}" readonly="readonly"></th>
                       </tr>
                       <tr>
                           <th>收获地址</th>
                           <th><input type="text" value="MyOrderAddress." readonly="readonly"></th>
                       </tr>
                       <input type="submit" class="btn btn-danger right" >提交订单</button>
                   </form>
               </table>
           </div>
           <div class="panel-footer"></div>

       </div>
    </div>
</div>
</body>
</html>
