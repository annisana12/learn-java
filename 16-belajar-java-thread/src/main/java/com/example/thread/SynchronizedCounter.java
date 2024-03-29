package com.example.thread;

public class SynchronizedCounter {
    private Long value = 0L;

//    public synchronized void increment() {
//        value++;
//    }

    public void increment() {
        synchronized (this) {
            value++;
        }
    }

    public Long getValue() {
        return value;
    }
}
