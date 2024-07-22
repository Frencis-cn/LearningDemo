package com.liuminhao.JUCDemo.ProducterCustmer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionalTestDemo {
    public static void main(String[] args) {

        DamoData data = new DamoData();

        //精准通知，A->B->C
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        },"C").start();

    }
}

class DamoData{
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    private int number = 1;

    public void printA(){
        lock.lock();
        try {
            while(number != 1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "------->A");
            number = 2;
            //唤醒制定的线程
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    };
    public void printB(){
        lock.lock();
        try {
            while (number != 2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "------->B");
            number = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    };
    public void printC(){
        lock.lock();
        try {
            while(number != 3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "------->C");
            number = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    };



}
