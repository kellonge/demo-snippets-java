package com.kellonge.demo.snippets.java.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;

/**
 * 写入文本文件
 * 
 * 需要注意
 * 1.操作完成后需要close流
 * 2.BufferedWriter在close前需要flush操作，否则可能会有数据还未写入到文件
 * 
 * @author kellonge
 * @version $Id: WriteStringFileMain.java, v 0.1 2016年4月19日 下午3:50:30 kellonge Exp $
 */
public class WriteStringFileMain {

    private static String path = "/Users/kellonge/Work/tmp/";

    public static void main(String[] args) throws IOException {
        write();
        writeWithBuffer();
    }

    private static void write() throws IOException {
        Date b = new Date();
        FileWriter fileWriter = new FileWriter(path + "1.txt");
        for (int i = 0; i < 1000000; i++) {
            JSONObject data = new JSONObject();
            data.put("time", new Date());
            data.put("name", "是的；福克斯");
            fileWriter.write(data.toJSONString());
            fileWriter.write("\n");
        }
        fileWriter.close();
        System.out.println(new Date().getTime() - b.getTime());
    }

    private static void writeWithBuffer() throws IOException {
        Date b = new Date();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            JSONObject data = new JSONObject();
            data.put("time", new Date());
            data.put("name", "是的；福克斯");
            sbBuffer.append(data.toJSONString());
        }
        FileUtil.writeStr(path + "2.txt", sbBuffer.toString());
        System.out.println(new Date().getTime() - b.getTime());
    }
}
