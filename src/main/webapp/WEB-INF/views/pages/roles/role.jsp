<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard</title>
    <link href="/static/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link rel="stylesheet" href="webjars/bootstrap/4.3.1/css/bootstrap.css">
    <link href="/static/assets/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="/webjars/jquery-ui/1.12.1/jquery-ui.css" rel="stylesheet">
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="icon" type="image/x-icon" href="<c:url value="/static/img/favicon1.png"/>" />
</head>

<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">
    <!-- Sidebar - Brand -->
    <%@include file="../menu/sidebar.jsp" %>
    <!-- End of Sidebar -->
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">
            <%@include file="../menu/header.jsp" %>
            <div class="container-fluid">
                <h4 class=" mb-2 text-gray-800  text-sm-right font-weight-normal ">Roles</h4>
                <p class="mb-4"><a href="${pageContext.request.contextPath}/roles/new" class="mr-auto btn btn-outline-success"><span class="fa fa-plus"></span>create new role </a></p>
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h5 class="m-0  font-weight-lighter text text-primary">List of Roles</h5>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive-sm ">
                            <table class="table table-hover table-bordered  " id="dataTable">
                                <thead class="bg-gradient-success">
                                <tr>
                                    <th style="width: 10px"><input type="checkbox" id="check-all"></th>
                                    <th >Name</th>
                                    <th >Description</th>
                                    <th >Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${roles}" var="role">
                                    <tr>
                                        <th scope="row"><input type="checkbox" id="check-all-"></th>
                                        <td>${role.name}</td>
                                        <td>${role.description}</td>
                                        <td><a href="${pageContext.request.contextPath}/roles/edit/${role.id}"
                                               class="btn btn-outline-success btn-sm"><span class="fa fa-pen"></span>Edit</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->
        <%@include file="../menu/footer.jsp" %>
        <!-- End of Footer -->
    </div>
    <!-- End of Content Wrapper -->
</div>
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>
<!-- Bootstrap core JavaScript-->
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- Bootstrap core JavaScript-->
<script src="/static/assets/vendor/jquery/jquery.min.js"></script>
<script src="/static/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/static/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="/static/assets/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="/static/assets/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="/static/assets/js/demo/chart-area-demo.js"></script>
<script src="/static/assets/js/demo/chart-pie-demo.js"></script>
</body>
</html>
