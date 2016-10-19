package com.kellonge.demo.snippets.java.jdk8.stream;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by kellonge on 16/10/18.
 */
public class SortSimple {


    private static final ExecutorService queryBranchExecutor = Executors
            .newFixedThreadPool(10);

    public static void main(String[] args) {

        List<Date> dates = new ArrayList<>();
        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Future future = queryBranchExecutor.submit(() -> {
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
        queryBranchExecutor.shutdown();

//        List<Integer> list =new ArrayList<>();
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            list.add(random.nextInt());
//        }
//        System.out.println("before sort:"+JSON.toJSONString(list));
//        list.sort(Comparator.comparing(x->x));
//        System.out.println("after sort:"+JSON.toJSONString(list));
    }
}
