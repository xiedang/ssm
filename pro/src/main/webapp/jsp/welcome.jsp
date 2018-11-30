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
    <div class="body_right" style="float: right;width: 90.3%">
        <div class="inputFormation">
            <form class="form-inline" role="form" id="userQueryForm" name="userQueryForm">
                <div class="form-group">
                    <label for="name">姓名:</label>
                    <input type="text" class="form-control" id="name" name="name">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <!-- 为了让控件在各种表单风格中样式不出错需要加上form-control类 -->
                </div>
                <div class="form-group">
                    <label for="username">账号:</label>
                    <input type="text" class="form-control" id="username" name="username">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <!-- 为了让控件在各种表单风格中样式不出错需要加上form-control类 -->
                </div>
                <%--<div class="form-group">
                    <label class="control-label" for="inputDate">出生日期:</label>
                    <input type="date" class="form-control" id="inputDate" name="birthDate">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>--%>
                <div class="form-group">
                    <label class="control-label" for="nativePlace">籍贯:</label>
                    <input type="text" class="form-control" id="nativePlace" name="nativePlace">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>
                <div class="form-group">
                    <label class="control-label" for="phone">电话:</label>
                    <input type="text" class="form-control" id="phone" name="phone">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>
                <div class="form-group">
                    <label for="sex" class="control-label">性别:</label>
                    <select id="sex" class="form-control" name="sex">
                        <option value="">ALL</option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                        <%--<c:forEach items="${sexItems}" var="item">
                            <option value="${item.id}" <c:if test="${item.id == sexCode}">selected</c:if></option
                        </c:forEach>--%>
                    </select>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>
            </form>
        </div>
        <div class="buttons">
            <ul class="list-inline" style="width: 80%">
                <li><span class="btn btn-primary" id="queryUser"><span
                        class="glyphicon glyphicon-search">查询</span></span></li>
                <li><span class="btn btn-success" id="userAddBtn"><span
                        class="glyphicon glyphicon-plus">新增</span></span></li>
                <li><span class="btn btn-default" id="userUpdateBtn"><span
                        class="glyphicon glyphicon-pencil">修改</span></span></li>
                <li><span class="btn btn-danger" id="userDelBtn"><span
                        class="glyphicon glyphicon-remove">删除</span></span></li>
                <li><span class="btn btn-info" id="excel"><span
                        class="glyphicon glyphicon-arrow-down" onclick="downloadExcelFunction()">下载excel</span></span>
                </li>
                <li><span class="btn btn-default" id="clear" onclick="clearFunction()"><span
                        class="glyphicon glyphicon-trash">清空</span></span></li>
            </ul>
        </div>
        <div class="table table-responsive" style="padding-top:10px;">
            <table class="table table-bordered table-hover"
                   style="border-top: 1px dashed gray;border-left: 1px dashed gray;text-align: center" id="table">
                <thead>
                <tr>
                    <td>选择</td>
                    <td>用户Id</td>
                    <td>账号</td>
                    <td>密码</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>籍贯</td>
                    <td>出生日期</td>
                    <td>电话</td>
                    <td>住址</td>
                </tr>
                </thead>
                <tbody id="tableBody" style="width: auto">
                </tbody>
            </table>
        </div>
        <%--<c:forEach items="${users}" var="u">
            <tr>
                <td><input type="checkbox" value="${u.id}"></td>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.password}</td>
                <td>${u.userInfo.name}</td>
                <td>${u.userInfo.sex}</td>
                <td>${u.userInfo.nativePlace}</td>
                <td>${u.userInfo.birthDate}</td>
                <td>${u.userInfo.phone}</td>
                <td>${u.userInfo.address}</td>
            </tr>
        </c:forEach>--%>
    </div>

    <!--新增模态框-->
    <div class="modal fade" id="userAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document" style="width: 35%">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h5 class="modal-title" id="myModalLabel">新增</h5>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="userAddModalForm">
                        <%--<div class="form-group">
                            <label class="col-sm-2 control-label">id</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="userId">
                            </div>
                        </div>--%>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">账号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="username" placeholder="请输入账号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">密码</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" name="password" placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">姓名</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="name" placeholder="请输入姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别</label>
                            <div class="col-sm-3">
                                <select id="modelSex" class="form-control" name="sex">
                                    <option value="男" selected>男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">籍贯</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="nativePlace" placeholder="请输入籍贯">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">出生日期</label>
                            <div class="col-sm-7">
                                <input type="date" class="form-control" name="birthDate" placeholder="请输入姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">电话</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="phone" placeholder="请输入电话">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">住址</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="address" placeholder="请输入住址">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">状态</label>
                            <div class="col-sm-3">
                                <select id="modelStatus" class="form-control" name="modelStatus">
                                    <option value="0" selected>0</option>
                                    <option value="1">1</option>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary btn-sm" id="userAddModalSaveBtn">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="${cp}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${cp}/js/bootstrap.min.js"></script>
<script>
    /*页面加载，发起ajax请求得到数据*/
    $(function () {

        // 页面加载完成之后，直接发送ajax请求，要到数据
        doQuery();

        // 将按钮绑定事件
        bindEvent();
    });

    //页面加载获取全部数据
    function doQuery() {
        $.post('${cp}/user/selectAll', {}, function (data) {
            $.each(data, function (i, v) {
                var html = "<tr><td>" + "<input type='checkbox' value='v.id'>" + "</td><td>" + v.id + "</td><td>" + v.username + "</td><td>" + v.password +
                    "</td><td>" + v.userInfo.name + "</td><td>" + v.userInfo.sex +
                    "</td><td>" + v.userInfo.nativePlace + "</td><td>" + v.userInfo.birthDate + "</td><td>" + v.userInfo.phone +
                    "</td><td>" + v.userInfo.address + "</td></tr>";
                $("#table").append(html);
            })
        }, "json");
    }

    //将按钮绑定事件
    function bindEvent() {
        //将新增按钮绑定click事件
        $("#userAddBtn").click(function () {
            $("#userAddModal").modal({
                // 点击背景模态框不关闭
                backdrop: "static"
            })
        });

        //将删除按钮绑定click事件
        $("#userDelBtn").click(function () {
            $("#userAddModal").modal({})
        });

        //将保存按钮绑定click事件
        $("#userAddModalSaveBtn").click(function () {
            //获取页面输入的数据
            var formData = $("#userAddModalForm").serialize();
            //alert(formData);
            $.post('${cp}/user/addUser', formData, function (data) {
                //保存成功关闭模态框
                $("#userAddModal").modal("hide");
                alert("操作成功");

                //清空数据
                $("#tableBody").empty();

                //刷新页面，显示新增的数据
                doQuery();
            }, "json")
        });
    }

    /*查询*/
    $("#queryUser").click(function () {

        //清空数据
        $("#tableBody").empty();

        $.post('${cp}/user/queryUser', $("#userQueryForm").serialize(), function (data) {
            $.each(data, function (i, v) {
                var html = "<tr><td>" + "<input type='checkbox' value='v.id'>" + "</td><td>" + v.id +
                    "</td><td>" + v.username + "</td><td>" + v.password + "</td><td>" + v.userInfo.name +
                    "</td><td>" + v.userInfo.sex + "</td><td>" + v.userInfo.nativePlace +
                    "</td><td>" + v.userInfo.birthDate + "</td><td>" + v.userInfo.phone +
                    "</td><td>" + v.userInfo.address + "</td></tr>";
                $("#table").append(html);
            })
        }, "json")
    });

    /*清空*/
    function clearFunction() {
        $("input").val("");
        $("#sex option:first").prop("selected", 'selected');
    }
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
    });


    function downloadExcelFunction() {
        window.open("${cp}/user/exportExcel");
    }


</script>

</body>
</html>
