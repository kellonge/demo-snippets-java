package com.kellonge.demo.snippets.java.jdk8.stream;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by kellonge on 16/10/18.
 */
public class SortSimple {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt());
        }
        System.out.println("before sort:" + JSON.toJSONString(list));
        list.sort(Comparator.comparing(x -> x));
        System.out.println("after sort:" + JSON.toJSONString(list));
    }
}
