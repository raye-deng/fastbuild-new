package com.nfb.controller;

import com.alibaba.fastjson.JSON;
import com.nfb.entity.SimpleArticleEntity;
import com.nfb.service.PageService;
import com.nfb.utils.WebCacheUtils;
import com.nfb.web.MediaTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/8/4.
 */
@Controller
public class FBCtl extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FBCtl.class);
    @Autowired
    PageService pageService;

    @RequestMapping(value = "example")
    public void example(HttpServletRequest request, ModelMap modelMap) {

    }


    @RequestMapping(value = "main")
    public void main(HttpServletRequest request, ModelMap modelMap) throws Exception {
        List articles = WebCacheUtils.csdnArticleListParse("http://blog.csdn.net/MrEmotion/article/list/1", "UTF-8");
        List articles2 = WebCacheUtils.csdnArticleListParse("http://blog.csdn.net/MrEmotion/article/list/2", "UTF-8");
        articles.addAll(articles2);
        modelMap.put("articles", articles);
    }

    @RequestMapping(value = "/example/layout")
    public void layout(HttpServletRequest request, ModelMap modelMap) {

    }

    @RequestMapping(value = "/about")
    public void about(HttpServletRequest request, ModelMap modelMap) {

    }

    @ResponseBody
    @RequestMapping(value = "/page/article/{id}", method = RequestMethod.POST, produces = MediaTypes.JSON_UTF_8)
    public String list(HttpServletRequest request, ModelMap modelMap, Map param, @PathVariable Integer id) {
        try {
            param.put("pageId", id);
            List articles = pageService.getSimpleArticleByPage(param);
            modelMap.put("data", articles);
            modelMap.put("result", Boolean.valueOf(true));
        } catch (SQLException e) {
            modelMap.put("errorMsg", "服务器发生错误，错误信息(" + e.getMessage() + ")");
            modelMap.put("result", Boolean.valueOf(false));
            LOGGER.error("OccurError", e);
        }
        return JSON.toJSONString(modelMap);
    }

    @RequestMapping("/page/article/details/{id}")
    public String detail(HttpServletRequest request, ModelMap modelMap, @PathVariable Integer id) throws Exception {
        String content = WebCacheUtils.csdnArticleDetailParse("http://blog.csdn.net/mremotion/article/details/" + id, "UTF-8", "article_content");
        String title = WebCacheUtils.csdnArticleDetailParse("http://blog.csdn.net/mremotion/article/details/" + id, "UTF-8", "link_title");
        title = title.replace("</a></span>", "");
        title = title.substring(title.lastIndexOf(">") + 1);
        modelMap.put("content", content);
        modelMap.put("title", title);
        return "/article";
    }

    @ResponseBody
    @RequestMapping(value = "/article/detail/{id}", method = RequestMethod.POST, produces = MediaTypes.JSON_UTF_8)
    public String dataById(HttpServletRequest request, ModelMap modelMap, Map param, @PathVariable Integer id) {
        try {
            param.put("articleId", id);
            SimpleArticleEntity article = pageService.getSimpleArticleById(param);
            modelMap.put("data", article);
            modelMap.put("result", Boolean.valueOf(true));
        } catch (SQLException e) {
            modelMap.put("errorMsg", "服务器发生错误，错误信息:" + e.getMessage());
            modelMap.put("result", Boolean.valueOf(false));
            LOGGER.error("OccurError", e);
        }
        return JSON.toJSONString(modelMap);
    }
}
