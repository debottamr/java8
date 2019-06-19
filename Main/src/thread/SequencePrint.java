package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SequencePrint {
	public static void main(String[] args) throws InterruptedException {
		Object obj = new Object();
		Counter counter = new Counter(0);
//		Mythread1 t1 = new Mythread1(0, counter,obj);
//		Mythread1 t2 = new Mythread1(1, counter,obj);
//		Mythread1 t3 = new Mythread1(2, counter,obj);
//		new Thread(t1).start();
//		
//		new Thread(t2).start();
//		new Thread(t3).start();
		
		
		Mythread2 t11 = new Mythread2(0, counter,null);
		Mythread2 t21 = new Mythread2(1, counter,t11);
		Mythread2 t31 = new Mythread2(2, counter,t21);
		
		
		t11.start();
		Thread.sleep(5000);
		t21.start();
		t31.start();
	}
}

class Counter {
	int count;

	public Counter(int count) {
		this.count = count;
	}

}

class Mythread1 implements Runnable {

	Integer threadId;
	StringBuffer str = new StringBuffer();
	Object obj;
	Counter counter;
	static ReentrantLock re = new ReentrantLock(true);
	

	public Mythread1(int start, Counter counter, Object obj) {
		
		threadId = start;
		this.obj = obj;
		this.counter = counter;
	}

	@Override
	public void run() {
		synchronized (obj) {
			while (true) {
				try {
					Thread.sleep(1000);
					if (counter.count % 3 != threadId) {
						obj.wait();
					} else {
						counter.count = counter.count + 1;
						System.out.println(Thread.currentThread().getName() + "  " +  counter.count);
						obj.notifyAll();
					}
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}

class Mythread2 extends Thread {

	Integer threadId;
	StringBuffer str = new StringBuffer();
	Thread prev;
	Counter counter;
	static ReentrantLock re = new ReentrantLock(true);
	static Condition newCondition = re.newCondition();
	

	public Mythread2(int start, Counter counter, Thread prev) {
		
		threadId = start;
		this.prev = prev;
		this.counter = counter;
	}

	@Override
	public void run() {
		while(prev != null && !prev.isAlive()){
			System.out.println("Prev thread not started");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
			while (true) {
				try {
					re.lockInterruptibly();
					Thread.sleep(1000);
					counter.count = counter.count + 1;
					System.out.println(Thread.currentThread().getName() + "  " +  counter.count);
					while(re.getQueueLength() ==0){
						System.out.println("Queue Lenght is zero");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					re.unlock();
					
				}
			}
		
	}
}