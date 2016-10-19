package com.kellonge.demo.snippets.java.bug;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * ArrayList 非线程安全列表,多线程插入的时候会导致:1.有null值 2.实际插入数量合执行数量不符
 * 这个Demo模拟对列表同时10个线程插入,总共插入1000次
 * 解决方案:
 * 使用线程安全的List,如 CopyOnWriteArrayList
 */
public class ArrayListConcurrentInsert {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        List<Date> dates = new ArrayList<>();
        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Future future = executorService.submit(() -> {
                dates.add(new Date());
            });
            futures.add(future);
        }
        for (Future future : futures) {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(dates.size());
        long count = dates.stream().filter(x -> x != null).count();
        System.out.println(count);
        executorService.shutdown();
    }
}
