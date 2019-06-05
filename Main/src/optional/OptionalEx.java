package optional;

import java.util.Optional;

public class OptionalEx {

	public static void main(String[] args) throws Exception {
		User user = new User(667290, "Rajeev Kumar Singh");
		Optional<User> userOptional = Optional.of(user);
		//If the argument supplied to Optional.of() is null, 
		//then it will throw a NullPointerException immediately and the Optional object won’t be created.
		try {
			
			userOptional = Optional.of(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		user = null;
		userOptional = Optional.ofNullable(user);
		if(userOptional.isPresent()) {
		    // value is present inside Optional
		    System.out.println("Value found - " + userOptional.get());
		} else {
		    // value is absent
		    System.out.println("Optional is empty");
		}	
		userOptional.ifPresent(value -> {
		    System.out.println("Value found - " + value);
		});
		
		//Optional’s get() method returns a value if it is present, otherwise it throws NoSuchElementException.
		try {
			user = userOptional.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		User finalUser = (user != null) ? user : new User(0, "Unknown User");
		
		finalUser = userOptional.orElse(new User(0, "Unknown User"));
		
		finalUser = userOptional.orElseGet(() -> {
		    return new User(0, "Unknown User");
		});
		try {
			
			userOptional.orElseThrow(() -> new Exception("User not found with userId "));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(user != null && user.getGender().equalsIgnoreCase("MALE")) {
		    // call a function
		}
		
		userOptional.filter(user1 -> user1.getGender().equalsIgnoreCase("MALE"))
		.ifPresent((user2) -> {
		   System.out.println("present"+user2);
		});
		
		
		//Extracting and transforming values using map()
		
		if(user != null) {
		    Address address = user.getAddress();
		    if(address != null && address.getCountry().equalsIgnoreCase("India")) {
			    System.out.println("User belongs to India");
		    }
		}
		
		userOptional.map(User::getAddress)
		.filter(address -> address.getCountry().equalsIgnoreCase("India"))
		.ifPresent((user2) -> {
		    System.out.println("User belongs to India");
		});
		
		userOptional.map(User::getAddress)
		.filter(address -> address.getCountry().equalsIgnoreCase("India"))
		
		.orElseGet(() -> new Address());
		
		
		// Extract User's address using map() method.
		Optional<Address> addressOptional = userOptional.map(User::getAddress);
		
		// filter address from India
		Optional<Address> indianAddressOptional = addressOptional.filter(address -> address.getCountry().equalsIgnoreCase("India"));
		
		// Print, if country is India
		indianAddressOptional.ifPresent((user1) -> {
		    System.out.println("User belongs to India");
		});
		
		
		//Cascading Optionals using flatMap()
		
		Optional<Optional<Address>> map = userOptional.map(User::getOpAddress);
		addressOptional = userOptional.flatMap(User::getOpAddress);

		


	}
}
