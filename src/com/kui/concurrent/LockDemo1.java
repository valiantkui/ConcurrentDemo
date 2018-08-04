package com.kui.concurrent;

/**
 * 锁同步的演示
 * @author KUIKUI
 *
 */
public class LockDemo1 {
	public static String name = "李雷";
	public static String gender = "男"; 
	
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
				if ("李雷".equals(LockDemo1.name)) {
					LockDemo1.name = "韩梅梅";
					LockDemo1.gender = "女";
				} else {
					LockDemo1.name = "李雷";
					LockDemo1.gender = "男";
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
