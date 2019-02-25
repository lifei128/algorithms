package com.lifeibigdata.future;

import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by lifei on 2018/6/29.
 */
public class DefaultComputeFutureImpl implements ComputeFuture {

    private static final Throwable CANCELLED = new Throwable();

    private final boolean cancellable;

    private ComputeFutureListener firstListener;
    private List<ComputeFutureListener> otherListeners;
    private boolean done;
    private Throwable cause;
    private int waiters;

    private Object result;

    public Object getResult() {
        return result;
    }

    public DefaultComputeFutureImpl(boolean cancellable) {
        this.cancellable = cancellable;
    }

    @Override
    public synchronized boolean isDone() {
        return done;
    }

    @Override
    public synchronized boolean isSuccess() {
        return done && cause == null;
    }

    @Override
    public synchronized Throwable getCause() {
        if (cause != CANCELLED) {
            return cause;
        } else {
            return null;
        }
    }

    @Override
    public synchronized boolean isCancelled() {
        return cause == CANCELLED;
    }

    @Override
    public void addListener(ComputeFutureListener listener) {
        if (listener == null) {
            throw new NullPointerException("listener");
        }

        boolean notifyNow = false;
        synchronized (this) {
            if (done) {
                notifyNow = true;
            } else {
                if (firstListener == null) {
                    firstListener = listener;
                } else {
                    if (otherListeners == null) {
                        otherListeners = new ArrayList<ComputeFutureListener>(1);
                    }
                    otherListeners.add(listener);
                }
            }
        }

        if (notifyNow) {
            notifyListener(listener);
        }
    }

    @Override
    public void removeListener(ComputeFutureListener listener) {
        if (listener == null) {
            throw new NullPointerException("listener");
        }

        synchronized (this) {
            if (!done) {
                if (listener == firstListener) {
                    if (otherListeners != null && !otherListeners.isEmpty()) {
                        firstListener = otherListeners.remove(0);
                    } else {
                        firstListener = null;
                    }
                } else if (otherListeners != null) {
                    otherListeners.remove(listener);
                }
            }
        }
    }

    @Override
    public ComputeFuture sync() throws InterruptedException {
        await();
        rethrowIfFailed0();
        return this;
    }

    @Override
    public ComputeFuture syncUninterruptibly() {
        awaitUninterruptibly();
        rethrowIfFailed0();
        return this;
    }

    private void rethrowIfFailed0() {
        Throwable cause = getCause();
        if (cause == null) {
            return;
        }

        if (cause instanceof RuntimeException) {
            throw (RuntimeException) cause;
        }

        if (cause instanceof Error) {
            throw (Error) cause;
        }

        throw new RuntimeErrorException((Error) cause);
    }

    @Override
    public ComputeFuture await() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }

        synchronized (this) {
            while (!done) {
                waiters++;
                try {
                    wait();
                } finally {
                    waiters--;
                }
            }
        }
        return this;
    }

    @Override
    public boolean await(long timeout, TimeUnit unit)
            throws InterruptedException {
        return await0(unit.toNanos(timeout), true);
    }

    public boolean await(long timeoutMillis) throws InterruptedException {
        return await0(TimeUnit.MILLISECONDS.toNanos(timeoutMillis), true);
    }
    @Override
    public ComputeFuture awaitUninterruptibly() {
        boolean interrupted = false;
        synchronized (this) {
            while (!done) {
                waiters++;
                try {
                    wait();
                } catch (InterruptedException e) {
                    interrupted = true;
                } finally {
                    waiters--;
                }
            }
        }

        if (interrupted) {
            Thread.currentThread().interrupt();
        }

        return this;
    }
    @Override
    public boolean awaitUninterruptibly(long timeout, TimeUnit unit) {
        try {
            return await0(unit.toNanos(timeout), false);
        } catch (InterruptedException e) {
            throw new InternalError();
        }
    }
    @Override
    public boolean awaitUninterruptibly(long timeoutMillis) {
        try {
            return await0(TimeUnit.MILLISECONDS.toNanos(timeoutMillis), false);
        } catch (InterruptedException e) {
            throw new InternalError();
        }
    }

    private boolean await0(long timeoutNanos, boolean interruptable)
            throws InterruptedException {
        if (interruptable && Thread.interrupted()) {
            throw new InterruptedException();
        }

        long startTime = timeoutNanos <= 0 ? 0 : System.nanoTime();
        long waitTime = timeoutNanos;
        boolean interrupted = false;

        try {
            synchronized (this) {
                if (done || waitTime <= 0) {
                    return done;
                }

                waiters++;
                try {
                    for (;;) {
                        try {
                            wait(waitTime / 1000000, (int) (waitTime % 1000000));
                        } catch (InterruptedException e) {
                            if (interruptable) {
                                throw e;
                            } else {
                                interrupted = true;
                            }
                        }

                        if (done) {
                            return true;
                        } else {
                            waitTime = timeoutNanos
                                    - (System.nanoTime() - startTime);
                            if (waitTime <= 0) {
                                return done;
                            }
                        }
                    }
                } finally {
                    waiters--;
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }
    @Override
    public boolean setSuccess(Object result) {
        synchronized (this) {
            // Allow only once.
            if (done) {
                return false;
            }

            done = true;
            this.result = result;
            if (waiters > 0) {
                notifyAll();
            }
        }

        notifyListeners();
        return true;
    }
    @Override
    public boolean setFailure(Throwable cause) {
        if (cause == null) {
            throw new NullPointerException("cause");
        }

        synchronized (this) {
            // Allow only once.
            if (done) {
                return false;
            }

            this.cause = cause;
            done = true;
            if (waiters > 0) {
                notifyAll();
            }
        }

        notifyListeners();
        return true;
    }
    @Override
    public boolean cancel() {
        if (!cancellable) {
            return false;
        }

        synchronized (this) {
            // Allow only once.
            if (done) {
                return false;
            }

            cause = CANCELLED;
            done = true;
            if (waiters > 0) {
                notifyAll();
            }
        }

        notifyListeners();
        return true;
    }

    private void notifyListeners() {
        if (firstListener != null) {
            notifyListener(firstListener);
            firstListener = null;

            if (otherListeners != null) {
                for (ComputeFutureListener l : otherListeners) {
                    notifyListener(l);
                }
                otherListeners = null;
            }
        }
    }

    private void notifyListener(ComputeFutureListener l) {
        try {
            l.operationComplete(this);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}