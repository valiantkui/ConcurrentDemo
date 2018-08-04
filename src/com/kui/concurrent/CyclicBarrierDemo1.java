package com.kui.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo1 {
	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(3);
		
		new Thread(new T6(cb)).start();
		new Thread(new T7(cb)).start();
		new Thread(new T8(cb)).start();
	}
}

class T8 implements Runnable{
	private CyclicBarrier cb = null;
	
	public T8(CyclicBarrier cb) {
		this.cb = cb;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("T8������դ��������ʼ�ȴ�����");
			cb.await();
			System.out.println("T8���ͷ��ˡ�������ִ�С�����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class T7 implements Runnable{
	private CyclicBarrier cb = null;
	
	public T7(CyclicBarrier cb) {
		this.cb = cb;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println("T7������դ��������ʼ�ȴ�����");
			cb.await();
			System.out.println("T7���ͷ��ˡ�������ִ�С�����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class T6 implements Runnable{
	private CyclicBarrier cb = null;
	
	public T6(CyclicBarrier cb) {
		this.cb = cb;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("T6������դ��������ʼ�ȴ�����");
			cb.await();
			System.out.println("T6���ͷ��ˡ�������ִ�С�����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}