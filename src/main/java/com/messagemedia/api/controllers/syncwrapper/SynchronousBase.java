package com.messagemedia.api.controllers.syncwrapper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class SynchronousBase {
    
    private CountDownLatch lock;
    
 
    public SynchronousBase(int count) {
        this.lock = new CountDownLatch(count);
    }
    
  
    public SynchronousBase() {
        this(1);
    }

  
    protected void markAsDone()
    {
        lock.countDown();
    }
    

    public void await() throws InterruptedException {
        lock.await();
    }
    

    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        boolean t = lock.await(timeout, unit);
        return t;
    }
    
}

