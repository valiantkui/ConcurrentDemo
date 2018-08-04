package com.kui.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadpoolDemo1 {
	public static void main(String[] args) {
		//�����̳߳�
		ExecutorService service = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(5), new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				System.out.println("�̳߳�ʵ��æ�������ˣ���������߳̾;ܾ��ɣ�"+r);
			}
		});
		
		//���̳߳����ύ����
		for(int i =1 ;i<=16;i++){
			service.execute(new T12(i));
		}
		
	}
}

class T12 implements Runnable{
	private int id = 0;
	public T12(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("�߳�"+id+"�����������ˣ�");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
