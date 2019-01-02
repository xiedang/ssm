<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zyk
  Date: 2018/12/20
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <title>问题提出</title>

    <link type="text/css" rel="stylesheet" href="${cp}/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${cp}/css/bootstrap-theme.min.css">
    <link type="text/css" rel="stylesheet" href="${cp}/css/bootstrap-table.css">
    <link type="text/css" rel="stylesheet" href="${cp}/css/fileinput.min.css">
    <script type="text/javascript" src="${cp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${cp}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${cp}/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="myManu">
    <div id="condition_body" style="height: 100px;padding: 10px;">
        <form class="form-inline" role="form" id="queryForm" name="queryForm" style="margin-top: 20px;">
            <div class="form-group">
                <label for="pNo">问题编号:</label>
                <input type="text" class="form-control" id="pNo" name="pNo">
                <!-- 为了让控件在各种表单风格中样式不出错需要加上form-control类 -->
            </div>
            <div class="form-group">
                <label for="pTitle">问题标题:</label>
                <input type="text" class="form-control" id="pTitle" name="pTitle">
                <!-- 为了让控件在各种表单风格中样式不出错需要加上form-control类 -->

            </div>
            <div class="form-group">
                <label for="pType" class="control-label">问题类型:</label>
                <select id="pType" class="form-control" name="pType">
                    <option value="">ALL</option>
                    <option value="市场问题">市场问题</option>
                    <option value="研发问题">研发问题</option>
                    <option value="制造问题">制造问题</option>
                    <option value="内部问题">内部问题</option>
                </select>
            </div>
            <div class="form-group">
                <label for="pStatus" class="control-label">问题状态:</label>
                <select id="pStatus" class="form-control" name="pStatus">
                    <option value="">ALL</option>
                    <option value="草稿">草稿</option>
                    <option value="已提交">已提交</option>
                    <option value="已审批">已审批</option>
                    <option value="已驳回">已驳回</option>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label" for="pFounder">创建人:</label>
                <input type="text" class="form-control" id="pFounder" name="pFounder">
            </div>
            <div class="form-group">
                <label class="control-label" for="pCreateTime">创建日期:</label>
                <input type="text" class="form-control" id="pCreateTime" name="pCreateTime"
                       onClick="WdatePicker()">
            </div>
        </form>
    </div>
    <%--按钮--%>
    <div class="container" style="width: auto;">
        <div class="row">
            <div class="col-sm-1 btn btn-primary" id="queryBtn" style="width: 5%;"><span
                    class="glyphicon glyphicon-search">查询</span></div>
            <div class="col-sm-1 btn btn-success" id="addBtn" style="width: 5%;margin-left: 10px;"><span
                    class="glyphicon glyphicon-plus">新增</span></div>
            <div class="col-sm-1 btn btn-default" id="updateBtn" style="width: 5%;margin-left: 10px;"><span
                    class="glyphicon glyphicon-pencil">修改</span></div>
            <div class="col-sm-1 btn btn-success" id="approveBtn" style="width: 5%;margin-left: 10px;"><span
                    class="glyphicon glyphicon-pencil">审批</span></div>
            <div class="col-sm-1 btn btn-danger" id="delBtn" style="width: 5%;margin-left: 10px;"><span
                    class="glyphicon glyphicon-remove">删除</span></div>
            <div class="col-sm-1 btn btn-default" id="importBtn" style="width: 8%;margin-left: 10px;"><span
                    class="glyphicon glyphicon-import">批量导入</span></div>
            <div class="col-sm-2 btn btn-info" id="downloadExcelBtn" style="width: 8%;margin-left: 10px;"><span
                    class="glyphicon glyphicon-arrow-down" onclick="downloadExcelFunction()">下载excel</span>
            </div>
            <div class="col-sm-1 btn btn-default" id="upFiletBtn" style="width: 8%;margin-left: 10px;"><span
                    class="glyphicon glyphicon-import">上传附加</span></div>
            <div class="col-sm-1 btn btn-default" id="clearBtn" style="width: 5%;margin-left: 10px;"><span
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
                    <td style="display: none">问题Id</td>
                    <td>问题编号</td>
                    <td>问题标题</td>
                    <td>问题状态</td>
                    <td>问题类型</td>
                    <td>驳回原因</td>
                    <td>创建人</td>
                    <td>创建日期</td>
                </tr>
                </thead>
                <tbody id="tableBody" class="table table-responsive table-hover">

                </tbody>
            </table>
        </div>
    </div>
    <%--分页--%>
    <footer>
        <ul class="pagination pagination-sm">
            <li>
                <select class="" id="pageSize" name="pageSize">
                    <option value=10>10</option>
                    <option value=20>20</option>
                    <option value=50>50</option>
                    <option value=100>100</option>
                </select>
            </li>
            <li id="previousPage" class="btn btn-sm">
                <i class="glyphicon glyphicon-chevron-left"></i>
            </li>
            <li>第</li>
            <li>
                <input class="" type="number" id="number" value="1" style="width: 50px;" disabled>
            </li>
            <li>页</li>
            <li id="nextPage" class="btn btn-sm">
                <i class="glyphicon glyphicon-chevron-right"></i>
            </li>
        </ul>
    </footer>
</div>

<!--新增模态框-->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: 60%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h5 class="modal-title" id="myModalLabel">新增</h5>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="addModalForm">
                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="modeId" name="id" style="display: none">
                        </div>
                    </div>
                    <div>
                        <div class="col-sm-4">
                            <div class="form-group" >
                                <label class="col-sm-4 control-label">问题编号：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="modePNo" name="pNo" disabled>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-sm-4 control-label">问题标题：</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="modeAddPTitle" name="pTitle" required>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-sm-4 control-label">问题类型：</label>
                                <div class="col-sm-5">
                                    <select id="modeAddType" class="form-control" name="pType">
                                        <option value="">请选择</option>
                                        <option value="市场问题">市场问题</option>
                                        <option value="研发问题">研发问题</option>
                                        <option value="制造问题">制造问题</option>
                                        <option value="内部问题">内部问题</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="table table-responsive">
                        <div class="btn btn-info btn-sm" id="addItem">添加</div>
                        <table class="table table-bordered" style="text-align: center;">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>问题描述</th>
                                <th>责任人</th>
                                <th>计划完成日期</th>
                                <th>附件</th>
                            </tr>
                            </thead>
                            <tbody id="itemTable">
                            <tr>
                                <td>1</td>
                                <td>
                                    <input type="text" class="form-control" id="itemDesc" name="itemDesc">
                                </td>
                                <td>
                                    <input type="text" class="form-control" id="itemResponsible" name="itemResponsible">
                                </td>
                                <td>
                                    <input type="text" class="form-control" id="itemPlanTime" name="itemPlanTime" onClick="WdatePicker()">
                                </td>
                                <td>
                                    <input type="file" class="form-control" id="itemFile" name="itemFile">
                                </td>
                                <td><span class="glyphicon glyphicon-remove"></span></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary btn-sm" id="addModalSaveBtn">提交</button>
            </div>
        </div>
    </div>
</div>

<!--修改模态框-->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: 35%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h5 class="modal-title" id="myUpdateModalLabel">修改</h5>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="updateModalForm">
                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="modeUpdateId" name="id" style="display: none">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">问题编号：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUpdatePNo" name="pNo" disabled>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">问题标题：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUpdatePTitle" name="pTitle" required>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">问题类型：</label>
                        <div class="col-sm-3">
                            <select id="modeUpdateType" class="form-control" name="pType">
                                <option value="市场问题">市场问题</option>
                                <option value="研发问题">研发问题</option>
                                <option value="制造问题">制造问题</option>
                                <option value="内部问题">内部问题</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">发生日期：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUpdatePFindTime" name="pFindTime" onclick="WdatePicker()">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">录入人：</label>
                        <div class="col-sm-3">
                            <input type="text" id="modeUpdatePPerson" class="form-control" name="pPerson"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">责任人：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUpdatePResponsible" name="pResponsible">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">计划完成日期：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUpdatePPlanTime" name="pPlanTime"
                                   onclick="WdatePicker()">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">问题描述：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUpdatePDescribe" name="pDescribe"/>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">备注：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeUpdatePRemark" name="pRemark">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary btn-sm" id="updateModalSaveBtn">提交</button>
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

<!--审批模态框-->
<div class="modal fade" id="approveModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: 35%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h5 class="modal-title" id="myApproveModalLabel">修改</h5>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="approveModalForm">
                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="modeApproveId" name="id" style="display: none">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">问题编号：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeApprovePNo" name="pNo" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">问题标题：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeApprovePTitle" name="pTitle" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">问题类型：</label>
                        <div class="col-sm-3">
                            <select id="modeApproveType" class="form-control" name="pType" disabled>
                                <option value="市场问题">市场问题</option>
                                <option value="研发问题">研发问题</option>
                                <option value="制造问题">制造问题</option>
                                <option value="内部问题">内部问题</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">发生日期：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeApprovePFindTime" name="pFindTime" onclick="WdatePicker()" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">录入人：</label>
                        <div class="col-sm-3">
                            <input type="text" id="modeApprovePPerson" class="form-control" name="pPerson" disabled/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">责任人：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeApprovePResponsible" name="pResponsible" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">计划完成日期：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeApprovePPlanTime" name="pPlanTime"
                                   onclick="WdatePicker()" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">问题描述：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeApprovePDescribe" name="pDescribe" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">备注：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeApprovePRemark" name="pRemark" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">审批结果：</label>
                        <div class="col-sm-3">
                            <select id="modeApproveResult" class="form-control" name="pStatus" onchange="isPass()">
                                <%--<option value="">请选择</option>--%>
                                <option value="1" >通过</option>
                                <option value="2">不通过</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group" id="approveReason" hidden>
                        <label class="col-sm-3 control-label">原因：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeApproveReason" name="pRemark" />
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary btn-sm" id="approveModalSaveBtn">提交</button>
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
        $.post("${cp}/problem/queryAllByPage",{"pageSize":pageSize,"currentPage":currentPage},function (data) {
            //清空数据
            $("#tableBody").empty();
            $.each(data, function (i, v) {
                let html = "<tr><td>" + "<input type='checkbox' class='check-item' name='check-item'>" +
                    "</td><td style='display: none'>" + v.id + "</td><td>" + v.pNo +
                    "</td><td>" + v.pTitle + "</td><td>" + v.pStatus +"</td><td>" + v.pType +
                    "</td><td>" + v.pRejectedReason + "</td><td>" + v.pFounder +
                    "</td><td>" + v.pCreateTime + "</td></tr>";
                $("#tableBody").append(html);
            })
        },"json");
    }

    /*条件查询*/
    $("#queryBtn").click(function () {
        let pageSize = $("#pageSize").val();
        let currentPage = $("#number").val();
        //清空数据
        $("#tableBody").html("");
        //alert($("#QueryForm").serialize());
        $.post('${cp}/problem/queryProblem', $("#queryForm").serialize(), function (data) {
            $.each(data, function (i, v) {
                let html = "<tr><td>" + "<input type='checkbox' class='check-item' name='check-item'>" +
                    "</td><td style='display: none'>" + v.id + "</td><td>" + v.pNo +
                    "</td><td>" + v.pTitle + "</td><td>" + v.pStatus +"</td><td>" + v.pType +
                    "</td><td>" + v.pRejectedReason + "</td><td>" + v.pFounder +
                    "</td><td>" + v.pCreateTime + "</td></tr>";
                $("#tableBody").append(html);
            })
        }, "json")
    });

    //将新增按钮绑定click事件
    $("#addBtn").click(function () {
        $("#addModal input").val("");
        $("#modeAddType").val("");
        $("#addModal").modal({
            // 点击背景模态框不关闭
            backdrop: "static"
        });
    });

    /*新增*/
    $("#addModalSaveBtn").click(function () {
        //获取页面输入的数据
        let formData = $("#addModalForm").serialize();
        //alert(formData);
        $.post('${cp}/problem/addProblem', formData, function (data) {
            //保存成功关闭模态框
            $("#addModal").modal("hide");
            //重新请求全部数据，填充页面
            doQuery(10,1);
        }, "json")
    });

    /*审批*/
    $("#approveBtn").click(function () {
        let id = "";
        $.each($(".check-item:checked"), function () {
            id = $(this).parents("tr").find("td:eq(1)").text();
        });
        //alert(id);
        if (id === "") {
            alert("请至少勾选一条数据！")
        } else {
            $.post("${cp}/problem/queryById", {"id": id}, function (data) {
                if (data.pStatus !== "已提交"){
                    alert("该问题已经审批。请勿重复操作");
                } else {
                    //弹出模态框
                    $("#approveModal").modal({
                        // 点击背景模态框不关闭
                        backdrop: "static"
                    });
                    $("input[id = 'modeApproveId']").val(data.id);
                    $("input[id = 'modeApprovePNo']").val(data.pNo);
                    $("input[id = 'modeApprovePTitle']").val(data.pTitle);
                    $("select[id = 'modeApproveType']").val(data.pType);
                    $("input[id = 'modeApprovePFindTime']").val(data.pFindTime);
                    $("input[id = 'modeApprovePPerson']").val(data.pPerson);
                    $("input[id = 'modeApprovePResponsible']").val(data.pResponsible);
                    $("input[id = 'modeApprovePPlanTime']").val(data.pPlanTime);
                    $("input[id = 'modeApprovePDescribe']").val(data.pDescribe);
                    $("input[id = 'modeApprovePRemark']").val(data.pRemark);
                }
            }, "json");
        }
    });

    /*控制原因输入框的显示*/
    function isPass(){
        var result = $("select[id='modeApproveResult']").val();
        //alert(result);
        //审批不通过，显示原因输入框
        if (result === "2"){
            $("#approveReason").show();
        }else {
            $("#approveReason").hide()
        }
    }

    /*提交审批*/
    $("#approveModalSaveBtn").click(function () {
       $.post('${cp}/problem/problemApprove',$("#approveModalForm").serialize(),function (data) {
           $("#approveModal").modal("hide");
           doQuery(10,1);
       },"json");
    });

    /*修改,弹出修改框*/
    $("#updateBtn").click(function () {
        let id = "";
        $.each($(".check-item:checked"), function () {
            id = $(this).parents("tr").find("td:eq(1)").text();
        });
        //alert(id);
        if (id === "") {
            alert("请至少勾选一条数据！")
        } else {
            //弹出模态框
            $("#updateModal").modal({
                // 点击背景模态框不关闭
                backdrop: "static"
            });
            $.post("${cp}/problem/queryById", {"id": id}, function (data) {
                $("input[id = 'modeUpdateId']").val(data.id);
                $("input[id = 'modeUpdatePNo']").val(data.pNo);
                $("input[id = 'modeUpdatePTitle']").val(data.pTitle);
                $("select[id = 'modeUpdateType']").val(data.pType);
                $("input[id = 'modeUpdatePFindTime']").val(data.pFindTime);
                $("input[id = 'modeUpdatePPerson']").val(data.pPerson);
                $("input[id = 'modeUpdatePResponsible']").val(data.pResponsible);
                $("input[id = 'modeUpdatePPlanTime']").val(data.pPlanTime);
                $("input[id = 'modeUpdatePDescribe']").val(data.pDescribe);
                $("input[id = 'modeUpdatePRemark']").val(data.pRemark);
            }, "json");
        }
    });

    /*修改之后再发起请求*/
    $("#updateModalSaveBtn").click(function () {
        //alert($("#userUpdateModalForm").serialize());
        $.post("${cp}/problem/updateProblem", $("#updateModalForm").serialize(), function () {
            //修改成功关闭模态框
            $("#updateModal").modal("hide");

            //重新请求全部数据，填充页面
            doQuery(10,1);
        }, "json")
    });

    //删除
    $("#delBtn").click(function () {

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
            $.post('${cp}/problem/deleteProblem', {"str": value}, function (result) {

                //删除成功，关闭模态框
                $("#delModal").modal("hide");

                alert("操作成功");

                //重新请求全部数据，填充页面
                doQuery(10,1);
            }, "json")
        }
    });

    //将上传附件按钮绑定click事件
    $("#upFiletBtn").click(function () {
        $("#upFileModal").modal({
            // 点击背景模态框不关闭
            backdrop: "static"
        })
    });

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

    /*清空*/
    function clearFunction() {
        $("input").val("");
        $("input[type='number']").val("1");
        $("select[name='pType'] option:first").prop("selected", 'selected');
        $("select[name='pStatus'] option:first").prop("selected", 'selected');
    }


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
