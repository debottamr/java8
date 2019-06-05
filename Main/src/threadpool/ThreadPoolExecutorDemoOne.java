package threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemoOne {
	 public static void main(final String[] args) throws Exception {
	        final ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 100, TimeUnit.MILLISECONDS,
	                new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy());
	        executor.execute(new BookReader("Ramayan"));
	        executor.execute(new BookReader("Mahabharat"));
	        executor.execute(new BookReader("Veda"));
	        System.out.println("Old Max Pool Size:"+ executor.getMaximumPoolSize());
	        executor.setMaximumPoolSize(4);
	        System.out.println("New Max Pool Size:"+ executor.getMaximumPoolSize());        
	        executor.shutdown();
	    }
}
