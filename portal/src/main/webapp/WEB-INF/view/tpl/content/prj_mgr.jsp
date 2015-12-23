<%--
  修改人: 邓风森
  创建时间: 2015/2/11 16:17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="fast-build-content" >
    <div class="fast-build-content-header">
        <p>页面标题</p>
        <div class="search-box" ref="fast-build-td-box">
            <input type="text" placeholder="查找关键字" >
            <input type="button" value="筛选"  >
        </div>
    </div>
    <div class="fast-build-content-main">
        <div class="fast-build-td-box">
            <span class="close modify" title="修改" ></span>
            <span class="close fork" title="Fork" ></span>
            <span class="close delete" title="删除" ></span>
            <a class="catalog" title="模块管理"  href="#">
            </a>
            <h2>标题</h2>
            <ul>
                <li><p><label>时间：</label>2015-08-04 10:00:00</p></li>
                <li><p status="0" render="typeRender"><label>类型转换组件：</label></p></li>
                <li><p status="1" render="typeRender"><label>类型转换组件：</label></p></li>
                <li><p status="2" render="typeRender"><label>类型转换组件：</label></p></li>

                <li><p status="0" render="statusRender"><label>状态转换组件：</label></p></li>
                <li><p status="1" render="statusRender"><label>状态转换组件：</label></p></li>
                <li><p status="2" render="statusRender"><label>状态转换组件：</label></p></li>
                <li><p status="3" render="statusRender"><label>状态转换组件：</label></p></li>
                <li><p status="4" render="statusRender"><label>状态转换组件：</label></p></li>
                <li><p><label>普通属性：</label>普通属性值</p></li>
                <li>
                    <p><label>描述信息：</label></p>
                    <p style="text-indent:1.6cm">组件模块描述信息，简要介绍关于模块组件的信息</p>
                </li>
            </ul>
            <input class="btn-normal absolute-right-bottom" value="按钮" type="button" >
        </div>
</div>
<script>
    function typeRender(element,type){
        var html="";
        switch(type){
            case "0":
                html = "类型转换组件（0）";
                break;
            case "1":
                html = "类型代码（1）";
                break;
            default:
                html = "<font color='red' >错误类型代码（ "+type+"）</font>";
        }
        $(element).html("<label>类型组件：</label>"+html);
    }
    
    function statusRender(element,status){
        var html="";
        if(status == 0){
            html="状态代码（0）";
        }else if(status == 1){
            html="<font color='#3D7BB3'>状态代码(1)</font>";
        }else if(status == 2){
            html="<font color='#CE6B46'>状态代码(2)</font>";
        }else if(status == 3){
            html="<font color='#65C9A8'>状态代码(3)</font>";
        }else{
            html="<font color='#D66B7B'>错误状态代码 : ("+4+")</font>";
        }
        $(element).html("<label>状态组件：</label>"+html);
    }

</script>

