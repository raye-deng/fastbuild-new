package com.nfb.utils;


import com.nfb.exception.BizException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2015/4/28.
 */
public final class PropertiesUtils {
    static Properties prop;

    public static String getProperty(String fileName, String key) throws Exception {
        prop = new Properties();
        File file = new File(PropertiesUtils.class.getClassLoader().getResource("/").getPath() + "/config.properties");
        if (!file.exists()) {
            throw new BizException("配置文件" + Object.class.getClassLoader().getResource("/").getPath() + "/config.properties" + "未找到，读取配置失败！");
        }
        InputStream in = new FileInputStream(file.getPath());
        prop.load(in);
        return prop.getProperty(key);
    }

    public static String getProperty(String fileName, String key, String defaultValue) throws IOException {
        prop = new Properties();
        InputStream in = Object.class.getResourceAsStream(fileName);
        prop.load(in);
        return prop.getProperty(key, defaultValue);
    }
}
