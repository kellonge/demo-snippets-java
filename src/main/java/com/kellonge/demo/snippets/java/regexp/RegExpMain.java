package com.kellonge.demo.snippets.java.regexp;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.time.DateUtils;

import com.alibaba.fastjson.JSONObject;

public class RegExpMain {

    public static void main(String[] args) {
        String tmp = "2016-05-14 09:19:55 319  a7e934b68af6456c9ee9d832be6bd15a - executing method queryMerchantsOrderCashierDateStat request params ";

        Matcher matcher = Pattern.compile("\\w{32}(?= -)").matcher(tmp);
//        Matcher matcher = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2} \\d{3}").matcher(tmp);
//        Matcher matcher = Pattern.compile("\\w{32}").matcher(tmp);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
 
         
        //testNumberSplit();
    }

    private static void testNumberSplit() {
        System.out.println("12,2,3,4 result:" + RegExpUtil.test(RegExpExample.NumberSplit, "12,2,3,4"));
        System.out.println("12,2,3,4, result:" + RegExpUtil.test(RegExpExample.NumberSplit, "12,2,3,4,"));
        System.out.println("12,2,3,4x result:" + RegExpUtil.test(RegExpExample.NumberSplit, "12,2,3,4x"));
        System.out.println("12,2,3，4 result:" + RegExpUtil.test(RegExpExample.NumberSplit, "12,2,3，4"));
    }
}
