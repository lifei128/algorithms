package com.lifeibigdata.future;

/**
 * Created by lifei on 2018/6/29.
 */
public class Test {
    public static void main(String[] args) {
        BasicCompute computeActor = new BasicComputeImpl(
                new DefaultComputeFutureImpl(false));
        ComputeFuture future = computeActor.add(2, 3);
        future.addListener(new ComputeFutureListener() {

            @Override
            public void operationComplete(ComputeFuture future)
                    throws Exception {

                if (future.isSuccess()) {
                    System.out.println(Thread.currentThread().getName()
                            + ",the result is:" + future.getResult());
                }
            }
        });

        System.out.println(Thread.currentThread().getName()+ ",let's wait the result...");
    }
}
