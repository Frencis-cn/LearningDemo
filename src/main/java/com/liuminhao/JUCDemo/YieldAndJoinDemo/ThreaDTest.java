package com.liuminhao.JUCDemo.YieldAndJoinDemo;

import com.liuminhao.JUCDemo.YieldAndJoinDemo.MyThread;

public class ThreaDTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("线程1");
        MyThread t2 = new MyThread("线程2");
        t1.start();
        t2.start();

        /*
        * yield()方法，使当前线程由运行状态变为就绪状态，
        * 让当前线程暂停，但不释放锁
        * 会让线程的执行平均
         */


        //将t1线程插入到当前线程（main）之前执行
        t1.join();

        //Thread = main
        for (int i = 0; i <= 100 ; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }

    }
}
