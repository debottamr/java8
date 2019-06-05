package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 A note about Executor and Thread Pool -
You might be wondering that - Well, I know that the runAsync() and supplyAsync() methods execute their tasks in a separate thread. But, we never created a thread right?

Yes! CompletableFuture executes these tasks in a thread obtained from the global ForkJoinPool.commonPool().

But hey, you can also create a Thread Pool and pass it to runAsync() and supplyAsync() methods to let them execute their tasks in a thread obtained from your thread pool.

All the methods in the CompletableFuture API has two variants - One which accepts an Executor as an argument and one which doesn’t -

// Variations of runAsync() and supplyAsync() methods
static CompletableFuture<Void>  runAsync(Runnable runnable)
static CompletableFuture<Void>  runAsync(Runnable runnable, Executor executor)
static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor)
 */
public class ForkJoinEx {

	public static void main(String[] args) {
		
		Executor executor = Executors.newFixedThreadPool(10);
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    }
		    return "Result of the asynchronous computation";
		}, executor);
		
		
	}
}
