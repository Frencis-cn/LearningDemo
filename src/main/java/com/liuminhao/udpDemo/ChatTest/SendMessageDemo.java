package com.liuminhao.udpDemo.ChatTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class SendMessageDemo {
    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket();

        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("输入消息");
            String str = s.nextLine();
            byte[] bytes = str.getBytes();

            InetAddress address = InetAddress.getByName("127.0.0.1");
            int port = 10086;

            DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);
            ds.send(dp);
            if ("bye".equals(str)){
                ds.close();
                break;
            }

        }


    }
}
