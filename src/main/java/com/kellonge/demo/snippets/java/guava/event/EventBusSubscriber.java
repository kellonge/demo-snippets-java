package com.kellonge.demo.snippets.java.guava.event;

import java.util.Date;

import com.google.common.eventbus.Subscribe;

/**
 * 
 * 
 * @author kellonge
 * @version $Id: EventBusSubscriber.java, v 0.1 2016年4月19日 下午1:47:56 kellonge Exp $
 */
public class EventBusSubscriber {

    @Subscribe
    public void handleStringEvent(String str) throws Exception {
        Thread.sleep(100L);
        System.out
            .println("thread[" + Thread.currentThread().getName() + "] " + new Date() + "@handleStringEvent:" + str);
    }

    @Subscribe
    public void handleDoubleEvent(Double d) throws Exception {
        Thread.sleep(100L);
        System.out
            .println("thread[" + Thread.currentThread().getName() + "] " + new Date() + "@handleDoubleEvent:" + d);
    }

    @Subscribe
    public void handleDoubleEvent1(Double d) throws Exception {
        Thread.sleep(100L);
        System.out
            .println("thread[" + Thread.currentThread().getName() + "] " + new Date() + "@handleDoubleEvent1:" + d);
    }
}
