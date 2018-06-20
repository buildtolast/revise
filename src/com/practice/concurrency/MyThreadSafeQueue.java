package com.practice.concurrency;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Solution {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        ExecutorService es = Executors.newCachedThreadPool();

        MyThreadSafeQueue myThreadSafeQueue = new MyThreadSafeQueue();
        es.submit(new PutThread(myThreadSafeQueue, 1, 0));
        es.submit(new PutThread(myThreadSafeQueue, 2, 0));
        es.submit(new PutThread(myThreadSafeQueue, 3, 0));
        es.submit(new PutThread(myThreadSafeQueue, 4, 0));
        Thread.sleep(5000);
        es.submit(new GetThread(myThreadSafeQueue));
        Thread.sleep(1000);
        es.submit(new GetThread(myThreadSafeQueue));
        Thread.sleep(1000);
        es.submit(new GetThread(myThreadSafeQueue));
        Thread.sleep(1000);

        es.submit(new GetThread(myThreadSafeQueue));
        es.submit(new GetThread(myThreadSafeQueue));
        es.submit(new GetThread(myThreadSafeQueue));

        Thread.sleep(120000);
        es.shutdown();
    }
}

class PutThread implements Runnable {

    MyThreadSafeQueue queue;
    Integer i, t;


    public PutThread(MyThreadSafeQueue queue, Integer i, Integer t) {
        this.queue = queue;
        this.i = i;
        this.t = t;
    }

    @Override
    public void run() {
        queue.put(i);
    }

}

class GetThread implements Runnable {

    MyThreadSafeQueue queue;

    public GetThread(MyThreadSafeQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println("Get  >> " + queue.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

class MyThreadSafeQueue {

    private Set<Integer> set; // 1,2,3 // Thread 1 : Get
    private Lock lock = new ReentrantLock(true);

    public MyThreadSafeQueue() {
        set = new TreeSet<>();
    }

    public void put(Integer value) {
        try {
            lock.lock();
            System.out.println("Put >> " + value);
            set.add(value);
        } finally {
            lock.unlock();
        }
    }

    public Integer get() {
        Integer v = -1;
        try {
            lock.lock();
            if (set.size() > 0) {
                v = set.iterator().next();
                set.remove(v);
            }
        } finally {
            lock.unlock();
        }

        return v;
    }

}
