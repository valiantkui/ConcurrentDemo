## һ��BlockingQueue - ����ʽ����
	ArrayBlockingQueue
	LinkedBlockingQueue

## ����CountDownLatch - �������̵߳ݼ���
	��Ҫ�ڴ���ʱָ��һ������
	����ͬ��await��������Ҫ��������ֱ�����ּ�Ϊ0ʱ�������Զ����ſ�
	����ͨ��countDown����ʹ���ּ���

	ͨ������ʵ��һ���̵߳�ִ����Ҫ�ȴ���������߳�ִ����ɵĳ���

## ����ConcurrentMap
	�����ڲ����������ṩ�̰߳�ȫ��Map����HashTable���񣬵����ܹ��ṩ���õ����ܡ�
	HashTableһ������������������Map
	��ConcurrentHashMap������ʱ���������ڲ����Ĳ��֣����ļ����˳�ͻ�Ŀ��ܣ���ȻЧ�ʾ͸�


## �ġ�CyclicBarrier - դ��
	������ϣ������߳���ĳһ���ڵ����룬��ָ���������̶߳�����ýڵ�ʱ��ͬʱ���н���ȥִ��

## �塢Exchanger - ������
	�����������߳���Ҫ��������ĳ���

## ����Semaphore - �ź���
	
## �ߡ�ExecutorService ִ�������� - ThreadPoolExecutor �̳߳�ִ����

1. �ֶ����ò��������̳߳�

	ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3), new RejectedExecutionHandler() {
		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			System.out.println("ʵ�ڴ������ˣ��������ɣ�"+r.toString());
			executor.remove(r);
		}
	});


2. ͨ��Executors����������ȡ����ͨ�����õ��̳߳�	
	Executors:


		newCachedThreadPool() // ����һ���ɸ�����Ҫ�������̵߳��̳߳أ���������ǰ������߳̿���ʱ���������ǡ�����ִ�кܶ�����첽����ĳ�����ԣ���Щ�̳߳�ͨ������߳������ܡ�

		newFixedThreadPool(int nThreads) //����һ�������ù̶��߳������̳߳أ��Թ�����޽���з�ʽ��������Щ�̡߳�������㣬�ڴ���� nThreads �̻߳ᴦ�ڴ�������Ļ״̬������������̴߳��ڻ״̬ʱ�ύ�������������п����߳�֮ǰ�����������ڶ����еȴ���

		newSingleThreadExecutor() //����һ��ʹ�õ��� worker �̵߳� Executor�����޽���з�ʽ�����и��̡߳�



3. ʹ���̳߳�
	execute(Runnable)
	submit(Runnable)
	submit(Callable)
	invokeAny(...)
	invokeAll(...)


4. �ر��̳߳�
	shutdown()
	shutdownNow()

5. ����ExecutorService
	ScheduledExecutorService���ܹ��������Ӻ�ִ�У����߼���̶�ʱ����ִ��


## �ˡ�Lock - ��
	�����������ͬ������飬���������ӷ���
	ReentrantLock
	ReadWriteLock
## �š�ԭ���Բ���
	Atomic

================================================================================================================================

## һ�����л��ͷ����л�����
	Զ�̷������� -- RPC	

	�������Ǵ������ڴ��еģ����������ڴ��д���״̬���޷�ֱ�������������ģ����ڴ��ж��������״̬ת��Ϊ�������ֽ���ʽ��ʾ���ڱ������Ĺ��̣���Ϊ���������л���
	�����л���Ķ���ָ�Ϊ�ڴ��еĶ���Ĺ��̽��������л���

	
	�־û� �� ���־û�
		����������ڴ�ʱ������ʧ��״̬��������������ʧ��״̬ת��Ϊ�־û��豸�в��׶�ʧ��״̬�Ĺ��̽����־û�	
		���־û��豸���Ѿ��־û��˵Ķ���ָ����ڴ��еĹ��̳�Ϊ���־û���
	
	�־û���ǰ�������л����������л���Ŀ�Ĳ�һ���ǳ־û���

	
## ����sun�ṩ�����л��ͷ����л�
	sun��ʵ��jdk1.0��ʼ���Ѿ��ṩ��ԭ�������л������л����ܡ�
	��Ҫ��ͨ��ObjectOutputStream ObjectInputStream Serializable��ʵ�ֵ�	
	
	serialVersionUID

	transient

	ȱ�㣺
		1. ֻ��֧��java���ԣ��޷�������
		2. ���л���ɺ�������������Ƚϴ�
		3. ִ�����л������л�������Ч�ʱȽϵ�


## �������������л������л����
	1. Avro -- Apache
	2. Google ProtoBuffer -- Google����������Դ��
	3. Thrift
	.........

	
	GoogleProtoBuffer��ʹ��
		1. дproto�ļ�
		2. ��������ļ�
		3. �������ļ��������л������л�	
