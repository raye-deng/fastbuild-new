<%--
  修改人: 邓风森
  创建时间: 2015/2/11 15:28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="fast-build-nav fast-build-nav-top">
    <a href="#" class="fast-build-menu-heading">
    	<img src="${pageContext.request.contextPath}/resources/images/cloud-check-32.png" >
    	网龙-自动化测试平台
    </a>
    <ul class="fast-build-menu fast-build-menu-horizontal fast-build-menu-fixed fast-build-menu-right">
        <li><a href="${pageContext.request.contextPath}/"> 首页</a></li>
        <li><a href="#"> 起步</a></li>
        <li><a href="#"> 组件</a></li>
        <li><a href="#"> 关于</a></li>
    </ul>
</div>
<div class="user-box" onclick="javascript:logout();">
        <div class="icon">
            <img src="${pageContext.request.contextPath}${loginUser.userIcon}">
            <p>${loginUser.userName}</p>
            <p style="font-size: 10px;color: #aaaaaa;">(点击注销登录)</p>
        </div>
<!--         <div class="detail">

        </div> -->
        <script>
            function logout(){
                tip("确定要注销？",function(){
                    var params={};
                    $.ajax({
                        type:"POST",
                        url:"${pageContext.request.contextPath}/logout",
                        data:params,
                        dataType:"json",
                        async:false,
                        success:function(data){
                            if(data.result == true) {
                            	 location.href="${pageContext.request.contextPath}/main";
                            }else{
                                alert(data.errorMsg);
                            }
                        },
                        error:function(data){
                        	alert(data.errorMsg);
                        }
                    });
                })
            }
            function showDetail(){
                $('.user-box').attr("href","javascript:hideDetail();");
                $('.user-box .detail').fadeIn("normal");
            }
            function hideDetail(){
                $('.user-box .detail').fadeOut("normal");
                $('.user-box').attr("href","javascript:showDetail();");
            }
        </script>
    </div>
<script>
</script>
<jsp:include page="../../../my/new_prj.jsp"></jsp:include>