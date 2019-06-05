package customhashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	static class Person {
		@Override
		public String toString() {
			return "Person [id=" + id + ", name=" + name + "]";
		}
		private Integer id;
		private String name;
		public Person(Integer id, String name) {
			this.id = id;
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public String getName() {
			return name;
		}
	} 
	
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person(100, "Mohan"));
		list.add(new Person(200, "Sohan"));
		list.add(new Person(300, "Mahesh"));
		int count = 1;
		list.stream().collect(Collectors.toMap(Person::getName, Person::getName));
		Map<Integer, String> map = list.stream()
				.collect(Collectors.toMap(Person::getId, Person::getName, (x, y) -> x+", "+ y));
		
		
		
		List<String> asList = Arrays.asList("Java", "Core Java", "Streams", "Java","Example").parallelStream().sorted().collect(Collectors.toList());
		Map<String, Integer> len2StringMap = asList.stream()
				.collect(Collectors.toMap(Function.identity(), String::length, (oldValue,newValue) -> oldValue , LinkedHashMap::new));
		len2StringMap.forEach((key, value) -> System.out.println(key + " : " + value));
		convertList2Map();
		convertList2Map(list);
		//IntStream.range(0,response.getPlacementDecision().size()).boxed().collect(Collectors.toMap(Function.identity(), Function.identity()));
	}
	
	
	private static void convertList2Map() {
		Map<Integer, Set<String>> len2StringMap = Arrays.asList("Java", "Core Java", "Streams", "Java","Example").stream()
				.collect(Collectors.groupingBy(String::length,Collectors.mapping(Function.identity(),Collectors.toSet())));
		len2StringMap.forEach((key, value) -> System.out.println(key + " : " + value));
	}
	private static void convertList2Map(List<Person> persons) {
		Map<Integer, Person> id2PersonMap =persons.stream()
				.collect(Collectors.toMap(Person::getId ,
						Function.identity())); 
		id2PersonMap.forEach((key, value) -> System.out.println(key + " : " + value));
	}
}
