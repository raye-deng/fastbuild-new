package com.nfb.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nfb.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Administrator on 2015/4/28.
 */
public class RequestUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestUtils.class);
    //每个post参数之间的分隔
    static final String BOUNDARY = "----new-fb-boundary";

    /**
     * http 模拟 form表单提交数据和文件
     *
     * @param requestUrl
     * @param strParams
     * @param fileParams
     * @return
     * @throws java.io.IOException
     */
    public static JSONObject httpFormRequest(String requestUrl, List<String[]> strParams, List<String[]> fileParams) throws Exception {
        HttpURLConnection hc = null;  //http连接器
        ByteArrayOutputStream bos = null;//byte输出流，用来读取服务器返回的信息
        InputStream is = null;//输入流，用来读取服务器返回的信息
        byte[] res = null;//保存服务器返回的信息的byte数组
        URL url = new URL(requestUrl);
        hc = (HttpURLConnection) url.openConnection();

        hc.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
        hc.setRequestProperty("Charsert", "UTF-8");
        // 发送POST请求必须设置如下两行
        hc.setDoOutput(true);
        hc.setDoInput(true);
        hc.setUseCaches(false);
        hc.setRequestMethod("POST");

        OutputStream dout = hc.getOutputStream();

        ////1.先写文字形式的post流
        //头
        String boundary = BOUNDARY;
        //中
        StringBuffer resSB = new StringBuffer("\r\n");
        //尾
        String endBoundary = "\r\n--" + boundary + "--\r\n";
        //strParams 1:key 2:value
        if (strParams != null) {
            for (String[] param : strParams) {
                String key = param[0];
                String value = param[1];
                resSB.append("Content-Disposition: form-data; name=\"description").append("\"").append("\r\n")
                        .append("\r\n").append(key + "=\"").append(value).append("\"\r\n").append("--").append(boundary).append("\r\n").append("\r\n");
            }
        }
        String boundaryMessage = resSB.toString();
        //写出流
        dout.write(("--" + boundary + boundaryMessage).getBytes("utf-8"));
        resSB = new StringBuffer();
        if (fileParams != null) {
            for (int i = 0, num = fileParams.size(); i < num; i++) {
                String[] param = fileParams.get(i);
                String fileField = param[0];
                String fileName = param[1];
                String fileType = param[2];
                String filePath = param[3];
                resSB.append("Content-Disposition: form-data; name=\"").append(fileField + "\"").append("filename=\"").append(
                        fileName + "\"").append("\r\n").append("Content-Type: ").append(fileType).append("\r\n\r\n");
                dout.write(resSB.toString().getBytes("utf-8"));
                //开始写文件
                File file = new File(filePath);
                if (!file.exists()) {
                    throw new BizException("文件未找到，上传素材失败！");
                }
                DataInputStream in = new DataInputStream(new FileInputStream(file));
                int bytes;
                byte[] bufferOut = new byte[1024 * 5];
                while ((bytes = in.read(bufferOut)) != -1) {
                    dout.write(bufferOut, 0, bytes);
                }
            }
        }
        dout.write(endBoundary.getBytes("utf-8"));
        dout.close();
        int ch;
        is = hc.getInputStream();
        bos = new ByteArrayOutputStream();
        while ((ch = is.read()) != -1) {
            bos.write(ch);
        }
        res = bos.toByteArray();

        if (bos != null)
            bos.close();
        if (is != null)
            is.close();
        String result = new String(res);
        return JSON.parseObject(result);
    }


    /**
     * @param targetUrl 目标链接
     * @param params    参数
     * @return
     */
    public static String httpRequest(String targetUrl, String... params) throws Exception {
        String tempStr = null;
        HttpURLConnection url_con = null;
        try {
            URL url = new URL(targetUrl);
            StringBuffer bankXmlBuffer = new StringBuffer();
            //创建URL连接，提交到数据，获取返回结果
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("User-Agent", "micromessenger");
            connection.setRequestProperty("devices", "iphone");
            PrintWriter out = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
            if (params != null && params.length > 0) {
                for (String p : params) {
                    out.println(p);
                }
            }
            out.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                bankXmlBuffer.append(inputLine);
            }
            in.close();
            tempStr = bankXmlBuffer.toString();
        } catch (Exception e) {
            if (url_con != null)
                url_con.disconnect();
            throw e;
        } finally {
            if (url_con != null)
                url_con.disconnect();
        }
        return tempStr;
    }

    /**
     * 请求文件
     * @param targetUrl
     * @param savePath
     * @param params
     * @throws Exception
     */
    public static void httpRequestFile(String targetUrl, String savePath, String... params) throws Exception {
        HttpURLConnection url_con = null;
        URL url = new URL(targetUrl);
        //创建URL连接，提交到数据，获取返回结果
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("User-Agent", "micromessenger");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
        if (params != null && params.length > 0) {
            for (String p : params) {
                out.println(p);
            }
        }
        out.close();
        DataInputStream in = new DataInputStream(connection.getInputStream());
        byte[] nal = new byte[1024];
        int len = 0;
        FileOutputStream fos = new FileOutputStream(savePath);
        while ((len = in.read(nal)) != -1) {
            fos.write(nal, 0, len);
        }
        in.close();
        fos.close();
        if (url_con != null)
            url_con.disconnect();
    }

}
