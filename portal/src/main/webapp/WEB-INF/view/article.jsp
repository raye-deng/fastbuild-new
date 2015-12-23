<%--
  Created by IntelliJ IDEA.
  User: dengfs
  Date: 2015/11/26
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${title}</title>
    <meta http-equiv="Content-Type" charset="utf-8" content="text/html">
    <meta http-equiv="X-UA-Compatible" content="IE=7,IE=9,IE=edge"/>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/fastbuild/css/fastbuild.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/style/csdn_article.css">
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

        .page-title {
            max-width: 1000px;
            text-align: left;
            margin-top: 40px;
            margin-bottom: 30px;
            border-bottom: 1px dashed #dddddd;
        }

        .page-title h2 {
            font-size: 1.8rem;
            color: #333333;
            text-align: left;

        }

        #content {
            border-left: 1px solid #dddddd;
            /*border-right: 1px solid #dddddd;*/
            text-align: left;
            padding: 2em 10px 6em 10px;;
            margin-left: 2em;;
        }

        #content * {
            max-width: 1000px !important;
            word-break: break-all;
        }

        code, pre {
            max-width: 100% !important;
            white-space: pre-wrap !important;
            word-wrap: break-word !important;
        }
    </style>
</head>
<body>
<jsp:include page="tpl/header/nav-top.jsp"></jsp:include>

<div class="fast-build-content">
    <div class="page-title">
        <h2>${title}</h2>

        <div class="page-tip" style="color: green;">【温馨提示：本页面数据抓取自CSDN博客网，私人信息，全部为原创作品】</div>
    </div>
    <div id="content">
        ${content}
    </div>
</div>
<script>
    function setContent(ele, content) {
        $("#article_content").html(content);
    }
</script>
<jsp:include page="tpl/footer/footer_default.jsp"></jsp:include>
</body>
</html>
