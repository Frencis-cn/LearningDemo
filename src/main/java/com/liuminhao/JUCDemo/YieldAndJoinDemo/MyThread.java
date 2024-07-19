package com.liuminhao.JUCDemo.YieldAndJoinDemo;

public class MyThread extends Thread{

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100 ; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
            //出让当前CPU的执行权
            Thread.yield();

        }
    }
}
