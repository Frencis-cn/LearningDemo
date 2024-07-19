package com.liuminhao.SocketDemo.test1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    /**
     * 程序的入口点。
     * 创建一个Socket客户端，连接到本地主机的指定端口，然后通过标准输入流接收用户输入，
     * 并将输入内容发送到服务器，直到输入"886"为止，然后关闭Socket连接。
     *
     * @param args 命令行参数，本程序中未使用。
     * @throws IOException 如果发生I/O错误。
     */
    public static void main(String[] args) throws IOException {
        // 连接到本地主机的9999端口。
        Socket socket = new Socket("127.0.0.1",9999);

        // 通过标准输入流读取用户输入。
        Scanner s = new Scanner(System.in);

        // 获取Socket的输出流，用于向服务器发送数据。
        OutputStream outputStream = socket.getOutputStream();

        // 不断循环，等待用户输入。
        while(true){
            // 提示用户输入。
            System.out.println("请输入：");
            // 读取用户输入的一行。
            String str = s.nextLine();
            // 如果输入的是"886"，则退出循环。
            if("886".equals(str)){
                break;
            }
            // 将用户输入转换为字节数组并写入输出流，发送给服务器。
            outputStream.write(str.getBytes());
        }

        // 关闭Socket连接。
        socket.close();
    }

}
