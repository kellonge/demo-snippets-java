package com.kellonge.demo.snippets.java.regexp;

import java.util.regex.Pattern;

public class RegExpUtil {

    /**
     * 测试val字段是否符合exp的正则表达式
     * 
     * @param exp 正则表达式
     * @param val 需要测试的值
     * @return
     */
    public static boolean test(String exp, String val) {
        return Pattern.compile(exp).matcher(val).matches();
    }
}
