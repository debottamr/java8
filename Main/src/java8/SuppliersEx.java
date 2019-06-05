package java8;

import java.util.function.Supplier;

public class SuppliersEx {
/*
 Suppliers produce a result of a given generic type. Unlike Functions, Suppliers don't accept arguments.


 */
	public static void main(String[] args) {
		Supplier<Person> personSupplier = Person::new;
		personSupplier.get();   // new Person
	}
}
