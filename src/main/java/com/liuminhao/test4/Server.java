package com.liuminhao.test4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    /**
     * 主函数，作为服务器端，用于接收客户端上传的文件。
     * @param args 命令行参数，本程序中未使用。
     */
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);

        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new MyRunnable(socket)).start();
        }

    }

}
