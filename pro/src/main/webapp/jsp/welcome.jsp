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
    <script type="text/javascript" src="${cp}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${cp}/js/bootstrap.min.js"></script>

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
                        <input type="number" id="number" value="1" style="width: 50px;">
                    </li>
                    <li id="nextPage" class="btn btn-sm">
                        <i class="glyphicon glyphicon-chevron-right"></i>
                    </li>
                </ul>
            </footer>
        </div>--%>
    </div>
</div>

<script>
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
</script>

<%--页面跳转--%>
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
