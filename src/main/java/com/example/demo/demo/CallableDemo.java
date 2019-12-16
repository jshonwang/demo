package com.example.demo.demo;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo  implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i=0;i<10;i++){
            System.out.println("执行方法");
            return i;
        }
        return null;

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
      /*  ExecutorService executorService  = new ScheduledThreadPoolExecutor(2);
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return "\"12\"";
            }
        };
        Future<String> future = executorService.submit(callable);
        System.out.println("返回的值"+ future.get());*/
      FutureTask futureTask = new FutureTask(new Callable() {
          @Override
          public Object call() throws Exception {
              return "\"123\"";
          }
      });
    Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println(thread);
    return;
    }
}
