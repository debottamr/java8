package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/*
 A java.util.Stream represents a sequence of elements on which one or more operations can be performed. 
 Stream operations are either intermediate or terminal. 
 While terminal operations return a result of a certain type, intermediate operations return the stream itself 
 so you can chain multiple method calls in a row. 
 Streams are created on a source, e.g. a java.util.Collection like lists or sets (maps are not supported). 
 Stream operations can either be executed sequential or parallel.


Collections in Java 8 are extended so you can simply create streams either by calling Collection.stream() or Collection.parallelStream(). The following sections explain the most common stream operations
 */
public class StreamEx {
	public static void main(String[] args) {

		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		// Filter
		/*
		 * Filter accepts a predicate to filter all elements of the stream. This
		 * operation is intermediate which enables us to call another stream
		 * operation (forEach) on the result. ForEach accepts a consumer to be
		 * executed for each element in the filtered stream. ForEach is a
		 * terminal operation. It's void, so we cannot call another stream
		 * operation.
		 */
		stringCollection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);

		// Sorted

		/*
		 * Sorted is an intermediate operation which returns a sorted view of
		 * the stream. The elements are sorted in natural order unless you pass
		 * a custom Comparator.
		 */

		stringCollection.stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);

		// Map
		/*
		 * The intermediate operation map converts each element into another
		 * object via the given function. The following example converts each
		 * string into an upper-cased string. But you can also use map to
		 * transform each object into another type. The generic type of the
		 * resulting stream depends on the generic type of the function you pass
		 * to map.
		 */
		stringCollection.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a))
				.forEach(System.out::println);

		// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"

		// Match
		/*
		 * Various matching operations can be used to check whether a certain
		 * predicate matches the stream. All of those operations are terminal
		 * and return a boolean result.
		 */

		boolean anyStartsWithA = stringCollection.stream().anyMatch((s) -> s.startsWith("a"));

		System.out.println(anyStartsWithA); // true

		boolean allStartsWithA = stringCollection.stream().allMatch((s) -> s.startsWith("a"));

		System.out.println(allStartsWithA); // false

		boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("z"));

		System.out.println(noneStartsWithZ); // true

		// Count

		// Count is a terminal operation returning the number of elements in the
		// stream as a long.

		long startsWithB = stringCollection.stream().filter((s) -> s.startsWith("b")).count();

		System.out.println(startsWithB); // 3

		// Reduce
		// This terminal operation performs a reduction on the elements of the
		// stream with the given function.
		// The result is an Optional holding the reduced value.

		Optional<String> reduced = stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);

		reduced.ifPresent(System.out::println);
		// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"

		// Parallel Streams#
		/*
		 * As mentioned above streams can be either sequential or parallel.
		 * Operations on sequential streams are performed on a single thread
		 * while operations on parallel streams are performed concurrent on
		 * multiple threads.
		 */
		
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		
		//Sequential Sort#
		long t0 = System.nanoTime();

		long count = values.stream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));
		
		//Parallel Sort#

		t0 = System.nanoTime();

		count = values.parallelStream().sorted().count();
		System.out.println(count);

		t1 = System.nanoTime();

		millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("parallel sort took: %d ms", millis));
		
		//Map
		
		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
		    map.putIfAbsent(i, "val" + i);
		}

		map.forEach((id, val) -> System.out.println(val));
		
		map.computeIfPresent(3, (num, val) -> val + num);
		map.get(3);             // val33

		map.computeIfPresent(9, (num, val) -> null);
		map.containsKey(9);     // false

		map.computeIfAbsent(23, num -> "val" + num);
		map.containsKey(23);    // true

		map.computeIfAbsent(3, num -> "bam");
		map.get(3);
		
		//Next, we learn how to remove entries for a a given key, only if it's currently mapped to a given value:


		map.remove(3, "val3");
		map.get(3);             // val33

		map.remove(3, "val33");
		map.get(3);             // null
		
		//Another helpful method:

		map.getOrDefault(42, "not found");  // not found
		
		//Merging entries of a map is quite easy:
		// Merge either put the key/value into the map if no entry for the key exists,
		//or the merging function will be called to change the existing value.
		
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		map.get(9);             // val9
		
		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		map.get(9);             // val9concat


		



		

	}
}
