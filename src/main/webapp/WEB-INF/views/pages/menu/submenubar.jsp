<%--
  Created by IntelliJ IDEA.
  User: Lisa
  Date: 1/6/2021
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="webjars/bootstrap/5.0.0-beta1/css/bootstrap.css">
    <link rel="stylesheet" href="webjars/bootstrap/5.0.0-beta1/css/bootstrap.min.css" id="bootstrap-css">
    <link rel="icon" type="image/x-icon" href="<c:url value="/static/img/favicon1.png"/>" />
    <link href="/static/css/dashboard.css" rel="stylesheet">
</head>
<body>
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">Dashboard</h1>
    <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group me-2">
            <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
            <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
        </div>
        <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
            <span data-feather="calendar"></span>
            This week
        </button>
    </div>
</div>


</body>
</html>
