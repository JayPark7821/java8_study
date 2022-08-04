package me.jaypark.java8;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class GreetingApp {

	public static void main(String[] args) {

		// 메소드 레퍼런스
		// :: -> 메소드 레퍼런스다.


		// 스태틱 메소드 참조
		// 타입 :: 스태틱 메소드
		// UnaryOperator<String> hi = (s) -> "hi " + s;
		UnaryOperator<String> hi = Greeting::hi;
		// UnaryOperator<String> 의 구현체로 Greeting의 static 메소드인 hi를 사용하겠다 선언한거임


		// 특정 객체의 인스턴스 메소드 참조
		// 객체 래퍼런스 :: 인스턴스 메소드
		Greeting greeting = new Greeting();
		UnaryOperator<String> hello = greeting::hello;
		String jay = hello.apply("jay");


		// 생성자 참조
		// 타입 :: new
		//입력값은 없는데 특정 타입을 리턴 해줌 Supplier<>
		Supplier<Greeting> newGreeting =Greeting::new;
		Greeting generatedGreeting = newGreeting.get();

		// 생성자 참조
		// 타입 :: new
		// String을 받는 생성자를 사용한다.
		Function<String, Greeting> jayGreeting = Greeting::new;
		Greeting apply = jayGreeting.apply("jay");
		System.out.println("apply.getName() = " + apply.getName());


		// 임의 객체의 인스턴스 메소드 참조
		String[] names = {"keesun", "jay", "toby"};
		Arrays.sort(names,String::compareToIgnoreCase);
		System.out.println("Arrays.toString(names) = " + Arrays.toString(names));

	}

}
