package com.kellonge.demo.snippets.java.io;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FileMain {

    private static String path = "/Users/kellonge/Work/tmp/";

    public static void main(String[] args) {
        testByteReadAndWrite();
    }

    private static void testObjectReadAndWrite() {
        ExampleModel exampleModel = new ExampleModel();
        exampleModel.setAge(1);
        exampleModel.setName("xwx");
        exampleModel.setTime(new Date());
        FileUtil.writeObject(path + "5.data", exampleModel);
        System.out.println(JSON.toJSONString(FileUtil.readObject(path + "5.data")));
    }

    private static void testByteReadAndWrite() {
        FileUtil.writeByte(path + "4.data", "ssw是的范德萨".getBytes());
        System.out.println(new String(FileUtil.readByte(path + "4.data")));

        FileUtil.writeByteUseNIO(path + "4.data", "ssw是的范德萨".getBytes());
        System.out.println(new String(FileUtil.readByteUseNIO(path + "4.data")));
    }

    private static void testStrReadAndWrite() {
        Date b = new Date();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            JSONObject data = new JSONObject();
            data.put("time", new Date());
            data.put("name", "是的；福克斯");
            sbBuffer.append(data.toJSONString());
        }
        FileUtil.writeStr(path + "3.txt", sbBuffer.toString());
        System.out.println(new Date().getTime() - b.getTime());

        b = new Date();
        String readStr = FileUtil.readStr(path + "3.txt");
        System.out.println(new Date().getTime() - b.getTime());
    }
}
