package com.liuminhao.SocketDemo.test5;

import com.liuminhao.SocketDemo.test4.MyRunnable;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {

    /**
     * 主函数，作为服务器端，用于接收客户端上传的文件。
     * @param args 命令行参数，本程序中未使用。
     */
    public static void main(String[] args) throws IOException {

        //创建线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,//核心线程数量
                16,//线程池总大小
                60,//空闲时间
                TimeUnit.SECONDS,//空闲时间的单位
                new ArrayBlockingQueue<>(2),//队列
                Executors.defaultThreadFactory(),//线程工厂，让线程池如何创建线程对象
                new ThreadPoolExecutor.AbortPolicy()//阻塞队列
        );



        //创建对象并绑定端口
        ServerSocket serverSocket = new ServerSocket(9999);

        while (true) {
            Socket socket = serverSocket.accept();

            pool.submit(new MyRunnable(socket));
        }

    }

}
