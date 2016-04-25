package com.kellonge.demo.snippets.java.base;

import java.util.Base64;

/**
 * base64 编码、反编码
 * 使用 java.util
 * 
 * @author kellonge
 * @version $Id: Base64Main.java, v 0.1 2016年4月25日 下午9:35:46 kellonge Exp $
 */
public class Base64Main {
    public static void main(String[] args) {
        String raw = "384";
        byte[] encode = Base64.getEncoder().encode(raw.getBytes());
        System.out.println(new String(encode));
        System.out.println(new String(Base64.getDecoder().decode(encode)));
    }
}
