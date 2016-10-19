package com.kellonge.demo.snippets.java.utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by kellonge on 16/10/19.
 */
public class ThreadTimer {

    private static ThreadLocal<Long> startTime = new ThreadLocal<>();

    public static void start() {
        startTime.set(System.nanoTime());
    }

    public static Long end() {
        if (startTime.get() == null) {
            throw new IllegalStateException("time not started");
        }
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime.get());
    }
}
