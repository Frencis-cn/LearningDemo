package com.liuminhao.JUCDemo.DeadLock;

public class MyThread extends Thread{

    static Object lock1 = new Object();
    static Object lock2 = new Object();


    @Override
    public void run() {

        while (true){
            if("线程A".equals(getName())){
                synchronized(lock1){
                    System.out.println("线程A" + "获取到lock1");
                    synchronized (lock2){
                        System.out.println("线程A" + "获取到lock2");
                    }
                    }
                }else if("线程B".equals(getName())){
                    synchronized(lock2){
                        System.out.println("线程B" + "获取到lock2");
                        synchronized (lock1){
                            System.out.println("线程B" + "获取到lock1");
                        }
                    }
            }
        }
    }
}
