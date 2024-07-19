package com.liuminhao.JUCDemo.ThreadDemo;

public class ThreadDemo1 {
    public static void main(String[] args) {

        /*
            1. 继承Thread类
            2. 重写Run方法
            // 注释：此处并未直接展示MyThread类的定义，但根据后续代码可推测存在这样的类
            3. 创建子列对象，启动线程

         */

        // 创建MyThread类的对象，为线程设置名称
        MyThread myThread = new MyThread("线程1");
        MyThread myThread2 = new MyThread();

        myThread2.setName("线程2");

        // 启动线程
        myThread.start();
        myThread2.start();

        /*
         * 线程的方法
         * 1.String getName() 获取线程的名称
         * 2.void setName(String name) 设置线程的名称
         * 3.static Thread currentThread() 获取当前线程
         * 4.void sleep(long millis) 线程休眠
         */

        Thread currentThread = Thread.currentThread();
        try {
            currentThread.sleep(1000);
            System.out.println(currentThread);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
