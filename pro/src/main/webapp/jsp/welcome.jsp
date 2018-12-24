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
    <%--<link type="text/css" rel="stylesheet" href="${cp}/css/layui.css">--%>
    <link type="text/css" rel="stylesheet" href="${cp}/css/bootstrap-theme.min.css">
    <link type="text/css" rel="stylesheet" href="${cp}/css/bootstrap-table.css">
    <link type="text/css" rel="stylesheet" href="${cp}/js/My97DatePicker/skin/WdatePicker.css">

    <style type="text/css">
        body {
            padding: 0;
            margin: 0;
        }

        .logo {
            float: left;
            width: 100%;
            height: 15%;
            color: #ffffff;
            position: relative;
            overflow: hidden;
            /*background: url(
            ${cp}/img/logo.jpg) no-repeat;*/
            background-color: rgb(16, 40, 71);
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
        }

        .logo-title {
            font-size: 30px;
            margin-left: 50px;
            margin-top: 30px;
        }

        .time {
            position: absolute;
            bottom: 2px;
            right: 300px;
        }

        .user {
            position: absolute;
            bottom: 2px;
            right: 150px;
        }

        /*控制菜单箭头*/
        .nav-header.collapsed > span.glyphicon-chevron-toggle:before {
            content: "\e114";
        }

        .nav-header > span.glyphicon-chevron-toggle:before {
            content: "\e113";
        }

        /*选中样式*/
        .secondmenu a {
            font-size: 12px;
            color: #4A515B;
            text-align: center;
        }

        .secondmenu li.active {
            background-color: #eee;
            border-color: #428bca;
        }
        #myWindow{
            height: 80%;
            overflow: hidden;
            background-image: url(${cp}/img/login_bg.jpg) no-repeat;
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
        }
    </style>
</head>
<body>
<div class="logo">
    <p class="logo-title">xxx系统</p>
    <p class="time" id="time"></p>
    <p class="user" id="user">当前用户：${sessionScope.user.username}</p>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <ul id="main-nav" class="main-nav nav nav-tabs nav-stacked" style>
                <li class="active">
                    <a href="#"><i class="glyphicon glyphicon-th-large"></i>
                        首页
                    </a>
                </li>
                <li>
                    <a href="#problem" class="nav-header" data-toggle="collapse">
                        <i class="glyphicon glyphicon-apple"></i>
                        问题管理
                        <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
                    </a>
                    <ul id="problem" class="nav nav-list secondmenu collapse" style="height:0">
                        <li id="definition"><a href="#"><i class="glyphicon glyphicon-pencil"></i>"&nbsp;问题定义"</a></li>
                        <li id="measure"><a href="#"><i class="glyphicon glyphicon-pushpin"></i>"&nbsp;措施拟定"</a></li>
                        <li id="approve"><a href="#"><i class="glyphicon glyphicon-thumbs-up"></i>"&nbsp;措施审批"</a></li>
                        <li id="close"><a href="#"><i class="glyphicon glyphicon-unchecked"></i>"&nbsp;问题关闭"</a></li>
                        <li id="report"><a href="#"><i class="glyphicon glyphicon-th"></i>"&nbsp;图形报表"</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#systemSetting" class="nav-header" data-toggle="collapse">
                        <i class="glyphicon glyphicon-cog"></i>
                        系统管理
                        <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
                    </a>
                    <ul id="systemSetting" class="nav nav-list secondmenu collapse" style="height:0">
                        <li id="user-manage"><a href="#"><i class="glyphicon glyphicon-user"></i>"&nbsp;用户管理"</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-th-list"></i>"&nbsp;菜单管理"</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>"&nbsp;角色管理"</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-edit"></i>"&nbsp;修改密码"</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>"&nbsp;日志查看"</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-globe"></i>
                        分发配置
                        <span class="label label-warning pull-right">5</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-calendar"></i>
                        图标统计
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-fire"></i>
                        关于系统
                    </a>
                </li>
            </ul>
        </div>

        <div class="col-md-10" id="myWindow">
            <%--<div id="condition_body" style="height: 100px;padding: 10px;">
                <form class="form-inline" role="form" id="userQueryForm" name="userQueryForm">
                    <div class="form-group">
                        <label for="name">姓名:</label>
                        <input type="text" class="form-control" id="name" name="name">
                        <!-- 为了让控件在各种表单风格中样式不出错需要加上form-control类 -->

                    </div>
                    <div class="form-group">
                        <label for="username">账号:</label>
                        <input type="text" class="form-control" id="username" name="username">
                        <!-- 为了让控件在各种表单风格中样式不出错需要加上form-control类 -->

                    </div>
                    <div class="form-group">
                        <label class="control-label" for="inputDate">出生日期:</label>
                        <input type="text" class="form-control" id="inputDate" name="birthDate"
                               onClick="WdatePicker()">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="nativePlace">籍贯:</label>
                        <input type="text" class="form-control" id="nativePlace" name="nativePlace">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="phone">电话:</label>
                        <input type="text" class="form-control" id="phone" name="phone">
                    </div>
                    <div class="form-group">
                        <label for="sex" class="control-label">性别:</label>
                        <select id="sex" class="form-control" name="sex">
                            <option value="">ALL</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </form>
            </div>--%>

            <%--按钮--%>
            <%--<div class="container" style="width: auto;">
                <div class="row">
                    <div class="col-sm-1 btn btn-primary" id="queryUser" style="width: 5%;"><span
                            class="glyphicon glyphicon-search">查询</span></div>
                    <div class="col-sm-1 btn btn-success" id="userAddBtn" style="width: 5%;margin-left: 10px;"><span
                            class="glyphicon glyphicon-plus">新增</span></div>
                    <div class="col-sm-1 btn btn-default" id="userUpdateBtn" style="width: 5%;margin-left: 10px;"><span
                            class="glyphicon glyphicon-pencil">修改</span></div>
                    <div class="col-sm-1 btn btn-default" id="userImportBtn" style="width: 5%;margin-left: 10px;"><span
                            class="glyphicon glyphicon-import">导入</span></div>
                    <div class="col-sm-1 btn btn-danger" id="userDelBtn" style="width: 5%;margin-left: 10px;"><span
                            class="glyphicon glyphicon-remove">删除</span></div>
                    <div class="col-sm-2 btn btn-info" id="excel" style="width: 8%;margin-left: 10px;"><span
                            class="glyphicon glyphicon-arrow-down" onclick="downloadExcelFunction()">下载excel</span>
                    </div>
                    <div class="col-sm-1 btn btn-default" id="clear" style="width: 5%;margin-left: 10px;"><span
                            class="glyphicon glyphicon-trash" onclick="clearFunction()">清空</span></div>
                </div>
            </div>--%>

            <%--表格--%>
            <%--<div class="row">
                <div class="table table-responsive" style="padding-top:10px;">
                    <table class="table table-bordered table-hover" id="table" style="text-align: center;">
                        <thead>
                        <tr>
                            <td><input type="checkbox" id="checkBoxAll"></td>
                            <td style="display: none">用户Id</td>
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
                        <tbody id="tableBody">
                        </tbody>
                    </table>
                </div>
            </div>--%>
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


            <%--分页--%>
            <%--<footer style="position: absolute;bottom: 10px;left: 18%;">
                <ul class="pagination pagination-sm">
                    <li>
                        <select id="pageSize" name="pageSize" onchange="getPageSize()">
                            <option value=10>10</option>
                            <option class="active" value=20>20</option>
                            <option value=50>50</option>
                            <option value=100>100</option>
                        </select>
                    </li>
                    <li id="previousPage" class="btn btn-sm">
                        <i class="glyphicon glyphicon-chevron-left"></i>
                    </li>
                    <li>
                        <input type="text" id="number" value="1" style="width: 50px;">
                    </li>
                    <li id="nextPage" class="btn btn-sm">
                        <i class="glyphicon glyphicon-chevron-right"></i>
                    </li>
                </ul>
            </footer>
        </div>--%>
    </div>
</div>
<%--<div class="layui-tab layui-tab-card site-demo-button" style="position: relative;">
    <ul class="layui-nav layui-nav-tree layui-nav-side">
        <li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">默认展开</a>
            <dl class="layui-nav-child">
                <dd>
                    <a data-url="a" data-id="11" data-title="选项a" href="#" class="site-demo-active" data-type="tabAdd">选项a</a>
                </dd>
                <dd>
                    <a href="#" data-url="b" data-title="选项b"  data-id="22" class="site-demo-active" data-type="tabAdd">选项b</a>
                </dd>
                <dd>
                    <a href="">跳转</a>
                </dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;">解决方案</a>
            <dl class="layui-nav-child">
                <dd>
                    <a href="">移动模块</a>
                </dd>
                <dd>
                    <a href="">后台模版</a>
                </dd>
                <dd>
                    <a href="">电商平台</a>
                </dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="#" data-url="c" data-title="选项c"  data-id="33" class="site-demo-active" data-type="tabAdd">产品c</a>
        </li>
        <li class="layui-nav-item">
            <a href="">大数据</a>
        </li>
    </ul>

    <div class="layui-tab" lay-filter="demo" lay-allowclose="true" style="margin-left: 200px;">
        <ul class="layui-tab-title">
        </ul>
        <ul class="rightmenu" style="display: none;position: absolute;">
            <li data-type="closethis">关闭当前</li>
            <li data-type="closeall">关闭所有</li>
        </ul>
        <div class="layui-tab-content">
        </div>
    </div>

</div>--%>

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
                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="modeUserId" name="id" style="display: none">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">账号</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUsername" name="username"
                                   placeholder="请输入账号">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">密码</label>
                        <div class="col-sm-7">
                            <input type="password" class="form-control" id="modePassword" name="password"
                                   placeholder="请输入密码" required>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">姓名</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeName" name="name" placeholder="请输入姓名">
                            <span class="help-block"></span>
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
                            <input type="text" class="form-control" id="modeNativePlace" name="nativePlace"
                                   placeholder="请输入籍贯">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">出生日期</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeBirthDate" name="birthDate"
                                   onclick="WdatePicker()"
                                   placeholder="请输入姓名">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">电话</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modePhone" name="phone" placeholder="请输入电话">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">住址</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeAddress" name="address"
                                   placeholder="请输入住址">
                            <span class="help-block"></span>
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

<!--修改模态框-->
<div class="modal fade" id="userUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: 35%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h5 class="modal-title" id="myUpdateModalLabel">修改</h5>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="userUpdateModalForm">
                    <div class="form-group">
                        <label class="col-sm-3 control-label"></label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="modeUpdateUserId" name="id"
                                   style="display: none">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">账号</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUpdateUsername" name="username"
                                   placeholder="请输入账号">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">密码</label>
                        <div class="col-sm-7">
                            <input type="password" class="form-control" id="modeUpdatePassword" name="password"
                                   placeholder="请输入密码">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">姓名</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUpdateName" name="name"
                                   placeholder="请输入姓名">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">性别</label>
                        <div class="col-sm-3">
                            <select id="modelUpdateSex" class="form-control" name="sex">
                                <option value="男" selected>男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">籍贯</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUpdateNativePlace" name="nativePlace"
                                   placeholder="请输入籍贯">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">出生日期</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUpdateBirthDate" name="birthDate"
                                   onclick="WdatePicker()"
                                   placeholder="请输入姓名">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">电话</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUpdatePhone" name="phone"
                                   placeholder="请输入电话">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">住址</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUpdateAddress" name="address"
                                   placeholder="请输入住址">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">状态</label>
                        <div class="col-sm-3">
                            <select id="modelUpdateStatus" class="form-control" name="status">
                                <option value="0" selected>0</option>
                                <option value="1">1</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary btn-sm" id="userUpdateModalSaveBtn">保存</button>
            </div>
        </div>
    </div>
</div>

<%--上传附件模态框--%>
<div class="modal fade" id="upFileModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: 35%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title" id="myUpFileModalLabel">excel导入</h5>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="upFileModalForm" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">选择文件:</label>
                        <div class="col-sm-8">
                            <input type="file" class="form-control" id="modeUpFile" name="modeUpFile">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-default btn-sm" id="upFileModalSaveBtn">上传</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${cp}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${cp}/js/bootstrap.min.js"></script>
<%--<script type="text/javascript" src="${cp}/js/layui.all.js"></script>--%>
<script type="text/javascript" src="${cp}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${cp}/js/bootstrap-table.js"></script>

<script>
    $(function () {

        // 页面加载完成之后，直接发送ajax请求，要到数据
        doQuery(10,1);

    });

    /*post请求获取分页数据*/
    function doQuery(pageSize,currentPage) {
        $.post("${cp}/user/queryUserByPage",{"pageSize":pageSize,"currentPage":currentPage},function (data) {
            //清空数据
            $("#tableBody").empty();
            $.each(data, function (i, v) {
                var html = "<tr><td>" + "<input type='checkbox' class='check-item' name='check-item'>" +
                    "</td><td style='display: none'>" + v.id + "</td><td>" + v.username +
                    "</td><td>" + v.password + "</td><td>" + v.userInfo.name +
                    "</td><td>" + v.userInfo.sex + "</td><td>" + v.userInfo.nativePlace +
                    "</td><td>" + v.userInfo.birthDate + "</td><td>" + v.userInfo.phone +
                    "</td><td>" + v.userInfo.address + "</td></tr>";
                $("#tableBody").append(html);
            })
        },"json");
    }

    //将新增按钮绑定click事件
    $("#userAddBtn").click(function () {
        $("#userAddModal").modal({
            // 点击背景模态框不关闭
            backdrop: "static"
        })
    });
    //将上传文件按钮绑定click事件
    $("#userImportBtn").click(function () {
       $("#upFileModal").modal({
           // 点击背景模态框不关闭
           backdrop: "static"
       })
    });

    //删除
    $("#userDelBtn").click(function () {

        //获取选中的数据行
        let value = "";
        $.each($(".check-item:checked"), function () {
            value += ($(this).parents("tr").find("td:eq(1)").text() + ",");
        });
        //删除多余的","
        value = value.substring(0, value.length - 1);
        //alert(value);

        //点击确定删除数据
        if (0 === value.length) {
            alert("请至少勾选一条数据");
        } else if (confirm("确定删除数据吗？")) {
            $.post('${cp}/user/doDeleteUser', {"str": value}, function (result) {

                //删除成功，关闭模态框
                $("#userDelModal").modal("hide");

                alert("操作成功");

                //重新请求全部数据，填充页面
                doQuery();
            }, "json")
        }
    });

    /*新增*/
    $("#userAddModalSaveBtn").click(function () {

        //获取页面输入的数据
        let formData = $("#userAddModalForm").serialize();
        //alert(formData);

        $.post('${cp}/user/addUser', formData, function (data) {

            //保存成功关闭模态框
            $("#userAddModal").modal("hide");

            //重新请求全部数据，填充页面
            doQuery();
        }, "json")
    });

    /*查询*/
    $("#queryUser").click(function () {
        let pageSize = $("#pageSize").val();
        let currentPage = $("#number").val();
        //清空数据
        $("#tableBody").html("");
        //alert($("#userQueryForm").serialize());
        $.post('${cp}/user/queryUser', $("#userQueryForm").serialize(), function (data) {
            $.each(data, function (i, v) {
                var html = "<tr><td>" + "<input type='checkbox' class='check-item' name='check-item'>" +
                    "</td><td style='display: none'>" + v.id + "</td><td>" + v.username +
                    "</td><td>" + v.password + "</td><td>" + v.userInfo.name +
                    "</td><td>" + v.userInfo.sex + "</td><td>" + v.userInfo.nativePlace +
                    "</td><td>" + v.userInfo.birthDate + "</td><td>" + v.userInfo.phone +
                    "</td><td>" + v.userInfo.address + "</td></tr>";
                $("#tableBody").append(html);
            })
        }, "json")
    });

    /*修改,弹出修改框*/
    $("#userUpdateBtn").click(function () {
        let id = "";
        $.each($(".check-item:checked"), function () {
            id = $(this).parents("tr").find("td:eq(1)").text();
        });
        //alert(id);
        if (id === "") {
            alert("请至少勾选一条数据！")
        } else {
            //弹出模态框
            $("#userUpdateModal").modal({
                // 点击背景模态框不关闭
                backdrop: "static"
            });
            $.post("${cp}/user/getUserById", {"id": id}, function (data) {
                $("input[id = 'modeUpdateUserId']").val(data.id);
                $("input[id = 'modeUpdateUsername']").val(data.username);
                $("input[id = 'modeUpdatePassword']").val(data.password);
                $("input[id = 'modeUpdateName']").val(data.userInfo.name);
                $("select[id = 'modelUpdateSex']").val(data.userInfo.sex);
                $("input[id = 'modeUpdateNativePlace']").val(data.userInfo.nativePlace);
                $("input[id = 'modeUpdateBirthDate']").val(data.userInfo.birthDate);
                $("input[id = 'modeUpdatePhone']").val(data.userInfo.phone);
                $("input[id = 'modeUpdateAddress']").val(data.userInfo.address);
                $("select[id = 'modelUpdateStatus']").val(data.status);
            }, "json");
        }
    });

    /*修改之后再发起请求*/
    $("#userUpdateModalSaveBtn").click(function () {
        //alert($("#userUpdateModalForm").serialize());
        $.post("${cp}/user/updateUser", $("#userUpdateModalForm").serialize(), function () {
            //修改成功关闭模态框
            $("#userUpdateModal").modal("hide");

            //重新请求全部数据，填充页面
            doQuery();
        }, "json")
    });

    /*清空*/
    function clearFunction() {
        $("input").val("");
        $("select option:first").prop("selected", 'selected');
    }

    /*全选*/
    $(document).ready(function () {
        $("#checkBoxAll").click(function () {
            //$("#fcheck").prop("checked",false);
            $("tbody input:checkbox").prop("checked", $(this).prop('checked'));
        });
        $("input[name='check-item']:checked").click(function () {
            if ($("input[name='check-item']:checkbox").length === $("input[name='check-item']:checked").length) {
                $("#checkBoxAll").prop("checked", true);
                //$("#checkBoxAll").get(0).checked = true;
            } else {
                $("#checkBoxAll").prop("checked", false);
            }
        });
    });


    /*分页点击事件*/
    /*change事件*/
    $("#pageSize").change(function () {
        let pageSize = $("#pageSize").val();
        let currentPage = $("#number").val();
        doQuery(pageSize,currentPage);
    });
    /*上一页*/
    $("#previousPage").click(function () {
        let pageSize = $("#pageSize").val();
        //获取当前页码
        let page = $("#number").val();
        if(page <=1){
            $("input[id='number']").val(1);
            doQuery(pageSize,1);
        }else {
            let currentPage = page*1 - 1;
            $("input[id='number']").val(currentPage);
            doQuery(pageSize,currentPage);
        }
    });
    /*下一页*/
    $("#nextPage").click(function () {
        let pageSize = $("#pageSize").val();
        //获取当前页码
        let page = $("#number").val();
        let last = $("input[name='check-item']:checkbox").length;
        if(last < pageSize){
            $("input[id='number']").val(page);
            doQuery(pageSize,page);
        }else {
            let currentPage = page*1 + 1;
            $("input[id='number']").val(currentPage);
            doQuery(pageSize,currentPage);
        }
    });
</script>

<script>
    /**
     * 当前时间
     * */
    setInterval(getNowTime, 100); //每100毫秒調用一次函數
    function getNowTime() {
        let t = document.getElementById('time');
        let time = new Date();
        let sign1 = "-";
        let sign2 = ":";
        let year = time.getFullYear();
        let month = time.getMonth() + 1;
        let day = time.getDate();
        let hour = time.getHours();
        let minutes = time.getMinutes();
        let seconds = time.getSeconds();
        let weeks = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
        let week = weeks[time.getDay()];
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
        let currentTime = year + "年" + month + "月" + day + "号" + " " + hour + sign2 + minutes + sign2 + seconds + " " + week;
        t.innerHTML = currentTime;
    }


    function downloadExcelFunction() {
        window.open("${cp}/user/exportExcel");
    }


</script>

<script type="text/javascript">
    $(document).ready(function () {
        $("#definition").click(function () {
            $("#myWindow").load("${cp}/jsp/problem.jsp");
        });
        $("#user-manage").click(function () {
            $("#myWindow").load("${cp}/jsp/user.jsp");
        });
    })
</script>

<%--<script>
    layui.use('element', function() {
        var $ = layui.jquery;
        var element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        //触发事件
        var active = {
            //在这里给active绑定几项事件，后面可通过active调用这些事件
            tabAdd: function(url,id,name) {
                //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
                //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
                element.tabAdd('demo', {
                    title: name,
                    content: '<iframe data-frameid="'+id+'" scrolling="auto" frameborder="0" src="'+url+'.html" style="width:100%;height:99%;"></iframe>',
                    id: id //规定好的id
                });
                CustomRightClick(id); //给tab绑定右击事件
                FrameWH();  //计算ifram层的大小
            },
            tabChange: function(id) {
                //切换到指定Tab项
                element.tabChange('demo', id); //根据传入的id传入到指定的tab项
            },
            tabDelete: function (id) {
                element.tabDelete("demo", id);//删除
            }
            , tabDeleteAll: function (ids) {//删除所有
                $.each(ids, function (i,item) {
                    element.tabDelete("demo", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
                })
            }
        };


        //当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
        $('.site-demo-active').on('click', function() {
            var dataid = $(this);

            //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
            if ($(".layui-tab-title li[lay-id]").length <= 0) {
                //如果比零小，则直接打开新的tab项
                active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
            } else {
                //否则判断该tab项是否以及存在

                var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
                $.each($(".layui-tab-title li[lay-id]"), function () {
                    //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
                    if ($(this).attr("lay-id") == dataid.attr("data-id")) {
                        isData = true;
                    }
                })
                if (isData == false) {
                    //标志为false 新增一个tab项
                    active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
                }
            }
            //最后不管是否新增tab，最后都转到要打开的选项页面上
            active.tabChange(dataid.attr("data-id"));
        });

        function CustomRightClick(id) {
            //取消右键  rightmenu属性开始是隐藏的 ，当右击的时候显示，左击的时候隐藏
            $('.layui-tab-title li').on('contextmenu', function () { return false; })
            $('.layui-tab-title,.layui-tab-title li').click(function () {
                $('.rightmenu').hide();
            });
            //桌面点击右击
            $('.layui-tab-title li').on('contextmenu', function (e) {
                var popupmenu = $(".rightmenu");
                popupmenu.find("li").attr("data-id",id); //在右键菜单中的标签绑定id属性

                //判断右侧菜单的位置
                l = ($(document).width() - e.clientX) < popupmenu.width() ? (e.clientX - popupmenu.width()) : e.clientX;
                t = ($(document).height() - e.clientY) < popupmenu.height() ? (e.clientY - popupmenu.height()) : e.clientY;
                popupmenu.css({ left: l, top: t }).show(); //进行绝对定位
                //alert("右键菜单")
                return false;
            });
        }

        $(".rightmenu li").click(function () {

            //右键菜单中的选项被点击之后，判断type的类型，决定关闭所有还是关闭当前。
            if ($(this).attr("data-type") == "closethis") {
                //如果关闭当前，即根据显示右键菜单时所绑定的id，执行tabDelete
                active.tabDelete($(this).attr("data-id"))
            } else if ($(this).attr("data-type") == "closeall") {
                var tabtitle = $(".layui-tab-title li");
                var ids = new Array();
                $.each(tabtitle, function (i) {
                    ids[i] = $(this).attr("lay-id");
                });
                //如果关闭所有 ，即将所有的lay-id放进数组，执行tabDeleteAll
                active.tabDeleteAll(ids);
            }

            $('.rightmenu').hide(); //最后再隐藏右键菜单
        });
        function FrameWH() {
            var h = $(window).height() -41- 10 - 60 -10-44 -10;
            $("iframe").css("height",h+"px");
        }

        $(window).resize(function () {
            FrameWH();
        })
    });
</script>--%>

</body>
</html>
