package com.lifeibigdata.future;

/**
 * Created by lifei on 2018/6/29.
 */
public interface ComputeFutureListener {
    void operationComplete(ComputeFuture future) throws Exception;
}
