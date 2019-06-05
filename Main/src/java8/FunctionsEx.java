package java8;

import java.util.function.Function;

public class FunctionsEx {
/*
 Functions accept one argument and produce a result. Default methods can be used to chain multiple functions together (compose, andThen).


 */
	public static void main(String[] args) {
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		backToString.apply("123");     // "123"
	}
}
