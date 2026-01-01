package section14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CountNames {

//	Count number of names that starts with Alphabet 'A'

//	@Test
	public static void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Kunal");
		names.add("Ankit");
		names.add("Deepak");
		names.add("Kalyan");
		names.add("Akash");
		names.add("Abhishek");
		names.add("Pappu");
		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}

	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Kunal");
		names.add("Ankit");
		names.add("Deepak");
		names.add("Kalyan");
		names.add("Akash");
		names.add("Abhishek");
		names.add("Pappu");

//		using streams
		Long c = names.stream().filter(s -> s.startsWith("A")).count();

		/*
		 * names.stream(): Converts the collection into a Stream<String>.A stream lets
		 * you process elements in a functional, pipeline style (filter, map, reduce,
		 * etc.).
		 * 
		 * filter is an intermediate operation.It keeps only those elements for which
		 * the condition is true.
		 * 
		 * s->s.startsWith(): a lambda expression meaning for each string s, keep it
		 * only if it starts with "A".
		 * 
		 * count() is a terminal operation.It traverses the stream and returns the
		 * number of elements. Once a terminal operation is called, the stream is
		 * consumed.
		 * 
		 */

		System.out.println("from streams " + c);

		long d = Stream.of("Ankit", "Surb", "Vart").filter(s -> {
//			In a lambda with { }, you must return the boolean condition.
			s.startsWith("A");
			return false;
		}).count();
//		System.out.println(d);

//		to print each of the names in arrayList
		names.stream().forEach(s->System.out.println(s));

//		to print the names start with A
		names.stream().filter(s->s.startsWith("A")).forEach(s->System.out.println(s));

//		to print the names with more than 5 alphabet
		names.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));

//		print names that starts with 'A' and uppercase them and then sort them
//		the map function is used to transform each element of the stream. It takes each element from the stream,
//		applies a function to it, and returns a new stream of the transformed values.
		
		names.stream().filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).sorted()
				.forEach(s -> System.out.println(s));

//		to merge two list
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Kunal");
		list1.add("Ankit");
		list1.add("Deepak");

		List<String> list2 = Arrays.asList("Gan", "Rat", "Lion");

		Stream<String> newStream = Stream.concat(list1.stream(), list2.stream());
		newStream.sorted().forEach(s -> System.out.println(s));

//		to search for a name
//		anyMatch is a terminal operation used to check whether at least one element in the stream matches a given condition.
//		It stops as soon as a match is found.
//		we are creating the new stream 'newStream2' because the 'newStream' has already been operated or closed
		Stream<String> newStream2 = Stream.concat(list1.stream(), list2.stream());
		boolean flag = newStream2.anyMatch(s -> s.equalsIgnoreCase("Lion"));
		Assert.assertTrue(flag);

	}
	
//	@Test
	public void streamCollect() {
		List<String> list3 = Arrays.asList("Gan", "Rat", "Lion");
		List<String> ls =list3.stream().sorted().collect(Collectors.toList());
		System.out.println(ls.get(0));
	}

}
