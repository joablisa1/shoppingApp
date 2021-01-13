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
    <div class="row">
        <div class="col-lg-12 mb-4">
            <form action="#" method="post" id="myform">
            <table class="table table-hover table-responsive-sm table-sm">
                <thead class="bg-success shadow-lg">
                <tr>
                    <th>Thumbnail</th>
                    <th>Product Name</th>
                    <th>product price</th>
                    <th>Product Quantity</th>
                    <th>Amount</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cart.items}" var="item">
                    <tr>
                        <th scope="row"> <img class="card-img-top " src="${pageContext.request.contextPath}/product/images/${item.product.id}" alt="Design" style="width: 90px; height: 90px;"></th>
                        <td><a href="${pageContext.request.contextPath}/${item.product.sku}">${item.product.name}</a></td>
                        <td>${item.product.price}</td>
                        <td> <input type="text" size="5" value="${item.quantity}" onchange="updateCartItemQuantity(${item.product.sku},${item.quantity});"/> </td>
                        <td>${item.product.price * item.quantity}</td>
                        <td>
                            <a href="#"  onclick="removeItemFromCart(${item.product.sku}); "   class="btn btn-outline-danger btn-sm"><span class="fa fa-trash"></span>Remove</a>
                            <a href="${pageContext.request.contextPath}/checkout" class="btn btn-outline-success"><span class="fa fa-shopping-basket"></span> Checkout  </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </form>
            <table class="table table-hover table-sm table-responsive-sm">
                <thead>
                <tr>
                    <th>Cart Subtotal</th>
                    <th>Order Total</th>
                </tr>
                </thead>
                <tbody>
                <tr>

                    <td>${cart.totalAmount}</td>
                    <td><strong><span >${cart.totalAmount}</span></strong> </td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>

</div>

<%--<%@include file="../navbar/footers.jsp"%>--%>
</body>
</html>
