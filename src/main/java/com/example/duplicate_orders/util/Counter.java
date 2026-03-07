package com.example.duplicate_orders.util;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
//    private int count = 0;
//
//    public synchronized void increment() {
//        count++;  // ab ek time pe sirf ek thread yahan aayegi
//    }
//
//    public int getCount() { return count; }


    private AtomicInteger count  = new AtomicInteger(0);

    public  void increment(){
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }



}
