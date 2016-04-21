package com.kellonge.demo.snippets.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 从System.in读取输入流并原样输出，说明System.in本质是一种InputStream
 * 
 * @author kellonge
 * @version $Id: ReadAndPrintMain.java, v 0.1 2016年4月21日 下午8:29:25 kellonge Exp $
 */
public class ReadAndPrintMain {
    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();
            System.out.println(line);
        }
    }
}
