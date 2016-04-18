package com.kellonge.demo.snippets.java.regexp;

public class RegExpMain {

    public static void main(String[] args) {
        System.out.println(RegExpUtil.test(RegExpExample.NumberSplit, "12,2,3,4"));
        System.out.println(RegExpUtil.test(RegExpExample.NumberSplit, "12,2,3,4,"));
        System.out.println(RegExpUtil.test(RegExpExample.NumberSplit, "12,2,3,4x"));
        System.out.println(RegExpUtil.test(RegExpExample.NumberSplit, "12,2,3，4"));
    }
}
