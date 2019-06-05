package completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/*
  CompletableFuture.allOf()
CompletableFuture.allOf is used in scenarios when you have a List of independent futures that you want to run in parallel and do something after all of them are complete.

Let’s say that you want to download the contents of 100 different web pages of a website. You can do this operation sequentially but this will take a lot of time. So, you have written a function which takes a web page link, and returns a CompletableFuture, i.e. 
It downloads the web page’s content asynchronously -
 */
public class CombingingThread3Allof {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		List<String> webPageLinks = Arrays.asList("1", "2","3", "4", "5");	// A list of 100 web page links

		// Download contents of all the web pages asynchronously
		List<CompletableFuture<String>> pageContentFutures = webPageLinks.stream()
		        .map(webPageLink -> downloadWebPage(webPageLink))
		        .collect(Collectors.toList());
		
		//Now, when all the web pages are downloaded, you want to count the number of web pages that contain a keyword - ‘CompletableFuture’. 
		//Let’s use CompletableFuture.allOf() to achieve this -
		
		// Create a combined Future using allOf()
		CompletableFuture<Void> allFutures = CompletableFuture.allOf(
		        pageContentFutures.toArray(new CompletableFuture[pageContentFutures.size()])
		);
		
		/*
		 The problem with CompletableFuture.allOf() is that it returns CompletableFuture<Void>. 
		 But we can get the results of all the wrapped CompletableFutures by writing few additional lines of code -
		 */
		
		
		// When all the Futures are completed, call `future.join()` to get their results and collect the results in a list -
		CompletableFuture<List<String>> allPageContentsFuture = allFutures.thenApply(v -> {
		   return pageContentFutures.stream()
		           .map(pageContentFuture -> pageContentFuture.join())
		           .collect(Collectors.toList());
		});
		
		//Take a moment to understand the above code snippet. 
		//Since we’re calling future.join() when all the futures are complete, we’re not blocking anywhere :-)
		
		//The join() method is similar to get(). 
		//The only difference is that it throws an unchecked exception if the underlying CompletableFuture completes exceptionally.
		// Count the number of web pages having the "CompletableFuture" keyword.
		CompletableFuture<Long> countFuture = allPageContentsFuture.thenApply(pageContents -> {
		    return pageContents.stream()
		            .filter(pageContent -> pageContent.contains("CompletableFuture"))
		            .count();
		});
		
		System.out.println("Number of Web Pages having CompletableFuture keyword - " +  countFuture.get());
	}
	private static CompletableFuture<String> downloadWebPage(String pageLink) {
		return CompletableFuture.supplyAsync(() -> {
			return "1";
		});
	}
}
