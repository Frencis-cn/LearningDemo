package com.liuminhao.JUCDemo.ThreadSafe;

public class Threadcell extends Thread{
    //表示这个类所有的对象都共享ticket数据
    static int ticket = 0;


    public Threadcell(String name) {
        super(name);
    }

   static Object obj = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if(ticket < 100){
                    try {
                        Thread.sleep(100);
                        ticket++;
                        System.out.println(getName() + "售票，票号为：" + ticket);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    break;
                }
            }
        }
    }
}
