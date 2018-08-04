package com.kui.concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerDemo1 {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		new Thread(new T9(exchanger)).start();
		new Thread(new T10(exchanger)).start();
	}
}

class T10 implements Runnable{
	private Exchanger<String> exchanger = null;
	
	public T10(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println("T10到达了交换机。。。");
			String result = exchanger.exchange("小鸡炖蘑菇");
			System.out.println("T10收到了数据："+result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class T9 implements Runnable{
	private Exchanger<String> exchanger = null;
	
	public T9(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("T9到达了交换机。。。");
			String result = exchanger.exchange("天王盖地虎");
			System.out.println("T9收到了数据："+result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}