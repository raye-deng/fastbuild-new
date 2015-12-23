<%--
  修改人: 邓风森
  创建时间: 2015/2/11 15:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="fast-build-nav fast-build-nav-top">
    <a href="#" class="fast-build-menu-heading"><img
            src="${pageContext.request.contextPath}/resources/images/cloud-check-32.png">Fast Build Component</a>
    <ul class="fast-build-menu fast-build-menu-horizontal fast-build-menu-fixed fast-build-menu-right">
        <li><a href="${pageContext.request.contextPath}/main"> 首页</a></li>
        <li><a href="${pageContext.request.contextPath}/main"> 文章</a></li>
        <li><a href="${pageContext.request.contextPath}/example"> 起步</a></li>
        <li><a href="${pageContext.request.contextPath}/example/layout"> 布局 </a></li>
        <li><a href="${pageContext.request.contextPath}/about"> 关于</a></li>
        <li><input style="margin: 20px auto;" type="button" class="btn" id="sign" value="Login"
                   onclick="pop('loginPop')"/></li>
    </ul>
</div>

<jsp:include page="../content/login.jsp"></jsp:include>

