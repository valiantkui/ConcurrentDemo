package com.kui.concurrent;

import java.util.concurrent.CountDownLatch;

public abstract class AtomicDemo1 {
	public static int x = 0;
	
	public static void main(String[] args) throws Exception {
		CountDownLatch cdl = new CountDownLatch(2);
		
		new Thread(new T21(cdl)).start();
		new Thread(new T21(cdl)).start();
		
		cdl.await();
		
		System.out.println(x);
	}
	
}

class T21 implements Runnable{
	private CountDownLatch cdl = null;
	
	public T21(CountDownLatch cdl) {
		this.cdl = cdl;
	}

	@Override
	public void run() {
		for(int i = 0;i<10000;i++){
			synchronized(AtomicDemo1.class){
				AtomicDemo1.x = AtomicDemo1.x + 1;
			}
		}
		cdl.countDown();
	}
	
}