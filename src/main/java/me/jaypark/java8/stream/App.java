package me.jaypark.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("jay");
		names.add("jh");
		names.add("dh");

		//stream -> Functional in nature 스트림이 처리하는 데이터 소스를 변경하지 않는다.
		Stream<String> stringStream = names.stream().map(String::toUpperCase);
		// 또다른 스트림을 return 원본 데이터는 변경되지 않는다.


		// 중개 오퍼레이션
		// stream을 리턴한다.
		// lazy 하다
		// 종료 오퍼레이터가 오기전까지 실행 안함
		names.stream().map((s) -> {
			System.out.println(s+ "<<<<<<");
			return s.toUpperCase();
		});

		List<String> collect = names.stream().map((s) -> {
			System.out.println(s + ">>>>>>");
			return s.toUpperCase();
		}).collect(Collectors.toList());

		collect.forEach(System.out::println);
		System.out.println("=====================");
		names.forEach(System.out::println);

		// 종료 오퍼레이션
		// stream을 리턴하지 않는다.
		// 종료 오퍼레이터는 반드시 있어야한다.
		// 종료 오퍼레이터 없이는 중개 오퍼레이터는 의미가 없다.

		// Stream 병렬 처리
		// 데이터가 많은 경우가 아니라면....... 그냥 stream()
		//case마다 다르다 직접 테스트 해보고 적용
		//
		// spliterator 를 사용하여 자른다!
		//    default Stream<E> parallelStream() {
		//         return StreamSupport.stream(spliterator(), true);
		//     }
		List<String> collect1 = names.parallelStream().map((s) -> {
			System.out.println(s + " " + Thread.currentThread().getName());
			return s.toUpperCase();
		}).collect(Collectors.toList());
		collect1.forEach(System.out::println);
	}
}
