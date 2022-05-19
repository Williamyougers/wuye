<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--	<% if (session.getAttribute("customAccount")==null) response.sendRedirect("/login.jsp");%>--%>
    <!--
        ===
        This comment should NOT be removed.

        Charisma v2.0.0

        Copyright 2012-2014 Muhammad Usman
        Licensed under the Apache License v2.0
        http://www.apache.org/licenses/LICENSE-2.0

        http://usman.it
        http://twitter.com/halalit_usman
        ===
    -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>公告查询:物业管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="/css/charisma-app.css" rel="stylesheet">
    <link href='/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='/css/jquery.noty.css' rel='stylesheet'>
    <link href='/css/noty_theme_default.css' rel='stylesheet'>
    <link href='/css/elfinder.min.css' rel='stylesheet'>
    <link href='/css/elfinder.theme.css' rel='stylesheet'>
    <link href='/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='/css/uploadify.css' rel='stylesheet'>
    <link href='/css/animate.min.css' rel='stylesheet'>

    <!-- jQuery -->
    <script src="/bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="/http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="/img/favicon.ico">

</head>

<body>
<!-- topbar starts -->
<div class="navbar navbar-default" role="navigation">

    <div class="navbar-inner">
        <button type="button" class="navbar-toggle pull-left animated flip">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index2.jsp"> <img alt="Charisma Logo" src="/img/logo20.png" class="hidden-xs"/>
            <span>物业管理系统</span></a>

        <!-- user dropdown starts -->
        <div class="btn-group pull-right">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> ${customAccount.username}</span>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="user/../logout">注销登录</a></li>
            </ul>
        </div>
        <!-- user dropdown ends -->
    </div>
</div>
<!-- topbar ends -->
<div class="ch-container">
    <div class="row">

        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">功能</li>
							<li><a class="ajax-link" href="/index2.jsp"><i class="glyphicon glyphicon-home"></i><span> &ensp;首&ensp;页</span></a>
							<li class="active"><a class="ajax-link" href="/notice/listforuser"><i class="glyphicon glyphicon-envelope"></i><span> &ensp;公&ensp;告&ensp;查&ensp;询</span></a>
							<li><a class="ajax-link" href="customAccount/change&accountid=session.getAccountid();"><i class="glyphicon glyphicon-info-sign"></i><span> &ensp;修&ensp;改&ensp;密&ensp;码</span></a>
							<li><a class="ajax-link" href="/maintain/maintainUserList&username=${customAccount.username }"><i class="glyphicon glyphicon-wrench"></i><span> &ensp;报&ensp;修&ensp;管&ensp;理</span></a>
							<li><a class="ajax-link" href="/customAccount/findById2&accountid=${customAccount.accountid }"><i class="glyphicon glyphicon-user"></i><span> &ensp;业&ensp;主&ensp;信&ensp;息</span></a>
							<li><a class="ajax-link" href="/house/findByOwnerid&ownerid=${customAccount.ownerid }"><i class="glyphicon glyphicon-list-alt"></i><span> &ensp;房&ensp;产&ensp;信&ensp;息</span></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="/http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <div>
                <ul class="breadcrumb">
                    <li>
                        <a href="index2.jsp">首页</a>
                    </li>
                    <li>
                        <a href="notice/listforuser">公告查询</a>
                    </li>
                </ul>
            </div>

            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-envelope"></i> 公告查询</h2>

                            <div class="box-icon">
                                <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                        class="glyphicon glyphicon-chevron-up"></i></a>
                                <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">

                            <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
                                <thead>
                                <br/>
                                <br/>
                                <tr>
							        <th>公告标题</th>
							        <th>发布日期</th>
							        <th>发布者</th>
							    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="notice" items="${notice}">
							        <tr>
							        	<td><a href="notice/noticeview&id=${notice.id}">${notice.title}</a></td>
							 <!--         <td align="center">${notice.title}</td>   -->   
							            <td align="center">${notice.ndate }</td>
							            <td align="center">${notice.uper}</td>
                                    </tr>
                                </c:forEach>

                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!--/span-->

            </div><!--/row-->


            <!-- content ends -->
        </div><!--/#content.col-md-0-->
    </div><!--/fluid-row-->


    <hr>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3>确认？</h3>
                </div>
                <div class="modal-body">
                    <p>此条记录将被永久删除</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">取消</a>
                    <a class="btn btn-danger btn-ok">确认删除</a>
                </div>
            </div>
        </div>
    </div>

    <footer class="row">
        <p class="col-md-9 col-sm-9 col-xs-12 copyright">&copy; <a href="/http://usman.it" target="_blank">Muhammad
            Usman</a> 2012 - 2015</p>

        <p class="col-md-3 col-sm-3 col-xs-12 powered-by">Powered by: <a
                href="/http://usman.it/free-responsive-admin-template">Charisma</a></p>
    </footer>

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="/ower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library /or cookie management -->
<script src="/s/jquery.cookie.js"></script>
<!-- calender/plugin -->
<script src='/ower_components/moment/min/moment.min.js'></script>
<script src='/ower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data tab/e plugin -->
<script src="/s/jquery.dataTables.min.js"></script>
<!-- select o/ dropdown enhancer -->
<script src="/ower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin f/r gallery image view -->
<script src="/ower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notifica/ion plugin -->
<script src="/s/jquery.noty.js"></script>
<!-- library /or making tables responsive -->
<script src="/ower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plu/in -->
<script src="/ower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rat/ng plugin -->
<script src="/s/jquery.raty.min.js"></script>
<!-- for iOS /tyle toggle switch -->
<script src="/s/jquery.iphone.toggle.js"></script>
<!-- autogrow/ng textarea plugin -->
<script src="/s/jquery.autogrow-textarea.js"></script>
<!-- multiple/file upload plugin -->
<script src="/s/jquery.uploadify-3.1.min.js"></script>
<!-- history./s for cross-browser state change on ajax -->
<script src="/s/jquery.history.js"></script>
<!-- applicat/on script for Charisma demo -->
<script src="/s/charisma.js"></script>
<script>
    $('#myModal').on('show.bs.modal', function(e) {
        $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
    });
</script>

</body>
</html>
