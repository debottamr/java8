package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class RunAsync {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Run a task specified by a Runnable Object asynchronously.
		CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
		    @Override
		    public void run() {
		        // Simulate a long-running Job
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        System.out.println("I'll run in a separate thread than the main thread.");
		    }
		});

		// Block and wait for the future to complete
		Void void1 = future.get();
		
		//You can also pass the Runnable object in the form of a lambda expression -


		// Using Lambda Expression
		CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
		    // Simulate a long-running Job   
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    }
		    System.out.println("I'll run in a separate thread than the main thread.");
		});
		
		// Block and wait for the future to complete
		 Void void2 = future1.get();
		 
		 
	}
}
