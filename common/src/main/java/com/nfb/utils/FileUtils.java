package com.nfb.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蔻丁同学 on 2015/4/30.
 */
public class FileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

    public static List<File> searchFile(String basePath, String fileName) {
        List resultList = new ArrayList();
        findFiles(basePath, fileName, resultList);
        return resultList;
    }


    public static void findFiles(String baseDirName, String targetFileName, List fileList) {

        File baseDir = new File(baseDirName);       // 创建一个File对象
        if (!baseDir.exists() || !baseDir.isDirectory()) {  // 判断目录是否存在
            LOGGER.warn("文件查找失败：{} 不是一个目录，第一次创建目录中...", baseDirName);
            makeDir(baseDir);
        }
        String tempName = null;
        //判断目录是否存在
        File tempFile;
        File[] files = baseDir.listFiles();
        if (files.length <= 0) {
            LOGGER.warn("{}下未找到任何子文件！", baseDir.getAbsolutePath());
        } else {
            for (int i = 0; i < files.length; i++) {
                tempFile = files[i];
                if (tempFile.isDirectory()) {
                    findFiles(tempFile.getAbsolutePath(), targetFileName, fileList);
                } else if (tempFile.isFile()) {
                    tempName = tempFile.getName();
                    if (wildcardMatch(targetFileName, tempName)) {
                        // 匹配成功，将文件名添加到结果集
                        fileList.add(tempFile.getAbsoluteFile());
                    }
                }
            }
        }
    }

    /**
     * 通配符匹配
     *
     * @param pattern 通配符模式
     * @param str     待匹配的字符串
     * @return 匹配成功则返回true，否则返回false
     */
    private static boolean wildcardMatch(String pattern, String str) {
        int patternLength = pattern.length();
        int strLength = str.length();
        int strIndex = 0;
        char ch;
        for (int patternIndex = 0; patternIndex < patternLength; patternIndex++) {
            ch = pattern.charAt(patternIndex);
            if (ch == '*') {
                //通配符星号*表示可以匹配任意多个字符
                while (strIndex < strLength) {
                    if (wildcardMatch(pattern.substring(patternIndex + 1),
                            str.substring(strIndex))) {
                        return true;
                    }
                    strIndex++;
                }
            } else if (ch == '?') {
                //通配符问号?表示匹配任意一个字符
                strIndex++;
                if (strIndex > strLength) {
                    //表示str中已经没有字符匹配?了。
                    return false;
                }
            } else {
                if ((strIndex >= strLength) || (ch != str.charAt(strIndex))) {
                    return false;
                }
                strIndex++;
            }
        }
        return (strIndex == strLength);
    }

    public static void makeDir(File dir) {
        if (!dir.getParentFile().exists()) {
            makeDir(dir.getParentFile());
        }
        dir.mkdir();
    }
}
