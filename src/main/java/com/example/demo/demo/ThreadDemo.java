package com.example.demo.demo;

import java.util.Queue;

public class ThreadDemo {
    public static String ags = "111";

    public static String getAgs() {
        return ags;
    }

    public static void setAgs(String ags) {
        ThreadDemo.ags = ags;
    }

    public void addString(){
        this.ags+="222";
    }


    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(() -> System.out.println( "执行线程1中"));
        thread1.setName("MyThread -- 1");
        thread1.start();
        thread1.join();
        Thread thread2 = new Thread(() -> System.out.println( "执行线程2中"));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });

        thread.start();
        thread2.setName("MyThread -- 2");
        thread2.start();

        try{
            thread2.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getName() + " " + thread2.getName()  + "  已经执行结束");
    }


}
