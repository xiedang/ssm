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
    <link type="text/css" rel="stylesheet" href="${cp}/css/bootstrap-theme.min.css">
    <link type="text/css" rel="stylesheet" href="${cp}/css/welcome.css">

    <style type="text/css">

    </style>
</head>
<body>
<div class="logo">
    <p class="logo-title">xxx系统</p>
    <p class="time" id="time"></p>
    <p class="user" id="user">当前用户：${sessionScope.user.username}</p>
    <div class="dropdown">
        <div class="dropdown-content">
            <p>个人中心</p>
            <p>更改密码</p>
            <p>退出系统</p>
        </div>
    </div>
</div>
<div class="div-body">
    <div class="navigation">
        <ul class="nav-ul">
            <li class="nav-li"><a href="#">系统用户</a>
                <ul>
                    <li><a href="#">二级菜单1</a></li>
                    <li><a href="#">二级菜单2</a></li>
                    <li><a href="#">二级菜单3</a></li>
                    <li><a href="#">二级菜单4</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="body_right" style="float: left;">
        <div class="inputFormation">
            <form class="form-inline" role="form">
                <div class="form-group">
                    <label for="inputName">姓名:</label>
                    <input type="email" class="form-control" id="inputName">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <!-- 为了让控件在各种表单风格中样式不出错需要加上form-control类 -->
                </div>
                <div class="form-group">
                    <label class="control-label" for="inputDate">出生日期:</label>
                    <input type="date" class="form-control" id="inputDate">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>
                <div class="form-group">
                    <label class="control-label" for="inputJiGuan">籍贯:</label>
                    <input type="text" class="form-control" id="inputJiGuan">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>
                <div class="form-group">
                    <label class="control-label" for="inputPhone">电话:</label>
                    <input type="text" class="form-control" id="inputPhone">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>
                <div class="form-group">
                    <label for="inputSex" class="control-label">性别:</label>
                    <select id="inputSex" class="form-control">
                        <option value="ALL">ALL</option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>
            </form>
        </div>
        <div class="buttons">
            <ul class="list-inline">
                <li><span class="btn btn-success" onclick="addFunction()"><span
                        class="glyphicon glyphicon-plus">新增</span></span></li>
                <li><span class="btn btn-info"><span
                        class="glyphicon glyphicon-pencil">修改</span></span></li>
                <li><span class="btn btn-success" id="del"><span
                        class="glyphicon glyphicon-remove">删除</span></span></li>
                <li><span class="btn btn-success" id="chaXun"><span
                        class="glyphicon glyphicon-zoom-in">查询</span></span></li>
                <li><span class="btn btn-success" id="excel"><span
                        class="glyphicon glyphicon-zoom-in" onclick="downloadExcelFunction()">下载excel</span></span> </li>
            </ul>
        </div>
        <div class="table table-responsive" style="padding-top:10px;">
            <table class="table table-bordered table-hover" style="border-top: 1px dashed gray;border-left: 1px dashed gray;text-align: center" id="table">
                <thead>
                    <tr>
                        <td>用户Id</td>
                        <td>用户名</td>
                        <td>密码</td>
                        <td>姓名</td>
                        <td>电话</td>
                        <td>住址</td>
                        <td>出生日期</td>
                        <td>籍贯</td>
                        <td>性别</td>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
</div>


<script type="text/javascript" src="${cp}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${cp}/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $.post('${cp}/user/selectAll',{},function (data) {
           $.each(data,function (i,v) {
               var html="<tr><td>"+v.id+"</td><td>"+v.username+"</td><td>"+v.password+"</td><td>"+v.username+"</td><td>"+v.userInfo.name+"</td>"
                   +v.userInfo.phone+"</td><td>"+v.userInfo.address+"</td><td>"+v.userInfo.birthDate+"</td><td>"+v.userInfo.nativePlace+
                   "</td><td>"+v.userInfo.sex+"</td></tr>";
               $("#table").append(html);
           })
        },"json")
    })
</script>
<script>
    /**
     * 当前时间
     * */
    setInterval(getNowTime, 100); //每100毫秒調用一次函數
    function getNowTime() {
        var t = document.getElementById('time');
        var time = new Date();
        var sign1 = "-";
        var sign2 = ":";
        var year = time.getFullYear();
        var month = time.getMonth() + 1;
        var day = time.getDate();
        var hour = time.getHours();
        var minutes = time.getMinutes();
        var seconds = time.getSeconds();
        var weeks = ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"];
        var week = weeks[time.getDay() - 1];
        // 给一位数数据前面加 “0”
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (day >= 0 && day <= 9) {
            day = "0" + day;
        }
        if (hour >= 0 && hour <= 9) {
            hour = "0" + hour;
        }
        if (minutes >= 0 && minutes <= 9) {
            minutes = "0" + minutes;
        }
        if (seconds >= 0 && seconds <= 9) {
            seconds = "0" + seconds;
        }
        var currentTime = year + sign1 + month + sign1 + day + " " + hour + sign2 + minutes + sign2 + seconds + " " + week;
        t.innerHTML = currentTime;
    }

    /**
     * 菜单
     * */
    $(document).ready(function () {
        $(".nav-li a").click(function () {
            //找到main 下面的a  的下面的ui
            var secondNode = $(this).next("ul");
            //判断该ui事件的css 属性
            if (secondNode.css("display") === "none") {
                secondNode.css("display", "block");
            } else {
                secondNode.css("display", "none");
            }
        });
        //找到二级菜单，并设置单击事件
        $(".nav-li li a").click(function () {
            alert("该菜单没有下一步动作");
        })
    })
    
    function addFunction() {
        $("#table").append()
    }

    function downloadExcelFunction() {
        window.open("${cp}/user/exportExcel");
    }
</script>

</body>
</html>
