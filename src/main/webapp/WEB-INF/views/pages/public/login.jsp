<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lisa
  Date: 12/19/2020
  Time: 10:27 AM
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
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/static/assets/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="/webjars/jquery-ui/1.12.1/jquery-ui.css" rel="stylesheet">
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
   <link href="/static/assets/css/styles.css">
    <link rel="icon" type="image/x-icon" href="<c:url value="/static/img/favicon1.png"/>" />

</head>
<body class="bg-gradient-success">
<!-- Page Wrapper -->
    <div id="layoutAuthentication">
        <div id="layoutAuthentication_content">
            <main>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-5">
                            <div class="card shadow-lg border-0 rounded-lg mt-5">
                                <div class="card-header"><h3 class="text-center font-weight-light my-4">Admin login</h3></div>
                                <div class="card-body">
                                    <form:form action="/public/login"  method="post">
                                        <div class="form-group">
                                            <input type="email" name="username" class="form-control form-control-user" placeholder="Enter Email Address...">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="password" class="form-control form-control-user" placeholder="Password">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Remember Me</label>
                                            </div>
                                        </div>
                                        <button class="btn btn-primary" >Login</button>
                                    </form:form>
                                </div>
                                <div class="card-footer text-center">
                                    <div class="small"><a href="${pageContext.request.contextPath}/register">Need an account? Sign up!</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
        <%--<!-- Footer -->--%>
        <%--<div id="layoutAuthentication_footer">--%>
            <%--<footer class="py-4 bg-light mt-auto">--%>
                <%--<div class="container-fluid">--%>
                    <%--<div class="d-flex align-items-center justify-content-between small">--%>
                        <%--<div class="text-muted">Copyright &copy; Your Website 2020</div>--%>
                        <%--<div>--%>
                            <%--<a href="#">Privacy Policy</a>--%>
                            <%--&middot;--%>
                            <%--<a href="#">Terms &amp; Conditions</a>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</footer>--%>
        <%--</div>--%>
    </div>
</body>
</html>