package java8stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Stream3ResuseStream {

	public static void main(String[] args) {
		// Reusing Streams

				Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));

				stream.anyMatch(s -> true); // ok
				try {
					stream.noneMatch(s -> true); // exception
				} catch (Exception e) {
					e.printStackTrace();
				}

				// Each call to get() constructs a new stream on which we are save to
				// call the desired terminal operation.

				Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c")
						.filter(s -> s.startsWith("a"));

				streamSupplier.get().anyMatch(s -> true); // ok
				streamSupplier.get().noneMatch(s -> true); // ok
	}
}
