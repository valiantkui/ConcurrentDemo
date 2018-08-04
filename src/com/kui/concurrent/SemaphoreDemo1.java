package com.kui.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo1 {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3,true);
		
		for(int i=1;i<Integer.MAX_VALUE;i++){
			new Thread(new T11(semaphore,i)).start();
		}
		
	}
}

class T11 implements Runnable{
	private Semaphore semaphore = null;
	private int i;
	
	public T11(Semaphore semaphore,int i) {
		this.semaphore = semaphore;
		this.i = i;
	}
	
	@Override
	public void run() {
		try {
			semaphore.acquire();
			System.out.println("�ο�"+i+"�õ���Ʊ����ʼ�������Ϻ�������");
			Thread.sleep(i*1000);
			semaphore.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}