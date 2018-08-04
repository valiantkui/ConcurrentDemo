package com.kui.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo1 {
	public static void main(String[] args) throws Exception {
		//ArrayBlocking底层是数组必须指定队列的大小，无法创建无边界的队列
//		BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
		
		//LinkedBlocingQueue底层是链表，可以设置边界大小也可以不设置，如果不设置默认大小为Integer.MaxValue，基本上可以认为是一个无限制的队列
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
				System.out.println("消费者消费了数据："+str);
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
				System.out.println("生产者生产了数据："+str);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
