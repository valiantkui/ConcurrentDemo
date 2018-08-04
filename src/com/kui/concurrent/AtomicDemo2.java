package com.kui.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AtomicDemo2 {
	public static AtomicInteger x = new AtomicInteger(0);
	
	public static void main(String[] args) throws Exception {
		CountDownLatch cdl = new CountDownLatch(2);
		
		new Thread(new T22(cdl)).start();
		new Thread(new T22(cdl)).start();
		
		cdl.await();
		
		System.out.println(x.get());
	}
	
}

class T22 implements Runnable{
	private CountDownLatch cdl = null;
	
	public T22(CountDownLatch cdl) {
		this.cdl = cdl;
	}

	@Override
	public void run() {
		for(int i = 0;i<10000;i++){
			AtomicDemo2.x.addAndGet(1);
		}
		cdl.countDown();
	}
	
}