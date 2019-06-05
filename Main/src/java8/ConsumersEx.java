package java8;

import java.util.function.Consumer;

public class ConsumersEx {
/*
 Consumers represents operations to be performed on a single input argument.


 */
	public static void main(String[] args) {
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
		greeter.accept(new Person("Luke", "Skywalker"));
	}
}
