<%--
  修改人: 邓风森
  创建时间: 2015/2/12 10:32
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="fast-build-nav-sign">
    <ul>
        <c:forEach items="${navs}" var="nav">
           ${pageContext.request.getHeader("").replaceAll(".jsp",".do")}
            <c:if test="${pageContext.request.getServletPath().replaceAll('.jsp','.do').contains(nav.configUrl) == true}">
                <li><a href="${pageContext.request.
contextPath}${nav.configUrl}" class="active">${nav.configName}<span></span></a></li>
            </c:if>
            <c:if test="${pageContext.request.getServletPath().replaceAll('.jsp','.do').contains(nav.configUrl) == false}"> 
                <li><a href="${pageContext.request.contextPath}${nav.configUrl}" >${nav.configName}<span></span></a></li>
             </c:if> 
        </c:forEach>
    </ul>
</div>
