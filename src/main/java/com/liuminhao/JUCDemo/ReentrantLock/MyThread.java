package com.liuminhao.JUCDemo.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread  extends Thread{


    static int ticket = 0;

    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){

            try {
                lock.lock();
                if (ticket == 100){
                    break;
                }else {
                    try {
                        Thread.sleep(100);
                        ticket++;
                        System.out.println(Thread.currentThread().getName()+"卖票："+ticket);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }
    }
}
