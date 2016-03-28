package com.kellonge.demo.snippets.java.concurrent.event;

public class EventBusMain {
	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			EventBus.post("scs");
			EventBus.post(1.01D);
		}
		System.out.println(11);
	}
}
