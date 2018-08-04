package com.kui.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo2 {
	
	public static String name = "����";
	public static String gender = "��"; 
	
	public static void main(String[] args) {
		
		Lock lock = new ReentrantLock();
		
		new Thread(new T17(lock)).start();
		new Thread(new T18(lock)).start();
	}
	
}

class T17 implements Runnable{
	private Lock lock = null;
	public T17(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		while(true){
			lock.lock();
			if ("����".equals(LockDemo2.name)) {
				LockDemo2.name = "��÷÷";
				LockDemo2.gender = "Ů";
			} else {
				LockDemo2.name = "����";
				LockDemo2.gender = "��";
			}
			lock.unlock();
		}
	}
	
}
class T18 implements Runnable{
	private Lock lock = null;
	public T18(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		while(true){
			lock.lock();
			System.out.println(LockDemo2.name + ":" +LockDemo2.gender);
			lock.unlock();
		}
	}
	
}
