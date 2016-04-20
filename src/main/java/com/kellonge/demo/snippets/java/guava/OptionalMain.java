package com.kellonge.demo.snippets.java.guava;

import java.util.Date;

import com.google.common.base.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        //null引用
        Optional<Object> absent = Optional.absent();
        //null引用
        Optional<Object> fromNullable = Optional.fromNullable(null);
        //日期引用
        Optional<Date> of = Optional.of(new Date());
        System.out.println("absent " + absent.isPresent());
        System.out.println("fromNullable " + fromNullable.isPresent());
        System.out.println("of " + of.isPresent());
        System.out.println("of " + of.get());
    }

}
