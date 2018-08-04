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
			System.out.println("T10�����˽�����������");
			String result = exchanger.exchange("С����Ģ��");
			System.out.println("T10�յ������ݣ�"+result);
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
			System.out.println("T9�����˽�����������");
			String result = exchanger.exchange("�����ǵػ�");
			System.out.println("T9�յ������ݣ�"+result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}