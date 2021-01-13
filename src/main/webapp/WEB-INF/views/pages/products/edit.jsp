<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lisa
  Date: 10/12/2020
  Time: 8:10 AM
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
    <!-- Custom fonts for this template-->
    <link href="/static/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/static/assets/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="/webjars/jquery-ui/1.12.1/jquery-ui.css" rel="stylesheet">
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="icon" type="image/x-icon" href="<c:url value="/static/img/favicon1.png"/>" />

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->

    <!-- Sidebar - Brand -->
    <%@include file="../menu/sidebar.jsp" %>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <!-- Topbar -->
            <%@include file="../menu/header.jsp"%>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Edit Product</h6>
                    </div>
                    <div class="card-body">
                        <form:form role="form" action="${pageContext.request.contextPath}/products/${productForm.id}"  modelAttribute="productForm"  method="post" enctype="multipart/form-data">
                            <form:hidden path="id" value="${productForm.id}" />
                            <div class="form-group">
                                <label for="name" class="col-sm-2 col-sm-2 control-label" >Product Name:</label>
                                <div class="col-sm-8">
                                    <form:input path="name" required="required" size="50" class="form-control" value="${productForm.name}"  readonly="readonly" placeholder="Enter Product Name" />
                                    <!--  <span id="errlastname" class="alert alert-danger col-lg-8 col-md-8 col-sm-8 col-xs-12">Filed Required.</span>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="sku" class="col-sm-2 col-sm-2 control-label" > SKU: </label>
                                <div class="col-sm-8">
                                    <form:input path="sku" required="required" size="50" class="form-control" value="${productForm.sku}" readonly="readonly" placeholder="Enter Product SKU" />
                                    <!--  <span id="errlastname" class="alert alert-danger col-lg-8 col-md-8 col-sm-8 col-xs-12">Filed Required.</span>-->
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="price" class="col-sm-2 col-sm-2 control-label" > Price: </label>
                                <div class="col-sm-8">
                                    <form:input path="price" required="required" size="50" class="form-control" value="${productForm.price}"  placeholder="Enter Product price" />
                                    <!--  <span id="errlastname" class="alert alert-danger col-lg-8 col-md-8 col-sm-8 col-xs-12">Filed Required.</span>-->
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="description" class="col-sm-2 col-sm-2 control-label">Product Description:</label>
                                <div class="col-sm-8">
                                    <form:textarea path="description" required="required" class="form-control" value="${productForm.description}"  placeholder="Enter Category Description" cols="30" rows="3"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <label for="image" class="col-sm-2 col-sm-2 control-label">Image:</label>
                                <div class="col-sm-8">
                                    <form:input type="file"  size="50" path="image" class="form-control" />
                                    <p class="help-block">Select JPG Image</p>
                                    <p>
                                    <img  src="${pageContext.request.contextPath}/product/images/${productForm.id}" alt="Design" style="width: 90px; height: 90px;">
                                    </p>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="description" class="col-sm-2 col-sm-2 control-label"> Category ID:</label>
                                <div class="col-sm-8">
                                    <form:select id="categoryId" name="categoryId" class="form-control"  required="required" path="categoryId">
                                        <c:forEach items="${categoryList}" var="category">
                                            <form:option value="${category.id}"> ${category.name}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-outline-primary ">update</button>

                        </form:form>

                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <%@include file="../menu/footer.jsp"%>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>
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
