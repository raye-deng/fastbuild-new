package com.nfb.utils;

import com.nfb.entity.Article;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名：com.fastbuild.web.cache.WebCacheUtils
 * 创建者： 邓风森 .
 * 创建时间：2015/11/13
 */
public final class WebCacheUtils {
    private static Logger logger = LoggerFactory.getLogger(WebCacheUtils.class);

    public static List csdnArticleListParse(String url, String encoded) throws Exception {
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        Parser parser = new Parser((HttpURLConnection) connection);
        HasAttributeFilter filter = new HasAttributeFilter("class", "list_item article_item");
        NodeList nodeList = parser.extractAllNodesThatMatch(filter);
        if (nodeList.size() > 0) {
            List articles = new ArrayList();
            for (int i = 1; i < nodeList.size(); i++) {
                String title = Parser.createParser(nodeList.elementAt(i).toHtml(), encoded).
                        extractAllNodesThatMatch(new HasAttributeFilter("class", "link_title"))
                        .elementAt(0).getFirstChild().getFirstChild().getText().trim();
                String link = connection.getURL().getProtocol() + "://" + connection.getURL().getHost() + ((LinkTag) Parser.createParser(nodeList.elementAt(i).toHtml(), encoded).
                        extractAllNodesThatMatch(new HasAttributeFilter("class", "link_title"))
                        .elementAt(0).getFirstChild()).getLink().trim();
                String description = ((Div) Parser.createParser(nodeList.elementAt(i).toHtml(), encoded).
                        extractAllNodesThatMatch(new HasAttributeFilter("class", "article_description"))
                        .elementAt(0)).toHtml();
                description = description.substring(description.indexOf(">", 0) + 1, description.indexOf("<", 1)).trim();
                String createTime = (Parser.createParser(nodeList.elementAt(i).toHtml(), encoded).
                        extractAllNodesThatMatch(new HasAttributeFilter("class", "link_postdate"))
                        .elementAt(0)).toHtml();
                createTime = createTime.substring(createTime.indexOf(">", 0) + 1, createTime.indexOf("<", 1)).trim();
                String viewCount = (Parser.createParser(nodeList.elementAt(i).toHtml(), encoded).
                        extractAllNodesThatMatch(new HasAttributeFilter("class", "link_view"))
                        .elementAt(0)).toHtml();
                viewCount = viewCount.substring(viewCount.lastIndexOf("(") + 1, viewCount.lastIndexOf(")"));
                String commentCount = (Parser.createParser(nodeList.elementAt(i).toHtml(), encoded).
                        extractAllNodesThatMatch(new HasAttributeFilter("class", "link_comments"))
                        .elementAt(0)).toHtml();
                commentCount = commentCount.substring(commentCount.lastIndexOf("(") + 1, commentCount.lastIndexOf(")"));
                Article article = new Article();
                article.setTitle(title);
                article.setCommentCount(commentCount);
                article.setCreateTime(createTime);
                article.setDetail(description);
                article.setUrl(link);
                article.setId(link.substring(link.lastIndexOf("/")).replace("/", ""));
                article.setViewCount(viewCount);
                articles.add(article);
            }
            return articles;
        } else {
            return null;
        }
    }

    public static String csdnArticleDetailParse(String url, String encode, String filter) throws Exception {
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        Parser parser = new Parser((HttpURLConnection) connection);
        HasAttributeFilter baseFilter = new HasAttributeFilter("class", filter);
        NodeList nodeList = parser.extractAllNodesThatMatch(baseFilter);
        return nodeList.toHtml();
    }

    public static String zhilianPersonInfoCache(String url, String encoded) throws Exception {
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        Parser parser = new Parser((HttpURLConnection) connection);
        NodeList nodeList = parser.parse(null);
        return nodeList.toHtml();
    }

    public static void main(String[] args) {
        try {
//            csdnArticleListParse("http://blog.csdn.net/MrEmotion/article/list/2", "UTF-8");
            String content = csdnArticleDetailParse("http://blog.csdn.net/mremotion/article/details/49863813", "UTF-8", "article_content");
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
