<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/3 0003
  Time: 上午 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>登录</title>

<link type="text/css" rel="stylesheet" href="${cp}/css/bootstrap.min.css">

<style type="text/css">
    body{
        margin: 0;
    }
    .login-container{
        float: left;
        width: 100%;
        height: 100%;
        overflow: hidden;
    }
    .login-img{
        width: 100%;
        height: 5%;
        padding-top: 50%;
        overflow: hidden;
        background: url(${cp}/img/login_bg.jpg) no-repeat;
        background-size: cover;
        -webkit-background-size: cover;
        -moz-background-size: cover;
    }
    .login-body{
        width: 23%;
        height: 40%;
        position: absolute;
        top: 30%;
        right: 30%;
    }
    .login-body .form-control{
        display: block;
        margin-top: 15px;
    }
    .login-body .btn{
        margin-top: 15px;
    }
    .login-body form{
        background: rgba(255, 255, 255, 0.2);
        border: 1px solid rgba(255,255,255,.3);
        -moz-box-shadow: 0 3px 0 rgba(12, 12, 12, 0.03);
        -webkit-box-shadow: 0 3px 0 rgba(12, 12, 12, 0.03);
        box-shadow: 0 3px 0 rgba(12, 12, 12, 0.03);
        -moz-border-radius: 3px;
        -webkit-border-radius: 3px;
        border-radius: 3px;
        padding: 30px;
    }
</style>

</head>
<body>
<div class="login-container">
    <div class="login-img">
        <div class="login-body">
            <div class="col-sm-12">
                <form id="formSubmit" name="formSubmit" method="post" action="${cp}/user/login">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md">欢迎登陆xxx系统</p>

                    <div class="form-group">
                        <input type="text" name="username" class="form-control" id="user_name" placeholder="用户名">
                    </div>
                    <p style="color: red">${requestScope.msg3}</p>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" id="user_password" placeholder="密码">
                    </div>
                    <p style="color: red">${requestScope.msg2}</p>

                    <button type="submit" class="btn btn-primary" id="btnSubmit">登录</button>
                </form>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="${cp}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${cp}/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function () {
        $("input").click(function () {
            $(this).css("background","lightcyan")
        })
        $("input").blur(function () {
            $(this).css("background","white")
        })

    })
</script>

</body>
</html>
