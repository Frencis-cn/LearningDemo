package com.liuminhao.JUCDemo.ThreadDemo;

public class ThreadDemo1 {
    public static void main(String[] args) {

        /*
            1. 继承Thread类
            2. 重写Run方法
            // 注释：此处并未直接展示MyThread类的定义，但根据后续代码可推测存在这样的类
            3. 创建子列对象，启动线程

         */

        // 创建MyThread类的对象
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();

        // 为线程设置名称
        //开启线程
        myThread.setName("线程1");
        myThread2.setName("线程2");

        // 启动线程
        myThread.start();
        myThread2.start();



    }

}
