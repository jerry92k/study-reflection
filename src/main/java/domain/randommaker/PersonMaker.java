package domain.randommaker;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import domain.Person;

public class PersonMaker {

	public static Person[] createRandomPersons() {
		return IntStream.range(0, 100)
			.mapToObj((index) -> makePersonWithRandoms())
			.collect(Collectors.toList())
			.toArray(new Person[0]);
	}

	private static Person makePersonWithRandoms() {
		return new Person(AgeMaker.makeRandomAge(), NameMaker.makeRandomName());
	}
}
