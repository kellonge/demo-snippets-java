package com.kellonge.demo.snippets.java.regexp;

/**
 * 常用的正则表达式
 * 
 * @author kellonge
 * @version $Id: RegExpExample.java, v 0.1 2016年4月19日 上午11:57:55 kellonge Exp $
 */
public class RegExpExample {

    /*
     * 数字用逗号分隔
     */
    public static String NumberSplit     = "^(\\d+,)*\\d+$";

    /**
     * 国内手机号，不带国家区号，11位数字
     */
    public static String Mobile          = "^1[3|4|5|7|8|9][0-9]{9}$";

    /**
     * 匹配 yyyy-MM-dd mm:hh:ss SSS 格式时间
     */
    public static String DateTimeLog     = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2} \\d{3}";

    /**
     * 匹配response xxx and total time is中xxx内容，用户匹配指定开头和结尾中间的内容
     */
    public static String InternalContent = "(?<=response ).*(?= and total time is)";
}
