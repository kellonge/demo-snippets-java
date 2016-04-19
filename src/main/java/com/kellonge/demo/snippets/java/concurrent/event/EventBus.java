package com.kellonge.demo.snippets.java.concurrent.event;

import java.util.concurrent.Executors;

import com.google.common.eventbus.AsyncEventBus;

public class EventBus {

    private static AsyncEventBus asyncEventBus;

    static {
        asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(2));
        asyncEventBus.register(new EventBusSubscriber());
    }

    public static void post(Object event) {
        asyncEventBus.post(event);
    }

    private EventBus() {

    }

}
