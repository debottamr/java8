package optional;

import java.util.Optional;

public class User {

	private int id;
	private String name;
	private String gender;
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
		
	public Optional<Address> getOpAddress() {
		return Optional.ofNullable(address);
	}

}
