package com.liuminhao.JUCDemo.ThreadDemo3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
         * 多线程第三种实现方式：实现Callable接口
         * 1.创建Callable接口实现类的对象
         * 2.重写call（有返回值，表示多线程运行的结果）
         * 3.创建MyCallable的对象（表示多线程要执行的任务）
         * 4.创建FutureTask对象（作用管理多线程运行的结果）
         * 5.创建Thread类的对象，并启动
         *
         */

        MyCallable mc = new MyCallable();

        //创建FutureTask的对象，（作用管理多相处运行的结果）
        FutureTask<Integer> ft = new FutureTask<>(mc);

        //创建线程的对象
        Thread t1 = new Thread(ft);

        t1.start();

        Integer result = ft.get();
        System.out.println(result);
    }
}
