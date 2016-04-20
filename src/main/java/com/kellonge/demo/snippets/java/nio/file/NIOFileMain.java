package com.kellonge.demo.snippets.java.nio.file;

public class NIOFileMain {
    private static String path = "/Users/kellonge/Work/tmp/";

    public static void main(String[] args) {
        NIOFileUtil.writeStr(path + "10.data", "ss");
    }
}
