package threadpool;

import java.util.concurrent.ThreadFactory;
public class MyThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(Thread.MAX_PRIORITY );
		System.out.println("---Thread Created---");
		return t;
	}
} 