<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/8/4
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>FastBuild</title>
    <meta http-equiv="Content-Type" charset="utf-8" content="text/html">
    <meta http-equiv="X-UA-Compatible" content="IE=7,IE=9,IE=edge"/>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/fastbuild/css/fastbuild.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/banner/css/style.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/banner/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/banner/js/slider.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/jquery.json.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/fastbuild/js/fastbuild.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/fastbuild/js/fastbuild-layout.js"></script>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/cloud_favicon.ico" type="image/gif">
    <style>
        body {
            padding: 0;
        }
    </style>
</head>
<body>
<jsp:include page="../tpl/header/nav-top.jsp"></jsp:include>

<div class="content" id="renderMain" style="border-bottom:1px solid #dddddd;">
    <div layout-id="1">
        <div class="page-title">
            <h4>FastBuild插件</h4>
        </div>
        <ul class="fast-build-menu">
            <li class="item " data-ref="ref-nav" data-url="${pageContext.request.contextPath}/page/article/4">
                <a href="#" class="info-box">Layout插件</a>
            </li>
            <li class="item" data-ref="ref-nav" data-url="${pageContext.request.contextPath}/page/article/5">
                <a href="#" class="info-box">Data Render插件</a>
            </li>
            <li class="item" data-ref="ref-nav" data-url="${pageContext.request.contextPath}/page/article/5">
                <a href="#" class="info-box">Search Box插件</a>
            </li>
            <li class="item" data-ref="ref-nav" data-url="${pageContext.request.contextPath}/page/article/5">
                <a href="#" class="info-box">Scroller插件</a>
            </li>
            <li class="item" data-ref="ref-nav" data-url="${pageContext.request.contextPath}/page/article/5">
                <a href="#" class="info-box">Timer 插件</a>
            </li>
        </ul>
    </div>
    <div layout-id="2">
        <div class="fast-build-page" data-id="ref-nav">
            <ul>
                <li class="item" data-ref="panel3" data-tpl="true" data-url="detail">
                    <div class="info-box">
                        <h4 name="title" class="title"></h4>

                        <p name="description"></p>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <div layout-id="3">
        <div class="fast-build-page" data-id="panel3">
            <div data-tpl="true">
                <div class="info-box">
                    <h4 name="title" class="title"></h4>

                    <div name="description" style="width: 95%; margin: 20px auto;;"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('#renderMain').buildPlugin({
            'render_id': '#renderMain',
            'panels_weights': [2, 3, 5],
            'action_class': '.info-box'
        });

    });
</script>
<jsp:include page="../tpl/footer/footer_default.jsp"></jsp:include>

</body>
</html>
