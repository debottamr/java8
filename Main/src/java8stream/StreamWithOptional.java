package java8stream;

import java.util.Optional;

public class StreamWithOptional {

	public static void main(String[] args) {
		Outer outer = new Outer();
		if (outer != null && outer.nested != null && outer.nested.inner != null) {
		    System.out.println(outer.nested.inner.foo);
		}
		Optional.of(new Outer())
	    .flatMap(o -> Optional.ofNullable(o.nested))
	    .flatMap(n -> Optional.ofNullable(n.inner))
	    .flatMap(i -> Optional.ofNullable(i.foo))
	    .ifPresent(System.out::println);
	}
}

class Outer {
    Nested nested;
}

class Nested {
    Inner inner;
}

class Inner {
    String foo;
}

