package com.kellonge.demo.snippets.java.net.echo;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class EchoServer {

    private static final int       PORT         = 10082;
    private static final int       maxThreadCnt = 10;
    private static ExecutorService handlePool   = Executors.newFixedThreadPool(maxThreadCnt);
    private static ExecutorService busyPool     = Executors.newFixedThreadPool(2);
    private static AtomicInteger   threadCnt    = new AtomicInteger(0);

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                final Socket socket = serverSocket.accept();
                if (threadCnt.incrementAndGet() > maxThreadCnt) {
                    busyPool.submit(new Runnable() {
                        @Override
                        public void run() {
                            writeBusy(socket);
                        }
                    });
                } else {
                    handlePool.submit(new Runnable() {
                        @Override
                        public void run() {
                            handleRequest(socket);
                        }
                    });
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeBusy(Socket socket) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            writer.write("busy");
            printLog(socket, "busy", false);
        } catch (Exception e) {
        }
    }

    private static void handleRequest(Socket socket) {
        try (BufferedInputStream reader = new BufferedInputStream(socket.getInputStream());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {
            int tmp = 0;
            StringBuilder sb = new StringBuilder();
            while ((tmp = reader.read()) != -1) {
                char tmpChar = (char) tmp;
                if ('\n' != tmpChar && '\r' != tmpChar) {
                    sb.append(tmpChar);
                } else {
                    printLog(socket, sb.toString(), true);
                    writer.write(sb.toString() + "\n");
                    printLog(socket, sb.toString(), false);
                    sb.delete(0, sb.length() - 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadCnt.decrementAndGet();
        }
    }

    private static void printLog(Socket socket, String msg, boolean isIn) {
        System.out.println(String.format("%s[%s]-[%s:%s] [%s]", isIn ? "In  " : "Out ",
            Thread.currentThread().getName(), socket.getInetAddress().getHostAddress(), socket.getPort(), msg));
    }
}
