package me.jaypark.java8.interfacechange;

public class DefaultFoo implements Foo , Bar{
	// Foo, Bar 두 인터페이스에 같은 default 메소드가 있으면 컴파일 에러 발생
	// 개발자가 직접 충돌나는 메소드를 오버라이드 해야한다.
	String name;

	public DefaultFoo(String name) {
		this.name = name;
	}
	@Override
	public void printName() {
		System.out.println(this.name);
	}

	@Override
	public String getName() {
		return this.name;
	}

	// default 메소드도 오버라이드 가능하다!!
	@Override
	public void printNameUpperCase() {
		System.out.println(this.name.toUpperCase());
	}
}
