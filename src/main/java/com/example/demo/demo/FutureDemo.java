package com.example.demo.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable call = new Callable() {
            @Override
            public Object call() throws Exception {

                System.out.println("asd");
                return 1;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask(call);
        Thread thread = new Thread(futureTask);

        thread.start();
        int  t = futureTask.get();
        System.out.println("得到的结果:"+t);

    }




}
