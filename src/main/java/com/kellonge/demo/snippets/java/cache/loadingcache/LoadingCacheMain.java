package com.kellonge.demo.snippets.java.cache.loadingcache;

public class LoadingCacheMain {
	public static void main(String[] args) throws InterruptedException {
		while (true) {
			Thread.sleep(100);
			long b = System.currentTimeMillis();
			System.out.println(LoadingCacheUtil.get("ssw"));
			System.out.println("cost:" + (System.currentTimeMillis() - b));
		}
	}
}
