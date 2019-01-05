<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zyk
  Date: 2018/12/27
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>拟定措施</title>
    <link type="text/css" rel="stylesheet" href="${cp}/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${cp}/css/bootstrap-theme.min.css">
    <link type="text/css" rel="stylesheet" href="${cp}/css/bootstrap-table.css">
    <link type="text/css" rel="stylesheet" href="${cp}/css/fileinput.min.css">
    <script type="text/javascript" src="${cp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${cp}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${cp}/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${cp}/js/bootstrap-table.js"></script>
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
            <div class="col-sm-1 btn btn-success" id="measureBtn" style="width: 5%;margin-left: 10px;"><span
                    class="glyphicon glyphicon-plus">措施</span></div>
            <div class="col-sm-1 btn btn-success" id="approveBtn" style="width: 5%;margin-left: 10px;"><span
                    class="glyphicon glyphicon-pencil">审批</span></div>
            <div class="col-sm-1 btn btn-default" id="clearBtn" style="width: 5%;margin-left: 10px;"><span
                    class="glyphicon glyphicon-trash" onclick="clearFunction()">清空</span></div>
        </div>
    </div>

    <%--表格--%>
    <%--<div class="row">
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
                    <td>发生日期</td>
                    <td>录入人</td>
                    <td>责任人</td>
                    <td>计划完成日期</td>
                    <td>问题描述</td>
                    <td>备注</td>
                </tr>
                </thead>
                <tbody id="tableBody"></tbody>
            </table>
        </div>
    </div>--%>
    <table id="table"></table>
    <%--分页--%>
    <%--<footer>
        <ul class="pagination pagination-sm">
            <li>
                <select class="" id="pageSize" name="pageSize" onchange="getPageSize()">
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
    </footer>--%>
</div>

<!--拟定措施模态框-->
<div class="modal fade" id="measureModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: 35%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h5 class="modal-title" id="myMeasureModalLabel">修改</h5>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="measureModalForm">
                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="modeMeasureId" name="id" style="display: none">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">问题编号：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeMeasurePNo" name="pNo" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">问题标题：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeMeasurePTitle" name="pTitle" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">问题类型：</label>
                        <div class="col-sm-3">
                            <select id="modeMeasureType" class="form-control" name="pType" disabled>
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
                            <input type="text" class="form-control" id="modeMeasurePFindTime" name="pFindTime" onclick="WdatePicker()" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">录入人：</label>
                        <div class="col-sm-3">
                            <input type="text" id="modeMeasurePPerson" class="form-control" name="pPerson" disabled/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">责任人：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeMeasurePResponsible" name="pResponsible" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">计划完成日期：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeMeasurePPlanTime" name="pPlanTime"
                                   onclick="WdatePicker()" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">问题描述：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeMeasurePDescribe" name="pDescribe" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">备注：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeMeasurePRemark" name="pRemark" disabled />
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">审批结果：</label>
                        <div class="col-sm-3">
                            <select id="modeMeasureResult" class="form-control" name="pStatus" onchange="isPass()">
                                <%--<option value="">请选择</option>--%>
                                <option value="1" >通过</option>
                                <option value="2">不通过</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group" id="measureReason" hidden>
                        <label class="col-sm-3 control-label">原因：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="modeMeasureReason" name="pRemark" />
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary btn-sm" id="measureModalSaveBtn">提交</button>
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
    $(function() {
        //先销毁表格，在初始化
        $('#table').bootstrapTable('destroy').bootstrapTable({
            columns: [{
                checkbox: true,
                align: "center",
                valign: 'middle'
            },
                {
                    title: '问题id',
                    field: 'id',
                    align: 'center',
                    visible : false, //隐藏列
                },
                {
                    title: '问题编号',
                    field: 'pNo',
                    align: 'center',
                    /*formatter: function(value, row, index) {
                        //处理格式化数据
                    }*/
                },
                {
                    title: '问题标题',
                    field: 'pTitle',
                    align: 'center',
                },
                {
                    title: '问题状态',
                    field: 'pStatus',
                    align: 'center',
                },
                {
                    title: '问题类型',
                    field: 'pType',
                    align: 'center',
                },
                {
                    title: '创建人',
                    field: 'pFounder',
                    align: 'center',
                },
                {
                    title: '创建时间',
                    field: 'pCreateTime',
                    align: 'center',
                }
                ],
            url: "${cp}/problem/getDepartment", //请求数据的地址URL
            method: 'post',                      //请求方式（*）
            contentType : "application/x-www-form-urlencoded", // 如果是post必须定义
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: false,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 20, 30, 50, 100],     //可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: false,                //是否启用点击选中行
            height: 600,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: true,                   //是否显示父子表
            responseHandler: function responseHandler(sourceData) {
                //这里要做分页，所以对返回的数据进行了处理
                return {
                    "pages": sourceData.pages,  //总页数
                    "total": sourceData.total,  // 总条数
                    "pageNum": sourceData.pageNum, //当前页
                    "rows": sourceData.rows // 返回的数据列表（后台返回一个list集合）
                };
                /*
                // 把res.rows中嵌套的json对象取出来追加到res.rows中
                for (var i = 0; i < res.rows.length; i++) {
                    var grade = res.rows[i].gradeList[0];
                    for (var key in grade) {
                        //如果grade的键值等于gradeName 就追加
                        if (key == "gradeName") {
                            var k = key;
                            var value = grade[key];
                            res.rows[i][k] = value;
                        }
                    }
                }

                //把res.rows 中的 gradeList删除
                for (var i = 0; i < res.rows.length; i++) {
                    delete res.rows[i]["gradeList"];
                }
                //返回格式化好的json数据
                return res;
                */

            },
            queryParams: function queryParams(params) {
                //设置查询参数,就是把页面需要查询的字段通过jquery取值后传到后台
                var param = {
                    //id: $("input[name='id']").val(),
                    pageSize: params.limit, // 页面大小
                    currentPage: params.offset // 页码
                };
                return param;
            },
            onExpandRow: function(index, row, $detail) {
                oInit.InitSubTable(index, row, $detail);
            },
            //注册加载子表的事件。你可以理解为点击父表中+号时触发的事件
            /*onExpandRow: function(index, row, $detail) {
                //这一步就是相当于在当前点击列下新创建一个table
                var cur_table = $detail.html('<table></table>').find('table');
                var html = "";
                html += "<table class='table'>";
                html += "<thead>";
                html += "<tr style='height: 40px;'>";
                html += "<th>用户id</th>";
                html += "<th>用户姓名</th>";
                html += "</tr>";
                html += "</thead>";
                $.ajax({
                    type: "post",
                    url: "user/list",       //子表请求的地址
                    data: {id:row.id,name:row.name},//我这里是点击父表后，传递父表列id和nama到后台查询子表数据
                    async: false,           //很重要，这里要使用同步请求
                    success: function(data) {
                        html += '<ul class="list-group" >';
                        //遍历子表数据
                        $.each(data.rows,
                            function(n, value) {
                                html += "<tr  align='center'>"
                                    + "<td>" + value.id + "</td>"
                                    + "<td>" + value.name + "</td>"
                                    + "</tr>";
                            });
                        html += '</table>';
                        $detail.html(html); // 关键地方
                    }
                });
            },*/
        });
    });
    //初始化子表格(无线循环)
    oInit.InitSubTable = function (index, row, $detail) {
        var parentid = row.id;
        var cur_table = $detail.html('<table></table>').find('table');
        $(cur_table).bootstrapTable({
            url: '${cp}/measure/selectByPrimaryKey',
            method: 'post',
            queryParams: { strParentID: parentid },
            ajaxOptions: { strParentID: parentid },
            clickToSelect: false,
            detailView: true,    //父子表
            uniqueId: "MENU_ID",
            pageSize: 10,
            pageList: [10, 25, 30],
            columns: [{
                checkbox: true
            }, {
                title: '问题描述',
                field: 'itemDesc',
                align: 'center',
                },
                {
                    title: '责任人',
                    field: 'itemResponsible',
                    align: 'center',
                },
                {
                    title: '计划完成日期',
                    field: 'itemPlanTime',
                    align: 'center',
                },
                {
                    title: '措施',
                    field: 'itemMeasure',
                    align: 'center',
                },
                {
                    title: '驳回原因',
                    field: 'itemReason',
                    align: 'center',
                }, ],
            //无线循环取子表，直到子表里面没有记录
            onExpandRow: function (index, row, $Subdetail) {
                oInit.InitSubTable(index, row, $Subdetail);
            }
        });
    };
</script>
</body>
</html>
