package com.kellonge.demo.snippets.java.nio.file;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOFileUtil {

    public static boolean writeStr(String path, String content) {
        boolean result = true;
        try (FileChannel fileChannel = (FileChannel.open(Paths.get(path), StandardOpenOption.WRITE,
            StandardOpenOption.CREATE));) {
            byte[] bytes = content.getBytes("utf-8");
            ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
            byteBuffer.put(bytes);
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

}
