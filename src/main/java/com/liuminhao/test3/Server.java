package com.liuminhao.test3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {

    /**
     * 主函数，作为服务器端，用于接收客户端上传的文件。
     * @param args 命令行参数，本程序中未使用。
     */
    public static void main(String[] args) {
        try {
            // 创建服务器Socket，监听9999端口。
            ServerSocket serverSocket = new ServerSocket(9999);
            // 等待客户端连接。
            Socket socket = serverSocket.accept();
            // 创建输入流，用于从客户端读取数据。
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            // 创建输出流，用于将数据写入到本地文件。
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/main/java/com/liuminhao/test3/serverDir/"+ UUID.randomUUID().toString().replace("-", "")+".png"));
            // 创建输出流，用于向客户端发送文本信息。
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");

            // 读取客户端发送的文件数据。
            byte[] bytes = new byte[1024];
            int len;
            // 循环读取数据，直到读取结束。
            // 循环读取客户端发送的数据，并写入到本地文件
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            // 向客户端发送上传成功的信息。
            // 向客户端发送成功消息
            writer.write("上传成功");
            writer.flush();
        } catch (IOException e) {
            // 捕获并处理I/O异常。
            System.err.println("I/O error occurred: " + e.getMessage());
        }
    }

}
