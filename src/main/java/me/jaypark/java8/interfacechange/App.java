package me.jaypark.java8.interfacechange;

public class App {

	public static void main(String[] args) {
		Foo foo = new DefaultFoo("jay");
		foo.printName();
		foo.printNameUpperCase();

		// 스태틱 메소드
		// 해당 타입 관련, 헬퍼 또는 유틸리티 메소드 제공할때 인터페이스에 스태틱 메소드로 제공 가능능
		Foo.printAnything();

	}
}
