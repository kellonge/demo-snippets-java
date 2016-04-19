package com.kellonge.demo.snippets.java.regexp;

import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 * 
 * @author kellonge
 * @version $Id: RegExpUtil.java, v 0.1 2016年4月19日 下午1:38:49 kellonge Exp $
 */
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
