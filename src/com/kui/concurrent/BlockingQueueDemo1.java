package com.kui.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo1 {
	public static void main(String[] args) throws Exception {
		//ArrayBlocking�ײ����������ָ�����еĴ�С���޷������ޱ߽�Ķ���
//		BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
		
		//LinkedBlocingQueue�ײ��������������ñ߽��СҲ���Բ����ã����������Ĭ�ϴ�СΪInteger.MaxValue�������Ͽ�����Ϊ��һ�������ƵĶ���
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		
		new Thread(new T1(queue)).start();
		new Thread(new T2(queue)).start();
	}
}

class T2 implements Runnable{
	private BlockingQueue<String> queue = null;
	
	public T2(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			for(int i = 0;i<Integer.MAX_VALUE;i++){
				String str = queue.take();
				System.out.println("���������������ݣ�"+str);
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
class T1 implements Runnable{
private BlockingQueue<String> queue = null;
	
	public T1(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			for(int i = 0;i<Integer.MAX_VALUE;i++){
				String str = "x"+i;
				queue.put(str);
				System.out.println("���������������ݣ�"+str);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
