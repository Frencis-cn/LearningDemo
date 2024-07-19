package com.liuminhao.SocketDemo.tcpDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        // 建议: 考虑通过命令行参数或配置文件来设置端口号

        try (ServerSocket ss = new ServerSocket(9999);
             Socket socket = ss.accept();
             InputStream is = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            // 使用 BufferedReader 以行为单位读取数据，更高效且易于理解
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            // 异常处理: 打印异常堆栈信息到标准错误输出
            e.printStackTrace();

            // 建议: 考虑使用日志框架（如 SLF4J 或 Log4J）记录异常信息
        }
    }
}