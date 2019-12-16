package com.example.demo.demo;

public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Thread1 thread1 = new Thread1(o,"t1");
        thread1.start();
        synchronized (thread1){
            for (int i=0;i<100;i++){
                if(i==20){
                    thread1.join();
                }
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }



}
