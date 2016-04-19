package com.kellonge.demo.snippets.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 文件操作工具类
 * 
 * @author kellonge
 * @version $Id: FileUtil.java, v 0.1 2016年4月19日 下午7:18:45 kellonge Exp $
 */
public class FileUtil {

    /**
     * 读取指定文件中的所有内容，默认编码为utf-8
     * 
     * @param path
     * @return
     */
    public static String readStr(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            String tmp = null;
            StringBuffer content = new StringBuffer();
            while ((tmp = reader.readLine()) != null) {
                content.append(tmp);
            }
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * 写入content到指定的文件，默认编码为utf-8
     * 
     * @param path
     * @param content
     * @return 写入失败返回false
     */
    public static boolean writeStr(String path, String content) {
        File file = new File(path);
        BufferedWriter writer = null;
        boolean result = true;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
            writer.write(content);
        } catch (Exception e) {
            result = false;
        } finally {
            if (null != writer) {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                }
            }
        }
        return result;
    }
}
