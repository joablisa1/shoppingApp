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
    <div class="row row-cols-1 row-cols-md-2 g-4">
        <%--<c:forEach items="${product}" var="product">--%>
            <div class="col">
                <div class="card ">
                    <div class="row g-0">
                        <div class="col-md-5">
                            <img class="card-img-top " src="${pageContext.request.contextPath}/product/images/${product.id}" alt="Design"width="100%" height="250" >
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">Product ID:${product.sku}</h5>
                            <p class="card-subtitle"> Product Category:${product.category.name}</p>
                            <p class="card-text">Product Description:${product.description}</p>
                            <p class="card-text">Product Price:${product.price}</p>
                            <%--<a href="${pageContext.request.contextPath}/cart/items/${product.sku}" class="btn btn-outline-success btn-sm">add to cart</a>--%>
                            <button class="btn btn-outline-success btn-sm" type="submit"  id="add-to-cart-button"
                                    onclick=addItemToCart(${product.sku})><span class="fa fa-shopping-cart"></span>Add to cart </button>
                            <a class="btn btn-outline-success btn-sm" href="${pageContext.request.contextPath}/">Continue Shopping</a>
                        </div>
                    </div>
                </div>

                <%----%>
                <%--<div class="card h-100 w-100 justify-content-center">--%>
                    <%--<img class="card-img-top " src="${pageContext.request.contextPath}/product/images/${product.id}" alt="Design" style="width: 200px; height: 190px;">--%>
                    <%--<div class="card-body">--%>
                        <%--<h5 class="card-title">Product ID:${product.sku}</h5>--%>
                        <%--<p class="card-subtitle"> Product Category:${product.category.name}</p>--%>
                        <%--<p class="card-text">Product Description:${product.description}</p>--%>
                        <%--<p class="card-text">Product Price:${product.price}</p>--%>
                        <%--&lt;%&ndash;<a href="${pageContext.request.contextPath}/cart/items/${product.sku}" class="btn btn-outline-success btn-sm">add to cart</a>&ndash;%&gt;--%>
                      <%--<button class="btn btn-outline-success btn-sm" type="submit"  id="add-to-cart-button"--%>
                                <%--onclick=addItemToCart(${product.sku})><span class="fa fa-shopping-cart"></span>Add to cart </button>--%>
                        <%--<a class="btn btn-outline-success btn-sm" href="${pageContext.request.contextPath}/">Continue Shopping</a>--%>
                    <%--</div>--%>
                <%--</div>--%>
            </div>
        <%--</c:forEach>--%>
    </div>


</div>
<%--<%@include file="../navbar/footers.jsp"%>--%>
</body>
</html>
