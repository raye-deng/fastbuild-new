<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="fast-build-pop-win" id="loginPop">
    <div class="fast-build-pop-title">
        <h2>登录</h2>
        <span></span>
    </div>
    <div class="fast-build-pop-content">
        <div class="inputBox">
            <label>账户：</label>
            <input type="text" placeholder="account" id="loginName" name="loginName">
        </div>
        <div class="inputBox">
            <label>密码：</label>
            <input type="password" placeholder="password" id="loginPassword" name="loginPassword">
        </div>
    </div>
    <div class="fast-build-pop-submit">
        <input id="loginBtn" type="button" value="点击登录" class="btn" onclick="login()">
        <p>正在登录...</p>
    </div>
</div>

<script>
    function login(){
        $(".fast-build-pop-submit").find("p").text("正在登录...");
        $(".fast-build-pop-submit").find("input").fadeOut("fast",function(){
            $(".fast-build-pop-submit").find("p").fadeIn("fast");
        });

       setTimeout(function(){
           $(".fast-build-pop-submit").find("p").text("登录成功...");
           setTimeout(function () {
               $(".fast-build-pop-win").fadeOut("slow", function () {
                   $(".fast-build-pop-submit").find("p").fadeOut("slow", function () {
                       $(".fast-build-pop-submit").find("input").fadeIn("slow");
                       location.reload();
                   });
               })
           }, 1000);
           $(".fast-build-pop-submit").find("p").text(data.errorMsg);
           setTimeout(function () {
               $(".fast-build-pop-submit").find("p").fadeOut("slow", function () {
                   $(".fast-build-pop-submit").find("input").fadeIn("slow");
               });
           }, 1000);
       },1000);
    }

    function mapToString(map){
        var jsonStr="{";
        for(var i in map){
            jsonStr+= "'"+i+"':'"+map[i]+"',"
        }
        jsonStr+="'':''}";

        return jsonStr;
    }
</script>
