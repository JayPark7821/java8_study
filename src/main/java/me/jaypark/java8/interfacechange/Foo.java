package me.jaypark.java8.interfacechange;

public interface Foo {

	void printName();

	// 나중에 인터페이스를 구현할떄 공통적으로 제공했으면 하는 기능이 추가됨.
	//void printNameUpperCase(); // 이런식으로 작성하면 이 추상메소드를 구현하지 않았기때문에 컴파일 에러
	// 해결방법은 default 키워드로 해결할 수 있다.

	default void printNameUpperCase() {
		System.out.println(getName().toUpperCase());
	}

	String getName();
// 예시
	/** Collection.java
	 *
	 *   default boolean removeIf(Predicate<? super E> filter) {
	 *         Objects.requireNonNull(filter);
	 *         boolean removed = false;
	 *         final Iterator<E> each = iterator();
	 *         while (each.hasNext()) {
	 *             if (filter.test(each.next())) {
	 *                 each.remove();
	 *                 removed = true;
	 *             }
	 *         }
	 *         return removed;
	 *     }
	 */


	//Default method 'toString' overrides a member of 'java.lang.Object'
	// default String toString() {
	//
	// }

	static void printAnything() {
		System.out.println("Foo");
	}
}
