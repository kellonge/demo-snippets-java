package com.kellonge.demo.snippets.java.concurrent.event;

import java.util.Date;

import com.google.common.eventbus.Subscribe;

public class EventBusSubscriber {

	@Subscribe
	public void handleStringEvent(String str) throws Exception {
		Thread.sleep(100L);
		System.out.println(new Date() + "@handleStringEvent:" + str);
	}

	@Subscribe
	public void handleDoubleEvent(Double d) throws Exception{
		Thread.sleep(100L);
		System.out.println(new Date() + "@handleDoubleEvent:" + d);
	}
	
	@Subscribe
	public void handleDoubleEvent1(Double d) throws Exception{
		Thread.sleep(100L);
		System.out.println(new Date() + "@handleDoubleEvent1:" + d);
	}
}
