package me.jaypark.java8;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

	public static void main(String[] args) {
		// Supplier<Integer> get10 = () ->{
		// 	return 10;
		// };
		// 한줄이면 생략 가능

		//T 타입의 값을 제공하는 함수 인터페이스
		Supplier<Integer> get10 = () -> 10;

		// Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수
		// 인터페이스
		UnaryOperator<Integer> plus10 = (i) -> i + 10;

		// BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입렵값 두개를 받아 리턴하는
		// 함수 인터페이스
		BinaryOperator<Integer> sum = (a, b) -> a + b;

		App app = new App();
		app.run();


	}

	private void run() {
		int baseNumber = 10;

		// 로컬 클래스
		class LocalClass{
			void printBaseNumber() {
				int baseNumber = 11;
				System.out.println("baseNumber = " + baseNumber); // 11출력  쉐도잉
			}
		}

		// 익명 클래스
		Consumer<Integer> integerConsumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer baseNumber) {
				System.out.println("baseNumber = " + baseNumber); // 더이상  int baseNumber = 10; 참조하지 않음 쉐도잉
			}
		};

		// 람다
		// Consumer T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
		// Variable used in lambda expression should be final or effectively final
		IntConsumer printInt = (i) -> {
			// int baseNumber = 11; // 람다는 run()과 같은 scope 재정의 불가능
			System.out.println( i + baseNumber);
		};

		// 람다, 로컬 클래스, 익명 클래스 모두 baseNumber를 참조할 수 있다. final일 경우만!!!!!!!
		// 자바 8 부터는 effective final 인 경우 final을 생략 가능하고 참조 가능
		// 만약 final이 아니라면 참조 할 수 없다!!!


		// 람다에서
		printInt.accept(10);
	}

}
