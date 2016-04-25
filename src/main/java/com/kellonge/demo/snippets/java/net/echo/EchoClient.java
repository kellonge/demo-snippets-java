package com.kellonge.demo.snippets.java.net.echo;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class EchoClient {

    private static final int    SERVERPORT = 10082;

    private static final String SERVERIP   = "127.0.0.1";

    public static void main(String[] args) {
        startClient();
    }

    private static void startClient() {
        try {
            for (int i = 0; i < 11; i++) {
                Socket socket = new Socket(SERVERIP, SERVERPORT);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(String.valueOf(new Date().getTime() + "\n").getBytes());
                outputStream.flush();
            }
      
          //  socket.close();
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
