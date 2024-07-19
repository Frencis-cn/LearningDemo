package com.liuminhao.JUCDemo.DaemonDemo;

public class ThreadTest {
    public static void main(String[] args) {

        /*
         * final void setDaemon(boolean on) 设置为守护线程
         * boolean isDaemon() 判断是否为守护线程
         * 当其他的非守护线程运行完毕，守护线程也会自动结束
         *
         */

        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        t1.setName("t1");
        t2.setName("t2");

        t2.setDaemon(true);
        System.out.println(t2.isDaemon());

        t1.start();
        t2.start();// 守护线程陆续结束，不会运行完


    }
}
