package completablefuture;

import java.util.concurrent.CompletableFuture;


/*
 Let’s say that you want to fetch the details of a user from a remote API service and once the user’s detail is available, you want to fetch his Credit rating from another service.

Consider the following implementations of getUserDetail() and getCreditRating() methods -
 */
public class CombiningThread {

	public static void main(String[] args) {
		//Now, Let’s understand what will happen if we use thenApply() to achieve the desired result -
		CompletableFuture<CompletableFuture<Double>> result = getUsersDetail("1")
				.thenApply(user -> getCreditRating(user));
		
		/*
		 In earlier examples, the Supplier function passed to thenApply() callback would return a simple value but in this case, it is returning a CompletableFuture. 
		 Therefore, the final result in the above case is a nested CompletableFuture.
		 If you want the final result to be a top-level Future, use thenCompose() method instead -
		 */
		
		CompletableFuture<Double> result1 = getUsersDetail("1")
		.thenCompose(user -> getCreditRating(user));
		/*
		 So, Rule of thumb here - If your callback function returns a CompletableFuture, and you want a flattened result from the CompletableFuture chain (which in most cases you would), then use thenCompose().


		 */
	}
	
	private static CompletableFuture<Integer> getUsersDetail(String userId) {
		return CompletableFuture.supplyAsync(() -> {
			return UserService.getUserDetails(userId);
		});	
	}
		
	private	static CompletableFuture<Double> getCreditRating(Integer user) {
			return CompletableFuture.supplyAsync(() -> {
				return CreditRatingService.getCreditRating(user);
			});
		}
	
}
