## 一、BlockingQueue - 阻塞式队列
	ArrayBlockingQueue
	LinkedBlockingQueue

## 二、CountDownLatch - 闭锁、线程递减锁
	需要在创建时指定一个数字
	可以同构await方法产生要给阻塞，直到数字减为0时，阻塞自动被放开
	可以通过countDown方法使数字减减

	通常用来实现一个线程的执行需要等待其他多个线程执行完成的场景

## 三、ConcurrentMap
	可以在并发场景下提供线程安全的Map，和HashTable很像，但是能够提供更好的性能。
	HashTable一旦锁定锁定的是整个Map
	而ConcurrentHashMap在锁定时自锁定正在操作的部分，大大的减少了冲突的可能，自然效率就高


## 四、CyclicBarrier - 栅栏
	适用于希望多个线程在某一个节点找齐，当指定数量的线程都到达该节点时再同时放行接着去执行

## 五、Exchanger - 交换机
	适用于两个线程需要交换对象的场景

## 六、Semaphore - 信号量
	
## 七、ExecutorService 执行器服务 - ThreadPoolExecutor 线程池执行器

1. 手动配置参数创建线程池

	ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3), new RejectedExecutionHandler() {
		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			System.out.println("实在处理不了了，放弃他吧："+r.toString());
			executor.remove(r);
		}
	});


2. 通过Executors工具类来获取采用通用配置的线程池	
	Executors:


		newCachedThreadPool() // 创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。

		newFixedThreadPool(int nThreads) //创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。在任意点，在大多数 nThreads 线程会处于处理任务的活动状态。如果在所有线程处于活动状态时提交附加任务，则在有可用线程之前，附加任务将在队列中等待。

		newSingleThreadExecutor() //创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。



3. 使用线程池
	execute(Runnable)
	submit(Runnable)
	submit(Callable)
	invokeAny(...)
	invokeAll(...)


4. 关闭线程池
	shutdown()
	shutdownNow()

5. 其他ExecutorService
	ScheduledExecutorService它能够将任务延后执行，或者间隔固定时间多次执行


## 八、Lock - 锁
	可以用来替代同步代码块，用起来更加方便
	ReentrantLock
	ReadWriteLock
## 九、原子性操作
	Atomic

================================================================================================================================

## 一、序列化和反序列化概述
	远程方法调用 -- RPC	

	对象本身是存在在内存中的，而对象在内存中存活的状态是无法直接用来保存或传输的，将内存中对象从这种状态转换为可以用字节形式表示便于保存或传输的过程，称为将对象序列化。
	将序列化后的对象恢复为内存中的对象的过程叫做反序列化。

	
	持久化 和 反持久化
		对象存在与内存时，是易失的状态，将对象从这个易失的状态转换为持久化设备中不易丢失的状态的过程叫做持久化	
		将持久化设备中已经持久化了的对象恢复到内存中的过程称为反持久化。
	
	持久化的前提是序列化，但是序列化的目的不一定是持久化。

	
## 二、sun提供的序列化和反序列化
	sun其实从jdk1.0开始就已经提供了原生的序列化反序列化功能。
	主要是通过ObjectOutputStream ObjectInputStream Serializable来实现的	
	
	serialVersionUID

	transient

	缺点：
		1. 只能支持java语言，无法跨语言
		2. 序列化完成后产生的数据量比较大
		3. 执行序列化反序列化操作的效率比较低


## 三、第三方序列化反序列化框架
	1. Avro -- Apache
	2. Google ProtoBuffer -- Google，第三方开源包
	3. Thrift
	.........

	
	GoogleProtoBuffer的使用
		1. 写proto文件
		2. 编译成类文件
		3. 导入类文件进行序列化反序列化	
