package com.kellonge.demo.snippets.java.net;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class SocketClient {
    public static void main(String[] args) {
        initclient();
    }

    private static void initclient() {
        try {
            Socket socket = new Socket("127.0.0.1", 20880);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(String.valueOf(new Date().getTime()).getBytes());
            outputStream.flush();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
