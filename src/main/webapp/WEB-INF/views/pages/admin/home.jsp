<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lisa
  Date: 6/8/2020
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <title>Dashboard</title>
    <!-- Custom fonts for this template-->
    <link rel="stylesheet" href="webjars/bootstrap/5.0.0-beta1/css/bootstrap.css">
    <link rel="stylesheet" href="webjars/bootstrap/5.0.0-beta1/css/bootstrap.min.css" id="bootstrap-css">
    <link rel="icon" type="image/x-icon" href="<c:url value="/static/img/favicon1.png"/>" />
    <link href="/static/css/dashboard.css" rel="stylesheet">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

</head>
<body>
<%@include file="../menu/header.jsp"%>
<div class="container-fluid">
    <div class="row">
        <%@include file="../menu/sidebar.jsp"%>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
          <%@include file="../menu/submenubar.jsp"%>


        </main>


    </div>
</div>
<script src="/static/js/dashboard.js" type="application/javascript"></script>
<script src="webjars/bootstrap/5.0.0-beta1/js/bootstrap.js" type="application/javascript"></script>
<script src="webjars/jquery/3.4.1/jquery.min.js" type="application/javascript"></script>
<script src="webjars/bootstrap/5.0.0-beta1/js/bootstrap.bundle.js" type="application/javascript"></script>
</body>
</html>
