<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zyk
  Date: 2018/12/20
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <title>Title</title>

    <link type="text/css" rel="stylesheet" href="${cp}/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${cp}/css/bootstrap-theme.min.css">
    <link type="text/css" rel="stylesheet" href="${cp}/js/My97DatePicker/skin/WdatePicker.css">
    <script type="text/javascript" src="${cp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${cp}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${cp}/js/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
<div id="myManu">
    <div id="condition_body" style="height: 100px;padding: 10px;">
        <form class="form-inline" role="form" id="userQueryForm" name="userQueryForm" style="margin-top: 20px;">
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
    </div>

    <%--按钮--%>
    <div class="container" style="width: auto;">
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
    </div>

    <%--表格--%>
    <div class="row">
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
    </div>
    <%--分页--%>
    <footer>
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
                <input type="number" id="number" value="1" disabled style="width: 50px;">
            </li>
            <li id="nextPage" class="btn btn-sm">
                <i class="glyphicon glyphicon-chevron-right"></i>
            </li>
        </ul>
    </footer>
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
                                   placeholder="请输入出生日期">
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
                doQuery(10,1);
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
            doQuery(10,1);
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
            doQuery(10,1);
        }, "json")
    });

    function downloadExcelFunction() {
        window.open("${cp}/user/exportExcel");
    }

    /*清空*/
    function clearFunction() {
        $("input").val("");
        $("input[type='number']").val("1");
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

</body>
</html>
