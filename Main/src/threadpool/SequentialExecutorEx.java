package threadpool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class SequentialExecutorEx {
	 public static void main(String[] args) {
		 RunnableThread t1 = new RunnableThread("One");
		 RunnableThread t2 = new RunnableThread("Two");
		 Executor executor = new SequentialExecutor();
		 executor.execute(t1);
		 executor.execute(t2);
	}
}
class RunnableThread implements Runnable{
	private String name;
	
	RunnableThread(String name){
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name);
		
	}
	
}
class SequentialExecutor implements Executor {
	   final Queue<Runnable> queue = new ArrayDeque<Runnable>();
	   Runnable task;
	   public synchronized void execute(final Runnable r) {
		   queue.offer(new Runnable() {
	       public void run() {
	         try {
	           r.run();
	         } finally {
	           next();
	         }
	       }
	     });
	     if (task == null) {
	       next();
	     }
	   }
	   private synchronized void next() {
	     if ((task = queue.poll()) != null) {
	             new Thread(task).start();	         
	       
	     }
	   }
}
