package com.liuminhao.SocketDemo.test3;

import java.io.*;
import java.net.Socket;

public class Client {
    /**
     * 程序的入口点。
     * 该方法通过创建一个Socket连接到本地主机的9999端口，实现客户端和服务器之间的文件传输。
     * 具体来说，它将客户端指定文件发送到服务器，并从服务器接收数据。
     *
     * @param args 命令行参数，未使用
     * @throws IOException 如果发生I/O错误
     */
    public static void main(String[] args) throws IOException {
        // 创建Socket对象，连接到本地主机的9999端口
        try (Socket socket = new Socket("127.0.0.1", 9999);
             // 为Socket的输出流创建缓冲区，用于向服务器发送数据
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
             // 为从文件读取数据创建缓冲区，用于读取客户端文件并发送到服务器
             BufferedInputStream bufferedInputStreamClient = new BufferedInputStream(new FileInputStream("src/main/java/com/liuminhao/test3/clientDir/a.png"));
             // 为Socket的输入流创建缓冲区，用于接收服务器返回的数据
             BufferedInputStream bufferedInputStreamServer = new BufferedInputStream(socket.getInputStream())) {

            // 定义一个字节数组，用于临时存储读取或接收的数据
            byte[] bytes = new byte[1024];
            int len;
            // 从客户端文件读取数据，并将其写入Socket的输出流，直到读取完毕
            while ((len = bufferedInputStreamClient.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
            // 强制将输出流缓冲区的内容写入底层输出流
            bufferedOutputStream.flush();

            // 关闭Socket的输出流，告知服务器数据发送完成，准备接收服务器返回的数据
            socket.shutdownOutput();
            System.out.println("发送成功,准备接受返回的数据");

            // 从Socket的输入流读取数据，并将其写入标准输出流，直到读取完毕
            while ((len = bufferedInputStreamServer.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, len));
            }

        // 捕获并处理所有IOExceptions
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
