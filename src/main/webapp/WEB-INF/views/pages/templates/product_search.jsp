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
    <script src="/static/users/js/app.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/pages/navbar/headerbar.jsp"%>
<br><br><br>
<div class="container">
    <div class="row  text-center">
        <div class="col-lg-12 mb-4">
            <table class="table table-hover">
                <thead class="shadow-lg">
                <tr>
                    <th>Images</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Product Price</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <th style="width: 50px"> <img class="card-img-top " src="${pageContext.request.contextPath}/product/images/${product.id}" alt="Design" style="width: 90px; height: 90px;"></th>
                        <td ><a href="${pageContext.request.contextPath}/${product.sku}">${product.name}</a></td>
                        <td style="width: 550px">${product.description}</td>
                        <td>${product.price}</td>
                        <td><a href="#" onclick="'javascript:addItemToCart(\'' + ${product.sku} + '\');'"   class="btn btn-outline-success btn-sm"><span class="fa fa-shopping-cart"></span>Add to cart</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
<%--<%@include file="../navbar/footers.jsp"%>--%>
</body>
</html>
