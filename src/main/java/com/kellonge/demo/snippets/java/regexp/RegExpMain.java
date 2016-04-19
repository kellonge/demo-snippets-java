package com.kellonge.demo.snippets.java.regexp;

public class RegExpMain {

    public static void main(String[] args) {
        testNumberSplit();
    }

    private static void testNumberSplit() {
        System.out.println("12,2,3,4 result:" + RegExpUtil.test(RegExpExample.NumberSplit, "12,2,3,4"));
        System.out.println("12,2,3,4, result:" + RegExpUtil.test(RegExpExample.NumberSplit, "12,2,3,4,"));
        System.out.println("12,2,3,4x result:" + RegExpUtil.test(RegExpExample.NumberSplit, "12,2,3,4x"));
        System.out.println("12,2,3，4 result:" + RegExpUtil.test(RegExpExample.NumberSplit, "12,2,3，4"));

    }
}
