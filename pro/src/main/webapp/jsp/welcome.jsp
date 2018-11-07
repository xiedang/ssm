<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 2018/11/5
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <title>首页</title>

    <link type="text/css" rel="stylesheet" href="${cp}/css/bootstrap.min.css">

    <style type="text/css">
        body{
            margin: 0;
        }
        .logo{
            float: left;
            width: 100%;
            height: 20%;
            overflow: hidden;
        }
        .logo-img{
            width: 100%;
            height: 0;
            padding-top: 20%;
            overflow: hidden;
            background: url(${cp}/img/logo.jpg) no-repeat;
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
        }
    </style>
</head>
<body>
    <div class="logo">
        <div class="logo-img">
            <p class="logo-title">xxx系统</p>
        </div>
    </div>
</body>
</html>
