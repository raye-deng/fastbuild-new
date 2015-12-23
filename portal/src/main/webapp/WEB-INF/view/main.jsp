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
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/cloud_favicon.ico" type="image/gif">
    <style>
        .info-box {
            min-height: 80px;
            border-bottom: 1px dotted #dddddd;
            margin: 10px auto;
        }

        .info-box a {
            width: 100%;
            height: 80px;
            display: block;
        }

        .info-box a:hover {
            color: blue !important;
        }

        .fast-build-menu-heading {
            font-size: 1.2rem;
            font-weight: 550;
            color: #666;
            font-family: '幼圆', Helvetica;
        }
    </style>
</head>
<body>
<jsp:include page="tpl/header/nav-top.jsp"></jsp:include>
<div id="banner_tabs" class="flexslider">
    <ul class="slides">
        <li>
            <a title="" target="_blank" href="#">
                <img width="1920" height="482" alt=""
                     style="background: url('${pageContext.request.contextPath}/resources/banner/images/banner1.jpg') no-repeat center;"
                     src="${pageContext.request.contextPath}/resources/banner/images/alpha.png">
            </a>
        </li>
        <li>
            <a title="" href="#">
                <img width="1920" height="482" alt=""
                     style="background: url('${pageContext.request.contextPath}/resources/banner/images/banner2.jpg') no-repeat center;"
                     src="${pageContext.request.contextPath}/resources/banner/images/alpha.png">
            </a>
        </li>
        <li>
            <a title="" href="#">
                <img width="1920" height="482" alt=""
                     style="background: url('${pageContext.request.contextPath}/resources/banner/images/banner3.jpg') no-repeat center;"
                     src="${pageContext.request.contextPath}/resources/banner/images/alpha.png">
            </a>
        </li>
    </ul>
    <ul class="flex-direction-nav">
        <li><a class="flex-prev" href="javascript:;">Previous</a></li>
        <li><a class="flex-next" href="javascript:;">Next</a></li>
    </ul>
    <ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
        <li><a>1</a></li>
        <li><a>2</a></li>
        <li><a>2</a></li>
    </ol>
</div>
<div class="fast-build-content">
    <div class="page-tip" style="color: green;">【温馨提示：本页面数据抓取自CSDN博客网，私人信息，全部为原创作品】</div>
    <ul>
        <c:forEach items="${articles}" var="article">
            <li>
                <div class="info-box">
                    <a href="${pageContext.request.contextPath}/page/article/details/${article.id}">
                        <p class="fast-build-menu-heading">【原创】${article.title}</p>

                        <p class="absolute-right-bottom">
                            <span style="margin-right: 20px;">${article.createTime}</span>
                            <span>阅读数：(${article.viewCount})</span>
                            <span>评论数：(${article.commentCount})</span>
                        </p>
                        <span class="clear"></span>
                    </a>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
<script type="text/javascript">
    $(function () {
        var bannerSlider = new Slider($('#banner_tabs'), {
            time: 5000,
            delay: 400,
            event: 'hover',
            auto: true,
            mode: 'fade',
            controller: $('#bannerCtrl'),
            activeControllerCls: 'active'
        });

        $('#banner_tabs .flex-prev').click(function () {
            bannerSlider.prev()
        });

        $('#banner_tabs .flex-next').click(function () {
            bannerSlider.next()
        });
    })
</script>
<jsp:include page="tpl/footer/footer_default.jsp"></jsp:include>
</body>
</html>
