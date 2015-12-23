<%--
  修改人: 邓风森
  创建时间: 2015/2/25 17:05
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="fast-build-content">
    <div class="fast-build-content-header">
        <p>项目申请管理</p>
    </div>
    <div class="fast-build-content-main">
        <table class="table-data">
            <thead>
            <td>序号</td>
            <td>项目名称</td>
            <td>申请人</td>
            <td>申请时间</td>
            <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${applys}" var="apply">
                <tr>
                    <td>${apply.id}</td>
                    <td>${apply.projectName}</td>
                    <td>${apply.applyUser}</td>
                    <td>${apply.applyTime}</td>
                    <c:if test="${apply.processStatus == 0}">
                        <td ><a href='javascript:accept(${apply.id});'><font color='#65C9A8'>通过</font></a>/<a href='javascript:refuseConfirm(${apply.id});'><font color='#D66B7B'>拒绝</font></a></td>
                    </c:if>
                    <c:if test="${apply.processStatus != 0}">
                    <td status="${apply.processStatus}" render="actionRender"></td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="fast-build-pop-win" id="msgBox">
    <div class="fast-build-pop-title">
        <h2>拒绝项目权限申请</h2>
        <span></span>
    </div>
    <div class="fast-build-pop-content">
        <div class="inputBox">
            <label>回绝信息：</label>
            <input type="text" placeholder="refuse message" id="refuseMsg" name="refuseMsg">
        </div>
    </div>
    <div class="fast-build-pop-submit">
        <input id="refuseBtn" type="button" value="确定" class="btn">
        <p>正在提交数据...</p>
    </div>
</div>
<script>
    function actionRender(element,status){
        var html="";
        if(status == 1){
            html="<font color='#65C9A8'>已通过</font>";
        }else if(status == 2){
            html="<font color='#D66B7B'>已拒绝</font>";
        }else if(status == 3) {
            html="<font color='#D66B7B'>已作废（用户解除项目权限）</font>";
        }else{
            html="<font color='#D66B7B'>状态异常:"+status+"</font>";
        }
        $(element).prepend(html);
    }
    function showMsg(msg){
        tip(msg,function(){});
    }

    function accept(id){
        var params={
            "applyId":id
        };
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/my/apply/accept",
            data:params,
            dataType:"json",
            async:false,
            success:function(data){
                if(data.result == true) {
                    tip("操作成功!",function(){
                        location.reload();
                    });
                }else{
                    tip("操作失败："+data.errorMsg);
                }
            },
            error:function(data){
                tip("操作失败："+data.errorMsg);
            }
        });
    }

    function refuseConfirm(id){
        $("#refuseBtn").attr("onclick","refuse("+id+")");
        pop("msgBox");
    }


    function refuse(id){
        $("#msgBox").fadeOut();
        var msg = $("#refuseMsg").val();
        var params={
            "applyId":id,
            "refuseMsg":msg
        };
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/my/apply/refuse",
            data:params,
            dataType:"json",
            async:false,
            success:function(data){
                if(data.result == true) {
                    tip("操作成功!",function(){
                        location.reload();
                    });
                }else{
                    tip("操作失败："+data.errorMsg);
                }
            },
            error:function(data){
                tip("操作失败："+data.errorMsg);
            }
        });
    }
</script>