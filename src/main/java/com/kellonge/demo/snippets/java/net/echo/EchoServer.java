package com.kellonge.demo.snippets.java.net.echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

    private static final int       PORT = 10082;
    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

    }

    private static void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();

        }
    }
}
