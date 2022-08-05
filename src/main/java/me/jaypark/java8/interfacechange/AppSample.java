package me.jaypark.java8.interfacechange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;

public class AppSample {

	public static void main(String[] args) {
		List<String> name = new ArrayList<>();
		name.add("jay");
		name.add("jh");
		name.add("dh");

		// default void forEach(Consumer<? super T> action) {
		// 	Objects.requireNonNull(action);
		// 	for (T t : this) {
		// 		action.accept(t);
		// 	}
		// }
		// consumer functional interface이다.
		// 인자를 받지만 리턴값이 없는것이 consumer
		// name.forEach(s -> System.out.println("s = " + s));
		name.forEach(System.out::println);


		// @Override
		//     default Spliterator<E> spliterator() {
		//         if (this instanceof RandomAccess) {
		//             return new AbstractList.RandomAccessSpliterator<>(this);
		//         } else {
		//             return Spliterators.spliterator(this, Spliterator.ORDERED);
		//         }
		//     }
		Spliterator<String> spliterator = name.spliterator();
		Spliterator<String> spliterator1 = spliterator.trySplit();
		while(spliterator.tryAdvance(System.out::println));
		System.out.println("=============================================");
		while(spliterator1.tryAdvance(System.out::println));
		// stream의 기반이 바로 이 spliterator이다.


		// default Stream<E> stream() {
		//         return StreamSupport.stream(spliterator(), false);
		//     }
		name.stream();
		System.out.println("=============================================");
		// predicate
		// T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
		name.removeIf(s -> s.startsWith("j"));
		name.forEach(System.out::println);


		// default void sort(Comparator<? super E> c) {
		//         Object[] a = this.toArray();
		//         Arrays.sort(a, (Comparator) c);
		//         ListIterator<E> i = this.listIterator();
		//         for (Object e : a) {
		//             i.next();
		//             i.set((E) e);
		//         }
		//     }
		// Comparator functional interface
		Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
		name.sort(compareToIgnoreCase.reversed());


	}
}
