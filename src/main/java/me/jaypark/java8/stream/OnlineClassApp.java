package me.jaypark.java8.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OnlineClassApp {
	public static void main(String[] args) {
		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(2, "spring data jpa", true));
		springClasses.add(new OnlineClass(3, "spring mvc", false));
		springClasses.add(new OnlineClass(4, "spring core", false));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		List<OnlineClass> javaClasses = new ArrayList<>();
		javaClasses.add(new OnlineClass(6, "The Java Test", true));
		javaClasses.add(new OnlineClass(7, "The Java code manipulation", true));
		javaClasses.add(new OnlineClass(8, "The Java 8 to 11", false));

		List<List<OnlineClass>> jayEvents = new ArrayList<>();
		jayEvents.add(springClasses);
		jayEvents.add(javaClasses);


		System.out.println("Spring 으로 시작하는 수업");
		// TODO
		springClasses.stream()
			.filter(c -> c.getTitle().startsWith("spring"))
			.forEach(c -> System.out.println(c.getId()));

		System.out.println("close 되지 않은 수업");
		// TODO
		springClasses.stream()
			// .filter(c -> !c.isClosed())
			// .forEach(c -> System.out.println(c.getId()));
			.filter(Predicate.not(OnlineClass::isClosed))
			.forEach(c -> System.out.println(c.getId()));

		System.out.println("수업 이름만 모아서 스트림 만들기");
		// TODO
		springClasses.stream()
			.map(c -> c.getTitle()) // String으로 변경
			.forEach(System.out::println);

		System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
		// TODO
		jayEvents.stream().flatMap(Collection::stream)
			.forEach(c -> System.out.println(c.getId()));

		System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에서 10개 뺴고 최대 10개 까지만");
		Stream.iterate(10, i -> i + 1 )
			.skip(10)
			.limit(10)
			.forEach(System.out::println);

		System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
		boolean test = javaClasses.stream().anyMatch(c -> c.getTitle().contains("Test"));
		System.out.println("test = " + test);

		System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
		List<String> spring = springClasses.stream().filter(c -> c.getTitle().contains("spring"))
			.map(OnlineClass::getTitle)
			.collect(Collectors.toList());
		spring.forEach(System.out::println);
	}
}
