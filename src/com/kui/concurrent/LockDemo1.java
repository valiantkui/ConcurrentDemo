package com.kui.concurrent;

/**
 * ��ͬ������ʾ
 * @author KUIKUI
 *
 */
public class LockDemo1 {
	public static String name = "����";
	public static String gender = "��"; 
	
	public static void main(String[] args) {
		new Thread(new T15()).start();
		new Thread(new T16()).start();
	}
	
}

class T16 implements Runnable{

	@Override
	public void run() {
		while(true){
			synchronized (LockDemo1.class) {
				if ("����".equals(LockDemo1.name)) {
					LockDemo1.name = "��÷÷";
					LockDemo1.gender = "Ů";
				} else {
					LockDemo1.name = "����";
					LockDemo1.gender = "��";
				}
			}
		}
	}
	
}
class T15 implements Runnable{
	
	@Override
	public void run() {
		while(true){
			synchronized (LockDemo1.class) {
				System.out.println(LockDemo1.name + ":" +LockDemo1.gender);
			}
		}
	}
	
}
