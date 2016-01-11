(function ($, window, document, undefined) {
    var selector = function (opts) {
        this.default_options = {
            render: '.mult-selector', //指定选择器
            showAll: true, //显示全部选项
            inline: true,   //选择器显示为行内元素
            dataMaps: [{'name': 'admin', 'id': '0'}, {'name': 'users', 'id': '1'}, {'name': 'tester', 'id': '2'}],
            boxStyle: {
                'position': 'absolute',
                'height': '120px',
                'min-width': '140px',
                'display': 'none',
                'overflow-y': 'auto',
                'overflow-x': 'hidden',
                'background': '#ffffff',
                'border': '1px solid #ddd',
                'border-radius': '3px',
                'padding': '5px 0 0 10px',
                'text-indent': '1em',
                'z-index': '999'
            },
            itemStyle: {
                'list-tyle': 'none',
                'display': 'block',
                'font-size': '16px',
                'font-size': '1.6rem',
                'color': '#666'
            },
            showFlag: true
        };
        this.option = $.extend({}, this.default_options, opts);
    }

    selector.prototype = {
        contruct: function () {
            this.initialList();
            this.addEvent();
        },
        getSelfPosition: function () {
            var ps = $(this.option.render).find('input[type="text"]').offset();
            var point = {x: ps.left, y: ps.top + 22};
            if (console) {
                console.log("get input position success! position:%o", ps);
            }
            return point;
        },
        initialList: function () {
            var box = $('<div class="select-box"></div>');
            var list = $('<ul class="select-item-list"></ul>');
            if (this.option.showAll === true) {
                var all = $('<li><div  class="select-item-box"><input type="checkbox" value="000">全部</div></li>');
                list.append(all);
            }
            for (var item in this.option.dataMaps) {
                var name = this.option.dataMaps[item]['name'];
                var id = this.option.dataMaps[item]['id'];
                var li = $('<li><div  class="select-item-box"><input type="checkbox" value="' + id + '" >' + name + ' </div></li>');
                list.append(li);
            }
            if (this.option.inline) {
                $(this.option.render).css("display", 'inline');
            }
            this.option.boxStyle.top = this.getSelfPosition().y + "px";
            this.option.boxStyle.left = this.getSelfPosition().x + "px";
            this.option.boxStyle.width = ($(this.option.render).find('input[type="text"]').width() - 10) + "px";
            //$(this.option.render).css("position", 'relative');
            box.css(this.option.boxStyle);
            box.append(list);
            $(this.option.render).append(box);
            list.find('li').css(this.option.itemStyle);
            if (console) {
                console.log("initial mult selector list finish.... dataMaps:%o", this.option.dataMaps);
            }
        },
        addEvent: function () {
            var _th = this;
            $(_th.option.render).find('input[type="text"]').click(function () {
                if (_th.option.showFlag === true) {
                    $(_th.option.render).find('.select-box').slideUp(300, function () {
                        _th.option.showFlag = false;
                    });
                } else {
                    $(_th.option.render).find('.select-box').slideDown(300, function () {
                        _th.option.showFlag = true;
                    })
                }
            });
            $(_th.option.render).find('.select-item-list li input').click(function () {
                var checkedVal = _th.getSelectVal();
                if ($(this).val() == "000") {
                    if ($(this).checked == true) {
                        $(_th.option.render).find('.select-item-list li input').checked = true;
                    } else {
                        $(_th.option.render).find('.select-item-list li input').checked = false;
                    }
                }
                $(_th.option.render).find('input[type="text"]').val(checkedVal.names);
                $(_th.option.render).find('input[type="hidden"]').val(checkedVal.vals);
                console.log('current checked item : ', checkedVal.vals);
            });

            if (console) {
                console.log("initial mult selector event listener finish...");
            }

        },
        getSelectVal: function () {
            var vals = new String();
            var names = new String();
            $(this.option.render).find('.select-item-list li input[type="checkbox"]:checked').each(function () {
                if (vals.length > 0) {
                    names = names.concat(",");
                    vals = vals.concat(",");
                }
                vals = vals.concat($(this).val());
                names = names.concat($(this).parent().text());
            });
            //选择了全部
            if (vals.indexOf("000") != -1) {
                vals = "000";
                names = "全部";
            }
            var obj = {
                names: names,
                vals: vals
            }
            if (console) {
                console.log("build values and names:%o", obj);
            }
            return obj;
        }
    };


    var multSelector = undefined;
    $.fn.buildMultSelector = function (options) {
        multSelector = new selector(options);
        multSelector.contruct();
        if (console) {
            console.log('build mulselect plugin, options:%o', options);
        }
        return multSelector;
    }
})(jQuery, window, document);