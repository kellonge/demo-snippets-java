package com.kellonge.demo.snippets.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SockedServer {
    public static void main(String[] args) {
        initServer();
    }

    private static void initServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(20880);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out
                    .println("coming new client " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
                printInputData(socket.getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printInputData(InputStream stream) {

        try {
            int tmp = 0;
            while ((tmp = stream.read()) != -1) {
                System.out.println(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
