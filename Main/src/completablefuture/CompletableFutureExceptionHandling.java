package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExceptionHandling {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture.supplyAsync(() -> {
			// Code which might throw an exception
			return "Some result";
		}).thenApply(result -> {
			return "processed result";
		}).thenApply(result -> {
			return "result after further processing";
		}).thenAccept(result -> {
			// do something with the final result
		});
		/*
		 * If an error occurs in the original supplyAsync() task, then none of
		 * the thenApply() callbacks will be called and future will be resolved
		 * with the exception occurred. If an error occurs in first thenApply()
		 * callback then 2nd and 3rd callbacks won’t be called and the future
		 * will be resolved with the exception occurred, and so on.
		 */

		/*
		 * Handle exceptions using exceptionally() callback The exceptionally()
		 * callback gives you a chance to recover from errors generated from the
		 * original Future. You can log the exception here and return a default
		 * value.
		 */
		Integer age = 12;

		CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
		    if(age < 0) {
		        throw new IllegalArgumentException("Age can not be negative");
		    }
		    if(age > 18) {
		        return "Adult";
		    } else {
		        return "Child";
		    }
		}).exceptionally(ex -> {
		    System.out.println("Oops! We have an exception - " + ex.getMessage());
		    return "Unknown!";
		});

		System.out.println("Maturity : " + maturityFuture.get());
		
		
		
		//2. Handle exceptions using the generic handle() method

		
		CompletableFuture<String> maturityFuture1 = CompletableFuture.supplyAsync(() -> {
		    if(age < 0) {
		        throw new IllegalArgumentException("Age can not be negative");
		    }
		    if(age > 18) {
		        return "Adult";
		    } else {
		        return "Child";
		    }
		}).handle((res, ex) -> {
		    if(ex != null) {
		        System.out.println("Oops! We have an exception - " + ex.getMessage());
		        return "Unknown!";
		    }
		    return res;
		});

		System.out.println("Maturity : " + maturityFuture1.get());
	}
}
