package com.kellonge.demo.snippets.java.net.http;

/**
 * Created by kellonge on 16/9/9.
 */
public class SimpleConnect {

    public static void main(String[] args) throws Exception {
        String s = HttpURLConnectionUtils.get("http://www.baidu.com");
        System.out.println(s);
        System.out.println(s.length());
    }
}
