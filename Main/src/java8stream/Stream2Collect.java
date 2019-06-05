package java8stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Stream2Collect {
	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
				new Person("David", 12));

		List<Person> filtered = persons.stream().filter(p -> p.name.startsWith("P")).collect(Collectors.toList());

		System.out.println(filtered); // [Peter, Pamela]

		Map<Integer, List<Person>> personsByAge = persons.stream().collect(Collectors.groupingBy(p -> p.age));

		personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

		Double averageAge = persons.stream().collect(Collectors.averagingInt(p -> p.age));

		System.out.println(averageAge); // 19.0

		IntSummaryStatistics ageSummary = persons.stream().collect(Collectors.summarizingInt(p -> p.age));

		System.out.println(ageSummary);
		
		// IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000,
		// max=23}
		
		
		String phrase = persons
			    .stream()
			    .filter(p -> p.age >= 18)
			    .map(p -> p.name)
			    .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
		
		System.out.println(phrase);
		
		
		
		Map<Integer, String> map = persons
			    .stream()
			    .collect(Collectors.toMap(
			        p -> p.age,
			        p -> p.name,
			        (name1, name2) -> name1 + ";" + name2));

			System.out.println(map);
			
			
			Collector<Person, StringJoiner, String> personNameCollector =
				    Collector.of(
				        () -> new StringJoiner(" | "),          // supplier
				        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
				        (j1, j2) -> j1.merge(j2),               // combiner
				        StringJoiner::toString);                // finisher

				String names = persons
				    .stream()
				    .collect(personNameCollector);

				System.out.println(names);  // MAX | PETER | PAMELA | DAVID
	}
}
