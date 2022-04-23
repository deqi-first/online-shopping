<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css.map">
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">商品列表</h3>
    </div>
    <div class="panel-body">
        <c:forEach items="${pageBean.list}" var="g" varStatus="i">
            <div class="col-xs-3">
                <div class="thumbnail">
                    <img src="${pageContext.request.contextPath}/${g.pimage}" width="180" height="180" alt="">
                    <div class="caption">
                        <h4>商品名称：<a href="${pageContext.request.contextPath}/product?method=goodDetail&pid=${g.pid}">${g.pname}</a></h4>
                        <p>
                            热销指数
                            <c:forEach begin="1" end="${g.pstate}">
                                <img src="image/hot.png" width="10" height="10" alt="">
                            </c:forEach>
                        </p>
                        <p>上架日期：${g.ptime}</p>
                        <p class="text-danger">价格：${g.pprice}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="panel-footer">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pageBean.pageIndex>1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/product?method=show&tid=${param.tid}&pageIndex=${pageBean.pageIndex-1}"
                           aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pageBean.pageIndex==1}">
                    <li>
                        <a aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${pageBean.totalPage}" step="1" var="index">
                    <li>
                        <a href="${pageContext.request.contextPath}/product?method=show&tid=${param.tid}&pageIndex=${index}">${index}</a>
                    </li>
                </c:forEach>
                <c:if test="${pageBean.pageIndex<pageBean.totalPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/product?method=show&tid=${param.tid}&pageIndex=${pageBean.pageIndex+1}"
                           aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pageBean.pageIndex==pageBean.totalPage}">
                    <a aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </c:if>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
