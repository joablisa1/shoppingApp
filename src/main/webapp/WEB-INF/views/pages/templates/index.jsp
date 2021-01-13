<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Lisa
  Date: 1/2/2021
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="/static/users/images/favicon1.png" rel="shortcut icon">
    <link rel="stylesheet" href="webjars/bootstrap/5.0.0-beta1/css/bootstrap.css">
    <link rel="stylesheet" href="webjars/bootstrap/5.0.0-beta1/css/bootstrap.min.css" id="bootstrap-css">
    <link rel="stylesheet" href="../../../static/users/animate-css/animate.min.css">
    <link rel="stylesheet" href="webjars/font-awesome/5.13.0/css/all.css">
    <link rel="stylesheet" href="webjars/font-awesome/5.13.0/css/all.min.css">
    <script src="/webjars/bootstrap/5.0.0-beta1/js/bootstrap.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/pages/navbar/headerbar.jsp" %>
<br><br><br>
<div class="container">
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <c:forEach items="${product}" var="product">
            <div class="col-md-3">
                <div class="card shadow-sm">
                    <a href="${pageContext.request.contextPath}/${product.sku}"><img
                            src="${pageContext.request.contextPath}/product/images/${product.id}" align="center"
                            alt="Design" width="100%" height="150"></a>
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text"> ${product.description}</p>
                        <p class="card-text"> ${product.price}</p>
                    </div>
                </div>
                    <%--<fmt:formatNumber value="${product.price}" type="currency"/>--%>
            </div>
        </c:forEach>
    </div>
</div>

<%@include file="../navbar/footers.jsp" %>
</body>
</html>
