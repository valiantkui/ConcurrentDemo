package com.kui.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorsDemo1 {
	public static void main(String[] args) {
		ExecutorService service1 = Executors.newCachedThreadPool();
		ExecutorService service2 = Executors.newFixedThreadPool(10);
		ExecutorService service3 = Executors.newSingleThreadExecutor();
	}
}
