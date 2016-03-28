package com.kellonge.demo.snippets.java.cache.loadingcache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class LoadingCacheUtil {
	private static LoadingCache<String, Object> cache;
	static {
		cache = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.SECONDS)
				.build(new CacheLoader<String, Object>() {
					@Override
					public Object load(String key) throws Exception {
						return loadData(key);
					}
				});
	}

	public static Object get(String key) {
		try {
			return cache.get(key);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	private LoadingCacheUtil() {

	}

	private static Object loadData(String key) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		File file = new File("/Users/kellonge/Work/workspace_my/snippets/file/LoadingCacheData.json");
		String data = "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tmp = null;

			while ((tmp = reader.readLine()) != null) {
				data += tmp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (data.length() > 0) {
			JSONObject jsonObject = JSONObject.parseObject(data);
			if (jsonObject != null) {
				return jsonObject.get(key);
			}
		}
		return null;
	}
}
