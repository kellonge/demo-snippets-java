package com.kellonge.demo.snippets.java.jdk8.stream;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.kellonge.demo.snippets.java.utils.ThreadTimer;

/**
 * Created by kellonge on 16/10/19.
 */
public class SortObject {

    public static void main(String[] args) {
        //gen list
        List<User> users = Lists.newArrayList();
        Random rand = new Random();
        for (int i = 0; i < 100000; i++) {
            users.add(new User(i + 1, random(5), rand.nextInt(119) + 1));
        }
        //show gen list
        System.out.println("print first 10:" + JSON.toJSONString(users.subList(0, 10)));
        //sort
        ThreadTimer.start();
        List<User> usersSorted = users.stream().sorted((x, y) -> Integer.compare(y.age, x.age))
            .collect(Collectors.toList());
        System.out.println("cost:" + ThreadTimer.end() + "ms");
        //show after sort
        System.out.println("print first 10:" + JSON.toJSONString(usersSorted.subList(0, 10)));
    }

    /**
     * 待排序的类
     */
    static class User {

        Integer id;
        String  name;
        Integer age;

        public User(Integer id, String name, Integer age) {
            this.age = age;
            this.id = id;
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("User{");
            sb.append("age=").append(age);
            sb.append(", id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * 生成随机的字符串
     *
     * @param length
     * @return
     */
    private static String random(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append((char) (ThreadLocalRandom.current().nextInt(33, 128)));
        }
        return builder.toString();
    }
}
