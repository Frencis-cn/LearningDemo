package com.liuminhao.JUCDemo.ThreadSafe;

public class ThreadTest {
    public static void main(String[] args) {
        Threadcell t1 = new Threadcell("窗口1");
        Threadcell t2 = new Threadcell("窗口2");
        Threadcell t3 = new Threadcell("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
