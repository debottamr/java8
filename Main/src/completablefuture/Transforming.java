package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 he CompletableFuture.get() method is blocking. It waits until the Future is completed and returns the result after its completion.

But, that’s not what we want right? For building asynchronous systems we should be able to attach a callback to the CompletableFuture which should automatically get called when the Future completes.

That way, we won’t need to wait for the result, and we can write the logic that needs to be executed after the completion of the Future inside our callback function.

You can attach a callback to the CompletableFuture using thenApply(), thenAccept() and thenRun() methods -

1. thenApply()
You can use thenApply() method to process and transform the result of a CompletableFuture when it arrives. 
It takes a Function<T,R> as an argument. Function<T,R> is a simple functional interface representing a function that accepts an argument of type T and produces a result of type R -
 */
public class Transforming {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Create a CompletableFuture
		CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
		   try {
		       TimeUnit.SECONDS.sleep(1);
		   } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		   }
		   return "Rajeev";
		});
		// Attach a callback to the Future using thenApply()
		CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
		   return "Hello " + name;
		});

		System.out.println(greetingFuture.get()); // Hello Rajeev
		
		/*
		 You can also write a sequence of transformations on the CompletableFuture by attaching a series of thenApply() callback methods. 
		 The result of one thenApply() method is passed to the next in the series -
		 */
		
		CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return "Rajeev";
		}).thenApply(name -> {
		    return "Hello " + name;
		}).thenApply(greeting -> {
		    return greeting + ", Welcome to the CalliCoder Blog";
		});

		System.out.println(welcomeText.get());
		//
		
		
		
		
		/*
		 thenAccept() and thenRun()
If you don’t want to return anything from your callback function and just want to run some piece of code after the completion of the Future, then you can use thenAccept() and thenRun() methods. 
These methods are consumers and are often used as the last callback in the callback chain.

CompletableFuture.thenAccept() takes a Consumer<T> and returns CompletableFuture<Void>. 
It has access to the result of the CompletableFuture on which it is attached. 
		  
		 */
		
		// thenAccept() example
		int productId= 1;
		Executor executor = Executors.newFixedThreadPool(10);
		CompletableFuture.supplyAsync(() -> {
			return ProductService.getProductDetail(productId);
		}, executor).thenAccept(product -> {
			System.out.println("Got product detail from remote service " + product.getName());
		});
		
		
		/*
		 While thenAccept() has access to the result of the CompletableFuture on which it is attached, thenRun() doesn’t even have access to the Future’s result.
		  It takes a Runnable and returns CompletableFuture<Void> -
		 */
		CompletableFuture.supplyAsync(() -> {
			return "1";
			}).thenRun(() -> {
			System.out.println("2");
		});
		
	}
}
