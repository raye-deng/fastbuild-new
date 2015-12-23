<%--
  修改人: 邓风森
  创建时间: 2015/2/13 15:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="fast-build-content">
    <div class="fast-build-content-header">
        <p>我的项目授权申请</p>
    </div>
    <div class="fast-build-content-main">
        <table class="table-data">
            <thead>
                <td>序号</td>
                <td>项目名称</td>
                <td>项目所有人</td>
                <td>申请时间</td>
                <td>当前状态</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${applys}" var="apply">
                <tr>
                    <td>${apply.id}</td>
                    <td>${apply.projectName}</td>
                    <td>${apply.projectHolder}</td>
                    <td>${apply.applyTime}</td>
                    <td status="${apply.processStatus}" render="statusRender">
                        <c:if test="${apply.processStatus == '2'}">
                            <a style="display: block;font-size: 12px"  href="javascript:showMsg('${apply.refuseMsg}');">查看详情</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    function statusRender(element,status){
        var html="";
        if(status == 0){
            html="等待审批";
        }else if(status == 1){
            html="<font color='#65C9A8'>已通过</font>";
        }else if(status == 2){
            html="<font color='#D66B7B'>被拒绝</font>";
        }else if(status == 3){
            html="<font color='#D66B7B'>已作废（已解除项目权限，可再次申请）</font>";
        } else{
            html="<font color='#D66B7B'>状态异常</font>";
        }
        $(element).prepend(html);
    }

    function showMsg(msg){
        tip(msg,function(){});
    }
</script>
