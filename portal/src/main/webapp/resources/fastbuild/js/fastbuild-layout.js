// ;document.write("<script language=javascript src='http://code.jquery.com/jquery-1.11.3.min.js'></script>")
;
(function ($, window, document, undefined) {
    //定义layout的构造函数
    var layout = function (opt) {
        this.defaults = {
            'render_id': null, /** 根容器ID **/
            'border_color': '#dddddd', /** 布局边框颜色 **/
            'panels_weights': [2, 5], /** 布局划分比例 根据子容器的个数来填写，
             会将win_width 按照此比例划分给自容器
             **/
            'action_class': '.item', /**布局中用以弹出下一个布局的响应元素，允许请求动态数据，
             标记特殊属性[data-ref](与特殊属性[data-id]对应，两者值相同，则指向[data-id]所对应的容器)
             和[data-url]
             **/
            'align': 'horizontal', /** 布局方案，横向布局划分 与 纵向布局划分
             值分别为 horizontal 、 vertical
             **/
            'win_width': window.document.body.offsetWidth, /**窗口高度 默认为浏览器可见区域宽度，无需修改**/
            'panel_css': {
                'display': 'block',
                'position': 'absolute',
                'top': '0',
                'height': '100%',
                'left': '0',
                'background': '#ffffff',
                'border-left': '1px solid #dddddd',
                'overflow': 'hidden',
                'overflow-y': 'auto'
            }, /** 布局子容器的样式，默认无需修改 **/
            'root_css': {
                'position': 'relative',
                'min-height': '480px',
                'height': (window.document.body.clientHeight - 69 - 45),
                'background': '#efefef',
                'overflow-x': 'hidden'
            } /** 根容器的样式，默认无需修改 **/
        },
            this.options = $.extend({}, this.defaults, opt);
    }
    //定义layout的方法
    layout.prototype = {
        constructor: function () {
            if (this.options.align == 'horizontal') {
                this.hz_init();
            } else if (this.options.align == 'vertical') {
                this.vt_init();
            } else {
                tip('options error ! unknown align method:' + this.options.align);
            }
        },
        hz_init: function () {
            if (this.options.render_id == null) {
                return;
            }
            var c = $(this.options.render_id);
            if (c == undefined || c == null || c.length <= 0) {
                return;
            }
            var childs = c.children();
            var ci = 0;
            var w_count = this.getWeightCount(this.options.panels_weights);
            //设置容器样式
            $(this.options.render_id).css(this.options.root_css);
            //初始化子区域大小
            while (ci < childs.length) {
                $(childs[ci]).css(this.options.panel_css);
                $(childs[ci]).css('width', (this.options.panels_weights[ci] / w_count) * this.options.win_width);
                if (ci > 0)
                    $(childs[ci]).css({
                        'left': this.getAutoLeft(childs, ci) + 80,
                        'opacity': '0'
                        // 'display':'none'
                    });
                // $(child).text(ci);
                ci++;
            }
            //添加响应监听
            this.hzActionListener();

        },
        vl_init: function () {
            //console.debug('vl_init() loaded!');
        },
        getAutoLeft: function (elements, index) {
            var countWidth = 0;
            var count = 0;
            while (count < index) {
                countWidth += $(elements[count]).width();
                count++;
                if (count == index) {
                    break;
                }
            }
            return countWidth;
        },
        getWeightCount: function (p_weights) {
            var count = 0;
            var site = 0;
            while (site < p_weights.length) {
                count += p_weights[site];
                site++;
            }
            return count;
        },
        hzActionListener: function () {
            $(this.options.action_class).off("click");
            $(this.options.action_class).on("click", function () {
                var url = $(this).parent().attr("data-url");//数据请求地址
                var ref = $(this).parent().attr('data-ref');//目标ID
                var selfRoot = ly.getLayoutPanel($(this));//当前元素所在容器
                var next = $('[data-id =' + ref + ']').parent();//下一个容器
                //隐藏子页面
                next.children().hide();
                //显示对应的页面
                if (next.css('display') != 'none') {
                    var left = selfRoot.position().left + selfRoot.width() + 80;
                    next.animate({
                        'left': left,
                        'opacity': '0'
                    }, 300);
                    selfRoot.nextAll().fadeOut(300);
                }
                ;
                var left = selfRoot.position().left + selfRoot.width();
                next.animate({
                    'left': left,
                    'opacity': '100'
                }, 500);
                if (url != undefined && url != "") {
                    var data = requestData(url);
                    if (data == null || data == undefined) {
                        //数据请求为空 则 阻塞ui的更新
                        return;
                    }
                    serializationJsonAndAutowireData(data, ref);
                    if (selfRoot.next() != undefined) {
                        selfRoot.next().fadeIn('normal', function () {
                            $('[data-id = ' + ref + ']').show();
                        });
                    }
                }


            });
        },
        getLayoutPanel: function (element) {
            var parent = element.parent();
            while (typeof(parent.attr("layout-id")) == "undefined") {
                parent = parent.parent();
                if (parent.localName == "body") {
                    parent = undefined;
                    break;
                }
            }
            return parent;
        }
    };

    /**
     * ajax请求数据，post，非异步
     * @param url 请求地址
     * @returns {*}
     */
    function requestData(url) {
        var d = null;
        if (url == "" || url == undefined) {
            tip('request failed,bad url :' + url);
            return;
        }
        $.ajax({
            url: url,
            async: false,
            dataType: 'json',
            type: 'POST',
            data: {},
            success: function (data) {
                data = $.evalJSON(data);
                log(url, data);
                if (data.result == true) {
                    d = data.data;
                    if (d == undefined || d == null || d.length <= 0) {
                        tip('请求数据成功，但数据为空!');
                    }
                } else {
                    tip('请求数据失败:' + data.errorMsg);
                }
            },
            error: function (request, status, e) {
                tip('请求(' + getContextPath() + url + ')发生错误：' + e);
            }
        });
        return d;
    };
    /**
     * 序列化数据，并注入ui中
     * @param dataArray 数据列表
     * @param tpl 数据ui模版
     * @param panelId 容器ID
     */
    function serializationJsonAndAutowireData(dataArray, panelId) {
        logParam("Layout Ext:serializationJsonAndAutowireData", {"dataArray": dataArray, "panelId": panelId});
        $('*[data-id = ' + panelId + '] *[data-tpl="false"]').remove();
        var tpl = $("[data-id=" + panelId + "]").find('[data-tpl="true"]').parent().html();
        var root = $("[data-id=" + panelId + "]").find('[data-tpl="true"]').parent();
        var count = 0;
        if (Object.prototype.toString.call(dataArray) === '[object Array]') {
            while (count < dataArray.length) {
                var e = $(tpl);
                var tag = e.attr("data-url");
                if (dataArray[count][tag]) {
                    e.attr("data-url", dataArray[count][tag]);
                } else {
                    e.removeAttr("data-url");
                }
                for (var p in dataArray[count]) {

                    var element = e.find('[name=' + p + ']');
                    if (element[0] != undefined) {
                        //根据标签类型注入内容，a、img标签 注入属性，p，h等注入文本，特殊字段
                        if (element[0].localName == "a") {
                            element.attr("href", p);
                        } else if (element[0].localName == "img") {
                            element.attr("src", p);
                        } else {
                            element.text(dataArray[count][p]);
                        }
                    }
                    e.attr("data-tpl", 'false');
                }
                root.append(e);
                count++;
            }
        } else if (Object.prototype.toString.call(dataArray) === '[object Object]') {
            var e = $(tpl);
            var tag = e.attr("data-url");
            for (var p in dataArray) {
                if (dataArray[tag]) {
                    //console.info("set tpl attr %o ,value %o",e.attr("data-url") , dataArray[tag]);
                    e.attr("data-url", dataArray[tag]);
                } else {
                    e.removeAttr("data-url");
                }
                var element = e.find('[name=' + p + ']');
                if (element != undefined) {
                    //根据标签类型注入内容，a标签 注入属性，p，h等注入文本，特殊字段
                    if (element.is('a')) {
                        element.attr("href", dataArray[p]);
                    } else if (element.is('img')) {
                        element.attr("src", dataArray[p]);
                    } else if (element.is('div')) {
                        element.html(dataArray[p]);
                    } else if (element.is('input')) {
                        if (element.attr("type") == "text" || element.attr("type") == "password") {
                            element.val(dataArray[p]);
                        } else {
                            element.text(dataArray[p]);
                        }
                    } else {
                        element.text(dataArray[p]);
                    }
                }
                e.attr("data-tpl", 'false');
            }
            root.append(e);
        }
        ly.hzActionListener();
    };
    var ly = null;
    //在插件中使用layout对象
    $.fn.buildPlugin = function (options) {
        logParam("Layout Ext:constructor", options)
        //创建layout的实体
        ly = new layout(options);
        //调用其方法
        return ly.constructor();
    }
})(jQuery, window, document);
