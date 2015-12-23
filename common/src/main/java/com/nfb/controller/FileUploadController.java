package com.nfb.controller;

import com.alibaba.fastjson.JSON;
import com.nfb.exception.BizException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/8/6 0006.
 */
@Controller
public class FileUploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    Log log = LogFactory.getLog(FileUploadController.class);
    private static int MAX_UPLOAD_SIZE = 1024 * 1024 * 1024;
    private static String SAVE_PATH = "Images";
    private static String uploadPath = "/resources/upload";

    /**
     * 文件上传方法
     *
     * @param request
     */
    @RequestMapping(value = "/common/fileUpload/{fileType}")
    public void fileUpload(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap,
                           @PathVariable(value = "fileType") String fileType) throws IOException, BizException {
//        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = null;
        if (fileType != null && "".equals(fileType) == false) {
            SAVE_PATH = fileType;
        }
        try {
            out = response.getWriter();
            Map params = new HashMap();
            FileItem fileItem = null;
            String absolutePath;
            String fileUri;

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(MAX_UPLOAD_SIZE);
            List<FileItem> items = upload.parseRequest(request);
            if (items.size() <= 0) {
                throw new BizException("未找到要上传的文件，请选择文件");
            }
            for (FileItem item : items) {
                if (item.isFormField()) {
                    //普通文本类型
                    params.put(item.getFieldName(), item.getString());
                } else {
                    //文件类型
                    fileItem = item;
                }
            }
            //放在循环之外，只获取最后一个文件
            if (fileItem == null) {
                throw new BizException("未找到要上传的文件");
            } else {
                //获取文件名
                String originalName = fileItem.getName();
                //根据时间生成新的随机文件名
                String fileName = getSaveFileName(originalName);
                //存储路径，默认为Images
                String savePath = SAVE_PATH + "/";
                //获取存储文件夹的绝对路径，不存在就创建一个新的文件夹
                String realPath = getFolder(request, savePath);
                //返回路径：返回一个全局的路径
                absolutePath = realPath + "/" + fileName;
                //文件存储的相对路径
                fileUri = uploadPath + "/" + SAVE_PATH + "/" + fileName;
                String fullPath = fullPathBuilder(fileUri, request, response);
                //写出文件到硬盘
                fileItem.write(new File(absolutePath));
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("file save absolute path : {}", absolutePath);
                }

                modelMap.put("result", Boolean.valueOf(true));
                modelMap.put("url", fullPath);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error("occur error in file upload : {}", ex.getMessage());
            modelMap.put("result", Boolean.valueOf(false));
            modelMap.put("errorMsg", ex.getMessage());
        }
        String rStr = JSON.toJSONString(modelMap);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("upload file success , file information:{}", rStr);
        }
        out.write(rStr);
        out.flush();
        out.close();
    }

    /**
     * 获取文件的http完整链接
     *
     * @param saveUri
     * @param request
     * @param response
     * @return
     */
    private String fullPathBuilder(String saveUri, HttpServletRequest request, HttpServletResponse response) {
        String contextPath = request.getContextPath();

        StringBuffer buffer = new StringBuffer();
        buffer.append(request.getScheme()).append("://").append(request.getServerName()).append(":")
                .append(request.getServerPort()).append(contextPath).append(saveUri);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("file save full path before encode :{}", buffer.toString());
        }
        return response.encodeURL(buffer.toString());
    }

    /**
     * 依据原始文件名生成新文件名
     *
     * @return
     */
    private String getSaveFileName(String fileName) {

        return System.currentTimeMillis() + this.getFileExt(fileName);
    }

    /**
     * 根据字符串创建本地目录 并建立子目录返回
     *
     * @param path
     * @return
     */
    private String getFolder(HttpServletRequest request, String path) {
        File dir = new File(this.getPhysicalPath(request, path));
        if (!dir.exists()) {
            try {
                dir.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return dir.getAbsolutePath();
    }

    /**
     * 根据传入的虚拟路径获取物理路径
     *
     * @param path
     * @return
     */
    private String getPhysicalPath(HttpServletRequest request, String path) {
        String realPath = this.uploadPath;
        if (this.uploadPath == null || this.uploadPath.startsWith("/"))
            realPath = request.getSession().getServletContext().getRealPath(this.uploadPath);
        return realPath + "/" + path;
    }

    /**
     * 获取文件扩展名
     *
     * @return string
     */
    private String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
}
