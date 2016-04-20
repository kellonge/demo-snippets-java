package com.kellonge.demo.snippets.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            //这种是指定编码的创建方式，如果不是指定编码可以用如下的方式创建
            //new BufferedReader(new FileReader(file));
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

    /**
     * 写入字节数组到指定路径的文件
     * 
     * @param path
     * @param data
     * @return
     */
    public static boolean writeByte(String path, byte[] data) {
        File file = new File(path);
        boolean result = true;
        BufferedOutputStream writer = null;
        try {
            writer = new BufferedOutputStream(new FileOutputStream(file));
            writer.write(data);
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

    /**
     * 从指定路径的文件中读取字节数组
     * 
     * @param path
     * @return
     */
    public static byte[] readByte(String path) {
        File file = new File(path);
        BufferedInputStream reader = null;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        try {
            reader = new BufferedInputStream(new FileInputStream(file));
            int tmp;
            while ((tmp = reader.read()) != -1) {
                byteArray.write(tmp);
            }
            return byteArray.toByteArray();
        } catch (Exception e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
        return new byte[0];
    }

    /**
     * 把对象写入到指定的路径
     * 
     * @param path
     * @param data
     * @return
     */
    public static boolean writeObject(String path, Object data) {
        if (null == data) {
            throw new NullPointerException();
        }
        File file = new File(path);
        boolean result = true;
        ObjectOutputStream writer = null;
        try {
            writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(data);
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

    /**
     * 读取指定路径的对象
     * 
     * @param path
     * @return
     */
    public static Object readObject(String path) {
        File file = new File(path);
        ObjectInputStream reader = null;
        try {
            reader = new ObjectInputStream(new FileInputStream(file));
            return reader.readObject();
        } catch (Exception e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
        return null;
    }
}
