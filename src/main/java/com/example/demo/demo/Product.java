package com.example.demo.demo;

import java.util.Queue;

public class Product {


    static class Producter extends Thread {
        public String threadName;
        public Queue<String> queue;

        public Producter(String threadName, Queue queue) {
            this.threadName = threadName;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                String s1 = new String("123");
                try {
                    this.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (queue) {
                    if (queue.size() > 3) {
                        try {
                            queue.wait();
                        } catch (RuntimeException | InterruptedException e) {
                            e.getStackTrace();
                        }
                    }
                    queue.add("2");
                    System.out.println("生产者生产了一个产品"+threadName);
                    queue.notify();
                }
            }

        }


    }

    static class Consumer extends Thread {
        public String threadName;
        public Queue<String> queue;

        public Consumer(String threadName, Queue queue) {
            this.threadName = threadName;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (queue.size() <= 0) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.getStackTrace();
                        }
                    }
                    queue.remove();
                    System.out.println("消费者消费了一个产品"+threadName);
                    queue.notify();

                }
            }
        }
    }

    public static void main(String[] args) {
        /*Queue queue = new LinkedList();
        Producter producter = new Producter("生产者1", queue);
        Producter producter2 = new Producter("生产者2", queue);
        Producter producter3 = new Producter("生产者3", queue);
        Consumer consumer = new Consumer("消费者1", queue);
        Consumer consumer2 = new Consumer("消费者2", queue);
        producter.start();
        producter2.start();
        producter3.start();
        consumer.start();
        consumer2.start();*/

        ThreadDemo demo = new ThreadDemo();
        demo.addString();
        ThreadDemo dem2o = new ThreadDemo();
        System.out.println(dem2o.getAgs());
    }
}
