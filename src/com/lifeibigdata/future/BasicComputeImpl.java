package com.lifeibigdata.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lifei on 2018/6/29.
 */
public class BasicComputeImpl implements BasicCompute {

    private ComputeFuture future;
    // 执行异步任务的线程池
    private ExecutorService executor = Executors.newCachedThreadPool();

    public BasicComputeImpl(ComputeFuture future) {
        this.future = future;
    }

    @Override
    public ComputeFuture add(int a, int b) {

        executor.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ",start to compute......");
                int result = a+b;
                System.out.println(Thread.currentThread().getName()  +",got the result:" + result);
                future.setSuccess(result);
            }
        });
        return future;
    }
}

