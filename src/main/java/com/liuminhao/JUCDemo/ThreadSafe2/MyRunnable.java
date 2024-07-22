package com.liuminhao.JUCDemo.ThreadSafe2;

public class MyRunnable implements Runnable{

    int ticket = 0;

    @Override
    public void run() {
        //1.循环
        while(true){
            //2.同步代码快
            if (method()) break;
        }
    }

    private synchronized boolean method() {
        //3.判断共享数据是否到了末尾
        if(ticket == 100){
            return true;
        }else{
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            ticket++;
            System.out.println(Thread.currentThread().getName()+"卖票："+ticket);
        }
        return false;
    }
}
