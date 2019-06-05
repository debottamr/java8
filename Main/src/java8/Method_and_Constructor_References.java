package java8;

public class Method_and_Constructor_References {

	public static void main(String[] args) {
		Converter1<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted);   // 123
		
		
		Something something = new Something("s1");
		Converter1<String, String> converter1 = something::startsWith;
		String converted1 = converter1.convert("Java");
		System.out.println(converted1);    // "J"
		
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
	}
}
@FunctionalInterface
interface Converter1<F, T> {
	T convert(F from);
}

class Something {
	private String face="J>";
	
	Something(String s1){
		
	}
    String startsWith(String s) {
        return face+String.valueOf(s.charAt(0));
    }
}


class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
@FunctionalInterface
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
   // P delete(String firstName, String lastName);
}



