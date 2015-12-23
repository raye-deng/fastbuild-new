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
    <title>关于我</title>
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
        .fast-build-content {
            padding: 0 10px;
            overflow: hidden;
            margin: 40px auto;
        }

        .summary {
            padding: 10px 10px 25px 0;
            border-bottom: 2px solid #dddddd;
        }

        .summary h1 {
            font-size: 1.8rem;
            font-family: '幼圆', Helvetica, Times;
            line-height: 2.2rem;
            padding: 10px 0 10px 0;
            text-indent: 1em;
            background: #efefef;
            width: 80%;
        }

        .summary img {
            max-width: 110px;
            margin-right: 5%;
        }

        .summary * {
            line-height: 25px;
        }

        .details {
            padding: 120px 0 40px 10px;
            position: relative;
            min-height: 200px;
        }

        .details dt h5 {
            line-height: 30px;
            font-size: 1.6rem;
            font-family: '幼圆', Helvetica, Times;
            border-bottom: 1px dashed #cccccc;
        }

        .details dd {
            text-indent: 2em;
            line-height: 25px;
            color: #666666;
            min-height: 80px;
            padding: 10px 0 0 0;
        }

        .details dd strong {
            color: #333333;
        }

        .work-experience, .project-experience, .education-background, .social, .training, .certificates, .language-skill, .professional-skill, .photo-attach {
            margin: 20px auto;
            background: #efefef;
            padding: 10px;
            overflow: hidden;
            -webkit-border-radius: 5px !important;;
            -moz-border-radius: 5px !important;;
            border-radius: 5px !important;
        }

        .work-experience h6, .project-experience h5 {
            font-size: 1.4rem;
            font-family: '幼圆', Helvetica, Times;
            line-height: 25px;
            padding: 0;
            text-indent: 0;

        }

        .photo-attach img {
            max-width: 95%;
            margin: 0 auto;;
        }

        p {
            color: #333333;
        }

        dd {
            display: none;
        }

        dt {
            cursor: pointer;
            list-style: circle;
            float: left;
            width: 30px;
            margin: 0 1.6%;
            padding: 0 0 0 8px;
            height: 120px;
            position: absolute;
            top: 0;
            left: 0;
        }

        dt:hover {
            background: #efefef;
        }
    </style>
</head>
<body>
<jsp:include page="tpl/header/nav-top.jsp"></jsp:include>
<div class="fast-build-content">
    <div class="page-tip" style="color: green;">【温馨提示：本页面数据抓取自智联招聘，个人简历预览，为私人信息】</div>
    <div class="resumeBody">
        <div class="summary">
            <img src="http://ww4.sinaimg.cn/cmw218/92510d36jw1e7b044e7y7j20vc0uk77u.jpg" alt="" width="140"
                 align="right" class="headerImg"/>

            <h1>&#37011;&#39118;&#26862;</h1>

            <p>男 <span class="ver-line">|</span>
                <span>未婚 <span class="ver-line">|</span></span>
                1992年12月生 <span class="ver-line">|</span>
                户口：福建泉州 <span class="ver-line">|</span>
                现居住于福建福州
            </p>

            <p>1年工作经验</p>

            <p>18359219330</p>

            <p>E-mail：<a href="mailto:codingmates@gmail.com">codingmates@gmail.com</a></p>

            <p>网站：<a href="http://cdmates.com">http://cdmates.com</a></p>
        </div>

        <dl class="details">
            <dt>
            <h5>求职意向</h5>
            </dt>
            <dd>
                <ul>
                    <li><strong>工作性质：</strong>全职</li>
                    <li><strong>期望职业：</strong>软件/互联网开发/系统集成、IT运维/技术支持、电信/通信技术开发及应用</li>
                    <li><strong>期望行业：</strong>IT服务(系统/数据/维护)、互联网/电子商务、计算机软件</li>
                    <li><strong>工作地区：</strong>厦门</li>
                    <li><strong>期望月薪：</strong>8001-10000元/月</li>
                    <li><strong>目前状况：</strong>我目前在职，正考虑换个新环境（如有合适的工作机会，到岗时间一个月左右）</li>
                </ul>
            </dd>
            <dt>
            <h5>自我评价</h5></dt>
            <dd>
                <p style="word-break: break-all; ">自我管理严格，工作严谨有责任，工作能力强。</p>
            </dd>
            <dt>
            <h5>工作经历</h5>
            </dt>
            <dd>

                <div class="work-experience">
                    <h6>福州飞迈软件科技有限公司 <span class="ver-line">|</span> <span class="ver-line"
                                                                           style="display:none">|</span> Java软件开发工程师
                    </h6>

                    <p>2014/06 -- 2014/11</p>

                    <p>
                        <span> 行业类别：计算机软件 <span class="ver-line">|</span> </span>
                        <span>企业性质：民营 <span class="ver-line">|</span> </span>
                        <span> 规模：20-99人 <span class="ver-line">|</span> </span>
                        <span> 职位月薪：4001-6000元/月</span>
                    </p>

                    <p style="word-break: break-all;">
                        工作描述：
                        微信公众平台开发
                    </p>
                </div>

                <div class="work-experience">
                    <h6>网龙 <span class="ver-line">|</span> <span class="ver-line" style="display:none">|</span>
                        软件测试开发工程师 </h6>

                    <p>2011/11 -- 2015/07</p>

                    <p>
                        <span> 行业类别：互联网/电子商务 <span class="ver-line">|</span> </span>
                        <span>企业性质：股份制企业 <span class="ver-line">|</span> </span>
                        <span> 规模：1000-9999人 <span class="ver-line">|</span> </span>
                        <span> 职位月薪：6001-8000元/月</span>
                    </p>

                    <p style="word-break: break-all;">
                        工作描述：
                        测试类软件/平台开发，了解测试模式。
                    </p>

                </div>

            </dd>
            <dt>
            <h5>项目经验</h5>
            </dt>
            <dd>

                <div class="project-experience">
                    <p>2015/04 -- 2015/05</p>
                    <h6>微信公众号第三方平台开发（独立开发）</h6>

                    <div>
                        <p>
                            <strong>软件环境：</strong>JDK1.7
                        </p>

                        <p>
                            <strong>硬件环境：</strong>windowserver2003
                        </p>

                        <p>
                            <strong>开发工具：</strong>IDEA14.04
                        </p>
                    </div>
                    <p>
                        <strong>责任描述：</strong>
                        微信API接入开发，项目设计，整合，及管理
                    </p>

                    <p>
                        <strong>项目简介：</strong><br/>
                        微信公众号第三方平台开发，完成大部分的公众号接口（普通接口与高级接口）开发和其他用户需求<br/>框架：采用SpringMvc+Hibernate+Ibatis 整合框架，应用技术包括html
                        js jquery div+css xml 等<br/>项目成果：福州大学至诚学院公众号使用该平台（日粉丝增加1.2W左右），福州比利华整容医院公众号部分功能由本人开发。
                    </p>
                </div>

                <div class="project-experience">
                    <p>2015/01 -- 2015/02</p>
                    <h6>资源备份服务器平台</h6>

                    <div>
                        <p>
                            <strong>软件环境：</strong>JDK1.7
                        </p>

                        <p>
                            <strong>硬件环境：</strong>win7 64bit
                        </p>

                        <p>
                            <strong>开发工具：</strong>IDEA13.03
                        </p>
                    </div>
                    <p>
                        <strong>责任描述：</strong>
                        独立开发
                    </p>

                    <p>
                        <strong>项目简介：</strong><br/>
                        作为自动化测试平台的独立资源备份服务器，对自动化测试平台产生的资源文件进行分类管理和存储备份（主要是测试报告、安装包、自动化测试脚本等等以及一些其它资源文件）。
                    </p>
                </div>

                <div class="project-experience">
                    <p>2014/12 -- 2015/06</p>
                    <h6>网龙云测平台（门户平台）</h6>

                    <div>
                        <p>
                            <strong>软件环境：</strong>JDK1.7
                        </p>

                        <p>
                            <strong>硬件环境：</strong>win7
                        </p>

                        <p>
                            <strong>开发工具：</strong>Eclipse IDE
                        </p>
                    </div>
                    <p>
                        <strong>责任描述：</strong>
                        搭建系统框架，开发用户管理、权限管理、项目管理及前端框架；并整合自动化脚本生成模块
                    </p>

                    <p>
                        <strong>项目简介：</strong><br/>
                        门户平台提供给用户上传apk，并通过图形界面创建树状测试结构，生成自动化测试脚本，作为推送到自动化测试平台（测试流程平台）测试的原料。
                    </p>
                </div>

                <div class="project-experience">
                    <p>2014/11 -- 2015/07</p>
                    <h6>网龙自动化测试平台</h6>

                    <div>
                        <p>
                            <strong>软件环境：</strong>JDK 1.7
                        </p>

                        <p>
                            <strong>硬件环境：</strong>Win7 64
                        </p>

                        <p>
                            <strong>开发工具：</strong>IDEA 14.04
                        </p>
                    </div>
                    <p>
                        <strong>责任描述：</strong>
                        自动化流程管理服务器开发
                    </p>

                    <p>
                        <strong>项目简介：</strong><br/>
                        云平台自动化完成用户申请的移动应用测试的自动化测试平台。使用springMVC+Hibernate框架，并使用RESTFUL风格开发，与网龙共享平台交互，通过SVN同步资源和推送测试报告。
                    </p>
                </div>

                <div class="project-experience">
                    <p>2014/11 -- 2014/12</p>
                    <h6>UIAutomatorviewer测试脚本录制器</h6>

                    <div>
                        <p>
                            <strong>软件环境：</strong>JDK1.7
                        </p>

                        <p>
                            <strong>硬件环境：</strong>win7
                        </p>

                        <p>
                            <strong>开发工具：</strong>Eclipse
                        </p>
                    </div>
                    <p>
                        <strong>责任描述：</strong>
                        独立开发项目
                    </p>

                    <p>
                        <strong>项目简介：</strong><br/>
                        对Android SDK
                        工具包下的uiautomatorviewer工具进行二次开发，反编译源码，在原有的界面同步基础上增加PC操作同步到手机端的功能，并对操作进行转移，生成Python脚本，供测试人员录制自动化测试脚本
                    </p>
                </div>

                <div class="project-experience">
                    <p>2014/09 -- 2015/03</p>
                    <h6>轻量级企业官网速配系统</h6>

                    <div>
                        <p>
                            <strong>软件环境：</strong>JDK1.7,IDEA 13.03,Tomcat7
                        </p>

                        <p>
                            <strong>硬件环境：</strong>win7 64bit
                        </p>

                        <p>
                            <strong>开发工具：</strong>IDE13.03
                        </p>
                    </div>
                    <p>
                        <strong>责任描述：</strong>
                        独立开发
                    </p>

                    <p>
                        <strong>项目简介：</strong><br/>
                        模块化网页结构，提供门户平台模版，以及一个后台配置管理系统。企业可以在后台迅速搭建一个轻量级的企业官网。<br/>框架：SpringMvc+Hibernate<br/>数据库：Mysql<br/>旧版本被两个公司所用：飞迈软件科技（http://www.freemindsoft.com）
                        以及青藤科技<br/>新版本作为毕设项目，并发布在个人服务器上。
                    </p>
                </div>

                <div class="project-experience">
                    <p>2014/06 -- 2014/07</p>
                    <h6>个性化简历平台</h6>

                    <div>
                        <p>
                            <strong>软件环境：</strong>JDK1.7,IDEA 13.03,Tomcat7
                        </p>

                        <p>
                            <strong>硬件环境：</strong>win7 64bit
                        </p>

                        <p>
                            <strong>开发工具：</strong>IDEA13.03
                        </p>
                    </div>
                    <p>
                        <strong>责任描述：</strong>
                        独立开发
                    </p>

                    <p>
                        <strong>项目简介：</strong><br/>
                        采用特殊框架Horn+velocity +Ibatis框架（原公司内部框架）开发，快速创建个人简历，和个人时间轴履历，提供打印功能，个人简历来自于此。<br/>目前发布在个人服务器上:www.s-findme.com
                    </p>
                </div>

                <div class="project-experience">
                    <p>2013/12 -- 2015/06</p>
                    <h6>移动视讯客户端（远程同步教育）</h6>

                    <div style="display:none">
                        <p style="display:none">
                            <strong>软件环境：</strong>
                        </p>

                        <p style="display:none">
                            <strong>硬件环境：</strong>
                        </p>

                        <p style="display:none">
                            <strong>开发工具：</strong>
                        </p>
                    </div>
                    <p>
                        <strong>责任描述：</strong>
                        安卓客户端开发
                    </p>

                    <p>
                        <strong>项目简介：</strong><br/>
                        通过云服务器组件、PC教师端组件、安卓端组件实时音视频交互，实现远程教育的功能。
                    </p>
                </div>

            </dd>

            <dt>
            <h5>教育经历</h5></dt>

            <dd [%%show_edu%%]>
                <div class="education-background">
                    <p>2011/09-- 2015/07</p>
                    <h6>福建师范大学 <span class="ver-line">|</span> 软件工程专业 <span class="ver-line">|</span> 本科 </h6>
                </div>
            </dd>

            <dt>
            <h5>在校实践</h5></dt>

            <dd>

                <div class="social">
                    <p>2013/09 -- 2014/07</p>
                    <h6>2011级CDIO技术负责人 </h6>

                    <p>同届Java方向项目管理课程（共159人参与项目）项目技术负责人，负责项目框架搭建整合及技术指导与技术支持。<br/>项目分成四大系统：MIS、VosMap、LMS视讯平台、社交圈网站</p>
                </div>

            </dd>
            <dt>
            <h5>培训经历</h5></dt>
            <dd>

                <div class="training">
                    <p>2013/07--2014/05</p>
                    <h6>福州卓越职业技术培训学校</h6>

                    <p>

                    <div><strong>培训课程：</strong>android开发<br/></div>
                    <div><strong>所获证书：</strong>android开发工程师<br/></div>
                    <div><strong>培训地点：</strong>福州闽侯县博士后家园<br/></div>
                    <div style="display:none"><strong>培训描述：</strong></div>

                    </p>
                </div>

            </dd>
            <dt>
            <h5>获得证书</h5></dt>
            <dd>

                <div class="certificates">
                    <p>2014/05</p>
                    <h6>Java/Android工程师培训认证证书</h6>

                    <p style="display:none"></p>
                </div>

                <div class="certificates">
                    <p>2015/06</p>
                    <h6>国家级立项项目荣誉证书</h6>

                    <p style="display:none"></p>
                </div>

            </dd>
            <dt>
            <h5>语言能力</h5></dt>
            <dd>

                <div class="language-skill">
                    英语 <span>：读写能力一般 <span class="ver-line">|</span> 听说能力一般</span>
                </div>

            </dd>
            <dt>
            <h5>专业技能</h5></dt>
            <dd>

                <div class="professional-skill">
                    Eclipse\MyEclipse\IDEA等开发工具<span class="ver-line">|</span>熟练 <span class="ver-line">|</span> 24
                </div>

                <div class="professional-skill">
                    jstl、freemarker、velocity等技术<span class="ver-line">|</span>熟练 <span class="ver-line">|</span> 24
                </div>

                <div class="professional-skill">
                    JQuery<span class="ver-line">|</span>熟练 <span class="ver-line">|</span> 24
                </div>

                <div class="professional-skill">
                    RESTFUL风格开发<span class="ver-line">|</span>良好 <span class="ver-line">|</span> 6
                </div>

                <div class="professional-skill">
                    Ibatis<span class="ver-line">|</span>良好 <span class="ver-line">|</span> 12
                </div>

                <div class="professional-skill">
                    Hibernate<span class="ver-line">|</span>良好 <span class="ver-line">|</span> 12
                </div>

                <div class="professional-skill">
                    springMVC<span class="ver-line">|</span>熟练 <span class="ver-line">|</span> 12
                </div>

                <div class="professional-skill">
                    MYSQL/ORACLE/MSSQL<span class="ver-line">|</span>良好 <span class="ver-line">|</span> 36
                </div>

                <div class="professional-skill">
                    Tomcat、jetty服务器<span class="ver-line">|</span>熟练 <span class="ver-line">|</span> 24
                </div>

                <div class="professional-skill">
                    HTML/CSS/JAVASCRIPT<span class="ver-line">|</span>熟练 <span class="ver-line">|</span> 24
                </div>

            </dd>

            <dt>
            <h5>获得荣誉</h5></dt>
            <dd>
                <p>入网龙第一个月获得网龙“QA新星荣誉”</p>
            </dd>


            <dt block>
            <h5>图片附件</h5></dt>
            <dd block>

                <div class="photo-attach">
                    <img src="${pageContext.request.contextPath}/resources/images/wechat_mgr.png" alt="图片附件"/>

                    <p>微信后台管理系统</p>
                </div>

                <div class="photo-attach">
                    <img src="http://my.zhaopin.com/pic/2015/6/9/0538C775D305436182E382F826DDE468.jpg" alt="图片附件"
                         align="center"/>

                    <p>飞迈官网</p>
                </div>

            </dd>

            <dt style="display:none">
            <h5>附件简历</h5></dt>
            <dd style="display:none">
                <div class="photo-attach">
                    <a href=""></a>
                </div>
            </dd>

            <dt style="display:none">
            <h5>简历内容</h5></dt>
            <dd style="display:none">
                <div class="photo-attach">
                    <p></p>
                </div>
            </dd>
        </dl>
        <input type="hidden"
               value="AppId=1&Id=652531267&Timestamp=1447406844&Callback=&signature=1927953b236271558c65cacb9879a176"
               id="neturlparam"/>
    </div>

</div>
<script type="text/javascript">
    $(function () {
        $('dt').each(function (index, element) {
            $('dt:eq(' + index + ')').css("left", index * 8 + '%');
        })
    })
    $('dt').on('click', function () {
        var _this = $(this);
        $('dd').fadeOut("fast");
        _this.next().fadeIn("slow");
    })
</script>
<jsp:include page="tpl/footer/footer_default.jsp"></jsp:include>
</body>
</html>
