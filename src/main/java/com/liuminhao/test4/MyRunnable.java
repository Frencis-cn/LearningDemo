package com.liuminhao.test4;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyRunnable  implements  Runnable{

    private final Socket socket;

    public MyRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        File outputFile = null;
        try {
            // 创建输入流，用于从客户端读取数据。
            try (BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/main/java/com/liuminhao/test3/serverDir/"+UUID.randomUUID().toString().replace("-", "")+".png"))) {

                // 读取客户端发送的文件数据。
                byte[] bytes = new byte[1024];
                int len;
                // 循环读取数据，直到读取结束。
                // 循环读取客户端发送的数据，并写入到本地文件
                while ((len = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }
            }
            // socket关闭放在finally块中确保关闭
        } catch (IOException e) {
            // 捕获并处理I/O异常。
            System.err.println("I/O error occurred: " + e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

