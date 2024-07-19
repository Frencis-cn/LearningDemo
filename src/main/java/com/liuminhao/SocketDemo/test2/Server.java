package com.liuminhao.SocketDemo.test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    /**
     * 主函数，作为服务器端程序的入口点。
     * @param args 命令行参数，本程序中未使用。
     * @throws IOException 如果发生I/O错误。
     */
    public static void main(String[] args) throws IOException {
        // 创建一个服务器Socket，监听9999端口。
        ServerSocket serverSocket = new ServerSocket(9999);

        // 等待客户端连接，接受连接请求。
        Socket socket = serverSocket.accept();

        // 获取客户端发送的输入流。
        InputStream inputStream = socket.getInputStream();

        // 将输入流包装为字符流，方便读取字符数据。
        InputStreamReader reader = new InputStreamReader(inputStream);

        // 读取客户端发送的数据，一次一个字符。
        int len = 0;
        while ((len = reader.read()) != -1){
            // 输出读取到的字符。
            System.out.println((char)len);
        }

        // 获取输出流，用于向客户端发送数据。
        OutputStream outputStream = socket.getOutputStream();

        // 将字符串转换为字节数组并写入输出流。
        outputStream.write("hello,you".getBytes());

        // 关闭客户端Socket和服务器Socket，释放资源。
        socket.close();
        serverSocket.close();
    }

}
