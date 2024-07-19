package com.liuminhao.SocketDemo.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    /**
     * 程序的入口点，用于启动一个简单的TCP服务器，监听指定端口并接收客户端发送的数据。
     * @param args 命令行参数，本程序中未使用。
     * @throws IOException 如果发生I/O错误。
     */
    public static void main(String[] args) throws IOException {
        // 创建一个ServerSocket对象，监听9999端口。
        ServerSocket serverSocket = new ServerSocket(9999);

        // 等待客户端连接，接受连接并返回Socket对象。
        Socket socket = serverSocket.accept();

        // 获取客户端发送的数据流。
        InputStream inputStream = socket.getInputStream();

        // 将输入流包装为 InputStreamReader，指定字符集为默认字符集。
        InputStreamReader reader = new InputStreamReader(inputStream);

        // 逐行读取客户端发送的数据，并打印到控制台。
        int line ;
        while ((line = reader.read()) != -1) {
            System.out.print((char) line);
        }

        // 关闭Socket和ServerSocket，释放资源。
        socket.close();
        serverSocket.close();
    }

}
