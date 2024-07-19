package com.liuminhao.JUCDemo.ThreadDemo2;

public class ThreadDemo {
    public static void main(String[] args) {

        /*
         * 多线程第二种启动方式
         * 1.自定义一个类实现Runnable接口
         * 2.重写run方法
         * 3.创建一个Runnable接口的实现类对象
         * 4.创建一个Thread类对象，开启线程
         */

        //创建Runnable接口的实现类对象
        MyRunnable mr = new MyRunnable();

        //创建线程对象，开启线
        Thread t = new Thread(mr);
        t.setName("线程1");
        /*
            设置优先级
            1.线程优先级范围1-10
            2.优先级越高，抢到cpu的几率越大
            3.默认优先级5
            只是几率变大，不能保证优先级一定生效
         */

        t.setPriority(10);

        t.start();
        Thread t2 = new Thread(mr);
        t2.setName("线程2");
        t2.start();


    }
}
