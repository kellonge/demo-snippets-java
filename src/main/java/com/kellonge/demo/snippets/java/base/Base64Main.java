package com.kellonge.demo.snippets.java.base;

import java.util.Base64;

/**
 * base64 编码、反编码
 * 使用 java.util
 * 使用 org.apache.commons.codec
 * 
 * @author kellonge
 * @version $Id: Base64Main.java, v 0.1 2016年4月25日 下午9:35:46 kellonge Exp $
 */
public class Base64Main {
    public static void main(String[] args) {
        javaBase64();
        apacheBase64();
    }

    private static void javaBase64() {
        String raw = "326,327,328,329:1";
        String encode = new String(Base64.getEncoder().encode(raw.getBytes()));
        System.out.println("javaBase64 raw:" + raw + " encode:" + encode);
        String decode = new String(Base64.getDecoder().decode(encode));
        System.out.println("javaBase64 encode:" + encode + " decode:" + decode);
    }

    private static void apacheBase64() {
        String raw = "326,327,328,329:1";
        String encode = org.apache.commons.codec.binary.Base64.encodeBase64String(raw.getBytes());
        System.out.println("javaBase64 raw:" + raw + " encode:" + encode);
        String decode = new String(org.apache.commons.codec.binary.Base64.decodeBase64(encode));
        System.out.println("javaBase64 encode:" + encode + " decode:" + decode);
    }
}
