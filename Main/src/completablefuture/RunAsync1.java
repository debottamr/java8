package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/*
 Run a task asynchronously and return the result using supplyAsync() -
CompletableFuture.runAsync() is useful for tasks that don’t return anything. But what if you want to return some result from your background task?

Well, CompletableFuture.supplyAsync() is your companion. It takes a Supplier<T> and returns CompletableFuture<T> where T is the type of the value obtained by calling the given supplier -
 */
public class RunAsync1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Run a task specified by a Supplier object asynchronously
		CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					throw new IllegalStateException(e);
				}
				return "Result of the asynchronous computation";
			}
		});
		
		// Block and get the result of the Future
		String result = future.get();
		System.out.println(result);
		
		/*
		 A Supplier<T> is a simple functional interface which represents a supplier of results.
		  It has a single get() method where you can write your background task and return the result.
		*/
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    }
		    return "Result of the asynchronous computation";
		});
		
		
	}
}

