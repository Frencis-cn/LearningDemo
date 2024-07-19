package com.liuminhao.SocketDemo.test5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 9999);

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            BufferedInputStream bufferedInputStreamClient = new BufferedInputStream(new FileInputStream("src/main/java/com/liuminhao/test3/clientDir/a.png"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStreamClient.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }

            // Shutdown the output stream to indicate data transmission is complete
            socket.shutdownOutput();

    }
}
