/**
 * 组件初始化
 */
$(function () {
    navInit();
    $('.fast-build-pop-title').find('span').click(function () {
        $(this).parent().parent().fadeOut("slow");
    })
    $('.fast-build-nav-sign').each(function () {
        if ($(this).find("span[class='clear']").length < 0) {
            $(this).append($("<span class='clear'></span>"));
        }
    })
    $('.fast-build-nav-sign ul li a span').each(function (index, element) {
        if ($(this).text() > 0) {
            $(this).fadeIn();
        }
        if ($(this).text() >= 99) {
            $(this).toggleClass("error");
            $(this).text("···");
        } else if ($(this).text() < 99 && $(this).text() >= 60) {
            $(this).toggleClass("danger");
        } else if ($(this).text() < 60 && $(this).text() >= 20) {
            $(this).toggleClass("success");
        } else if ($(this).text() == "" || $(this).text() == undefined || $(this).text() <= 0) {
            $(this).fadeOut("fast");
        }
    })

    $('.fast-build-nav-sign ul li a').each(function (index, element) {
        $(this).click(
            function () {
                $('.fast-build-nav-sign ul li a').removeClass("active");
                $('.fast-build-nav-sign ul li a:eq(' + index + ')').toggleClass("active");
            }
        );
    })
    //内容转换监听器
    $('*[render]').each(function (index, element) {
        var render = eval($(this).attr("render"));
        render(this, $(this).attr("status"));
    });


    //查询组件功能
    $('.search-box').each(function (index, element) {
        var selector = $(this).attr("ref");

        $(this).find("input[type='button']").click(function () {
            var val = $(".search-box:eq(" + index + ")").find("input[type='text']").val();
            $('.' + selector).each(function (index, element) {
                var str = $(this).text();
                if (str.indexOf(val) <= 0) {
                    $(this).fadeOut();
                }
            });
        });
    });
});

var resizeTimer = null;
$(window).resize(function () {
    if (resizeTimer) clearTimeout(resizeTimer);
    resizeTimer = setTimeout("navInit()", 500);
});

function navInit() {
    var width = window.innerWidth;
    var content = $('.fast-build-content');
    if (width <= 1280) {
        if (content.length > 0) {
            var content_position_left = content.first().offset().left;
            var content_top = content.first().offset().top;
            var content_width = content.first().width();
            var right_menu_position = content_position_left + content_width + 20;
            $('.fast-build-nav-right').attr("style", "left:" + right_menu_position + "px !important;top:" + content_top + "px;")
        }
    }
}

/**
 * 消息提示框
 * @param msg
 * @param func
 */
function tip(msg, func) {
    if ($('body').find('.fast-build-pop-msg').length > 0 || $('body').find('.fast-build-pop-win').css("display") == "block") {
        setTimeout(function () {
            $('.fast-build-pop-title').css("background", "#E08970");
        }, 300);
        setTimeout(function () {
            $('.fast-build-pop-title').css("background", "#D66B7B");
        }, 600);
        setTimeout(function () {
            $('.fast-build-pop-title').css("background", "#4D6F89");
        }, 900);
        return;
    }
    var pop = $("<div class='fast-build-pop-msg'>" +
        "<div class='fast-build-pop-title'>" +
        "<h2>消息提示</h2>" +
        "<span></span>" +
        "</div>" +
        "<p class='pop-msg-content'>" + msg + "</p>" +
        "<div class='fast-build-pop-submit'>" +
        "<input  type='button' value='确定'>" +
        "</div>" +
        "</div>");
    $(pop).find("input[type='button']").click(function () {
        $(pop).remove();
        if (typeof func == "function") {
            func();
        } else if (func == undefined || func == null) {
            //无效的回调
        }
    });
    $(pop).find("span").click(function () {
        $(pop).fadeOut("slow", function () {
            $(pop).remove();
        });
    });
    $('body').append($(pop));
    setTimeout(function () {
        $(pop).fadeIn("slow");
    }, 300);
}

/**
 * 弹出自定义pop窗口
 * @param id
 */
function pop(id) {
    if ($('body').find('.fast-build-pop-msg').length > 0 || $('body').find('.fast-build-pop-win').css("display") == "block") {
        setTimeout(function () {
            $('.fast-build-pop-title').css("background", "#E08970");
        }, 200);
        setTimeout(function () {
            $('.fast-build-pop-title').css("background", "#D66B7B");
        }, 400);
        setTimeout(function () {
            $('.fast-build-pop-title').css("background", "#4D6F89");
        }, 600);
        //窗口实例已经存在，提示，并返回
        return;
    }
    //弹出对应窗口
    $('#' + id).slideDown("slow");
}

/**
 * 获取contextPath
 * @returns {string}
 */
function getContextPath() {
    var location = (window.location + '').split('/');
    var basePath = location[0] + '//' + location[2] + '/' + location[3];
    return basePath;
}

/**
 * 上传文件(注意 ，当回调函数不为空时，上传文件成功不会弹窗提示)
 * @param fileInputId 文件选择空间ID
 * @param prviewElementId 预览文件ID（图片、视频、音乐等有效）
 * @param hideValueId 隐藏值ID
 * @param type 文件类型（imgae\music\video\file）
 */
function uploadFile(fileInputId, prviewElementId, hideValueId, type, callback) {
    var file = $("#" + fileInputId);
    var previewElement = $("#" + prviewElementId);
    var val = $("#" + hideValueId);
    if (file == null || file == undefined) {
        alert("文件选择元素ID无效！");
        return;
    }
    if (val == null && val == undefined) {
        alert("返回值存储元素ID无效！");
        return;
    }
    _l();
    $.ajaxFileUpload(
        {
            url: getContextPath() + '/common/fileUpload/' + type + '.htm',
            type: 'post',
            fileElementId: fileInputId,//input［type="file"］元素的id
            secureuri: false,
            async: false,
            success: function (data) {
                console.info("%o", data);
                //上传成功返回的信息｛filePath:上传文件后取得的url，result:是否成功，成功为true，失败为false｝
                if (data.result == true) {

                    if (previewElement != null && previewElement != undefined) {
                        if ("video" == type) {
                            previewElement.children().remove();
                            previewElement.append($("<video src='" + data.filePath[0] + "' style='max-heigh:240px;' controls='controls'>您的浏览器版本过低，请使用IE-9以上版本或谷歌、火狐等浏览器</video>"));
                        } else if ('image' == type) {
                            previewElement.attr("src", data.filePath[0]);
                        }
                    }
                    if (val != null && val != undefined) {
                        val.val(data.filePath);
                    }

                } else {
                    alert(data.errorMsg);
                }
                _l();
                if (typeof callback == "function") {
                    callback();
                } else {
                    $('.fast-build-pop-win').fadeOut("fast", function () {
                        tip("文件上传成功！");
                    });
                }
            },
            error: function (data, status, e) {
                alert("上传失败:" + e);
                _l();
            }
        }
    )
}

/**
 * 加载动画
 */
var loading = null;
function _l() {
    if (loading == null) {
        loading = $("<div style='position: fixed;width: 100%;height:100%;top: 0;left: 0;z-index: 99999;background: #dddddd;opacity: 0.6;' ><img src='" + getContextPath() + "/resources/images/loading.gif' style='width:60px;display:block;margin:0 auto;margin-top:15%;'><p style='text-align: center;display: block;font-size: 14px;color: #008200;'>正在上传文件，请稍后...</p></div>")
        $("body").append(loading);
    }
    else {
        loading.remove();
        loading = null;
    }
}

/**快速请求组件**/
var DATA_TYPE_JSON = "1";
var DATA_TYPE_XML = "2";
var DATA_TYPE_IMG = "3";
var DATA_TYPE_APK = "4";
var DATA_TYPE_FILE = "5";
jQuery.each(["FastGet", "FastPost"], function (index, method) {
    //data:请求参数，会一并放入requestHeader中
    //url:请求连接
    //callback：回调函数
    //type:数据类型
    jQuery[method] = function (url, data, callback, type) {
        if (type == null || type == undefined || type == "") {
            alert("error data type equal null");
            return;
        }
        return jQuery.ajax({
            async: false,
            url: url,
            type: (method == "FastGet" ? "get" : "post"),
            dataType: type,
            beforeSend: function (request) {
                for (var a in data) {
                    request.setRequestHeader(a, data[a]);
                }
                switch (type.toUpperCase()) {
                    case "JSON" || "json":
                        request.setRequestHeader("dataType", DATA_TYPE_JSON);
                        break;
                    case "XML" || "xml":
                        request.setRequestHeader("dataType", DATA_TYPE_XML);
                        requestFile(url, data);
                        this.abort();
                        break;
                    case "IMG" || "img":
                        request.setRequestHeader("dataType", DATA_TYPE_IMG);
                        requestFile(url, data);
                        this.abort();
                        break;
                    case "APK" || "apk":
                        request.setRequestHeader("dataType", DATA_TYPE_APK);
                        requestFile(url, data);
                        this.abort();
                        break;
                    case "FILE" || "file":
                        request.setRequestHeader("dataType", DATA_TYPE_FILE);
                        requestFile(url, data);
                        this.abort();
                        break;
                    default :
                        alert("error data type：" + type);
                        this.abort();
                }

            },
            data: data,
            success: function (data, status, e) {
                callback(data);
            }
        });

        //不跳转页面的文件下载
        function requestFile(url, data) {
            var form = $("<form>");//定义一个form表单
            form.attr("style", "display:none");
            form.attr("target", "");
            form.attr("method", "post");
            form.attr("action", url);
            for (var d in data) {
                var input = $("<input>");
                input.attr("type", "hidden");
                input.attr("name", d);
                input.val(data[d]);
                form.append(input);
            }
            var input1 = $("<input>");
            input1.attr("type", "hidden");
            input1.attr("name", "file");
            input1.attr("value", (new Date()).getMilliseconds());
            $("body").append(form);//将表单放置在web中
            form.append(input1);
            form.submit();
        }
    }
});

function log(url, data) {
    if (console) {
        console.debug("FastBuild Ext:debug \r\n Request URL: %o \r\n Response Data: %o", url, data)
    }
};

function logParam(functionName, param) {
    if (console) {
        console.debug("FastBuild Ext:debug \r\n Func Parameters : {}", param);
    }
}