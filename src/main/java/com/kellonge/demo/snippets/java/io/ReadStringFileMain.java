package com.kellonge.demo.snippets.java.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;

/**
 * 读取文本文件
 * 
 * @author kellonge
 * @version $Id: ReadStringFileMain.java, v 0.1 2016年4月19日 下午5:12:27 kellonge Exp $
 */
public class ReadStringFileMain {

    private static String path = "/Users/kellonge/Work/tmp/";

    public static void main(String[] args) throws IOException {
        System.out.println("read " + read());
        System.out.println("read " + read());
        System.out.println("readWithBuffer " + readWithBuffer());
        System.out.println("readWithBuffer " + readWithBuffer());
        System.out.println("readWithBufferEncode " + readWithBufferEncode());
        System.out.println("readWithBufferEncode " + readWithBufferEncode());
    }

    private static Long read() throws IOException {
        Date b = new Date();
        FileReader fileReader = (FileReader) getReader();
        int tmp = 0;
        StringBuffer txt = new StringBuffer();
        while ((tmp = fileReader.read()) != -1) {
            txt.append((char) tmp);
        }
        return new Date().getTime() - b.getTime();
    }

    private static Long readWithBufferEncode() throws IOException {
        Date b = new Date();
        Reader fileReader = getEncodeBufferedReader();
        int tmp = 0;
        StringBuffer txt = new StringBuffer();
        while ((tmp = fileReader.read()) != -1) {
            txt.append((char) tmp);
        }
        return new Date().getTime() - b.getTime();
    }

    private static Long readWithBuffer() throws IOException {
        Date b = new Date();
        BufferedReader fileReader = (BufferedReader) getBufferedReader();
        int tmp = 0;
        StringBuffer txt = new StringBuffer();
        while ((tmp = fileReader.read()) != -1) {
            txt.append((char) tmp);
        }
        return new Date().getTime() - b.getTime();
    }

    private static Reader getReader() throws IOException {
        return new FileReader(path + "1.txt");
    }

    private static Reader getBufferedReader() throws IOException {
        return new BufferedReader(new FileReader(path + "2.txt"));
    }

    private static Reader getEncodeBufferedReader() throws IOException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(path + "2.txt"), "utf-8"));

    }
}
