package com.liuminhao.test4;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 9999);

        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            BufferedInputStream bufferedInputStreamClient = new BufferedInputStream(new FileInputStream("src/main/java/com/liuminhao/test3/clientDir/a.png"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStreamClient.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }

            // Shutdown the output stream to indicate data transmission is complete
            socket.shutdownOutput();


        } catch (IOException e) {
            // Handle I/O exceptions here, such as logging or user notification
            System.err.println("I/O error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
