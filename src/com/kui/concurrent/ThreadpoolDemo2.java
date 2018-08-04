package com.kui.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadpoolDemo2 {
	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newCachedThreadPool();
//		service.execute(command);
	
//		Future future = service.submit(new T13());
//		Object obj = future.get();
//		System.out.println(obj);

		Future<String> future = service.submit(new T14());
		String retStr = future.get();
		System.out.println(retStr);
		
		service.shutdown();
	}
}

class T14 implements Callable<String>{

	@Override
	public String call() throws Exception {
		try {
			System.out.println("T14开始执行。。。。");
			Thread.sleep(5000);
			System.out.println("T14执行结束。。。。");
			
			return "return from t14~~~~";
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}

class T13 implements Runnable{

	@Override
	public void run() {
		try {
			System.out.println("T13开始执行。。。。");
			Thread.sleep(5000);
			System.out.println("T13执行结束。。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}