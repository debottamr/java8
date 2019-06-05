package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/*
  CompletableFuture.anyOf()
CompletableFuture.anyOf() as the name suggests, returns a new CompletableFuture which is completed when any of the given CompletableFutures complete, with the same result.

Consider the following example -
 */
public class CombiningThreadAnyof {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Result of Future 1";
		});

		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Result of Future 2";
		});

		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Result of Future 3";
		});

		CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);

		System.out.println(anyOfFuture.get()); // Result of Future 2
		/*
		 * In the above example, the anyOfFuture is completed when any of the
		 * three CompletableFutures complete. Since future2 has the least amount
		 * of sleep time, it will complete first, and the final result will be -
		 * Result of Future 2.
		 * 
		 * CompletableFuture.anyOf() takes a varargs of Futures and returns
		 * CompletableFuture<Object>. The problem with CompletableFuture.anyOf()
		 * is that if you have CompletableFutures that return results of
		 * different types, then you won’t know the type of your final
		 * CompletableFuture.
		 */
	}
}
