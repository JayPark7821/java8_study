package me.jaypark.java8.interfacechange;

public interface Bar{

	// void printNameUpperCase();

	default void printNameUpperCase() {
		System.out.println("BAR");
	}


}


