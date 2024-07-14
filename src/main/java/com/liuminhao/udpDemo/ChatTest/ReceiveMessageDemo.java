package com.liuminhao.udpDemo.ChatTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(10086);

        while(true)
        {
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf,buf.length);
            System.out.println("等待接收数据");

            ds.receive(dp);

            if ("bye".equals(new String(dp.getData(),0,dp.getLength()))){
                ds.close();
                break;
            }

            System.out.println("接收到数据:=>"+new String(dp.getData(),0,dp.getLength()));



        }

    }
}
