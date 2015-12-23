package com.nfb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

/**
 * @修改人：邓风森
 * @修改时间： 2015/4/9 11:29.
 */
public abstract class BaseController {
    @Autowired
    HttpSession session;

    public void success(ModelMap modelMap) {
        modelMap.put("result", Boolean.valueOf(true));
    }

    public void failed(ModelMap modelMap) {
        modelMap.put("result", Boolean.valueOf(false));
        modelMap.put("errorMsg", "服务器发生未知错误，请求失败!");
    }

    public void failed(ModelMap modelMap, Exception e) {
        modelMap.put("result", Boolean.valueOf(false));
        modelMap.put("errorMsg", e.getMessage());
    }

    public void failed(ModelMap modelMap, String errorMsg) {
        modelMap.put("result", Boolean.valueOf(false));
        modelMap.put("errorMsg", errorMsg);
    }
}
