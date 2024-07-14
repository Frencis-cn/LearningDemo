package com.liuminhao.test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    /**
     * 程序入口主方法，用于演示通过套接字（Socket）进行简单通信。
     * @param args 命令行参数，本例中未使用。
     * @throws IOException 如果发生I/O错误。
     */
    public static void main(String[] args) throws IOException {
        // 创建一个Socket对象，连接到本地主机的9999端口。
        Socket socket = new Socket("127.0.0.1", 9999);

        // 获取Socket的输出流，用于向服务器发送数据。
        OutputStream outputStream = socket.getOutputStream();

        // 将字符串"hello"转换为字节数组并写入输出流。
        outputStream.write("hello".getBytes());

        // 关闭输出流，表示发送完毕。
        socket.shutdownOutput();

        // 获取Socket的输入流，用于接收服务器发送的数据。
        InputStream inputStream = socket.getInputStream();

        // 将输入流包装为 InputStreamReader，方便按字符读取数据。
        InputStreamReader reader = new InputStreamReader(inputStream);

        // 读取输入流中的数据，直到读取完毕（读到-1）。
        int len;
        while ((len = reader.read()) != -1){
            // 将读取到的字符打印到控制台。
            System.out.print((char) len);
        }

        // 关闭Socket，释放资源。
        socket.close();
    }

}
