package com.java8.functionalInterface;

@FunctionalInterface
public interface ComplexFuncInterface extends SimpleFunctionalInterface {

	default public void doWork() {
		System.out.println("doWork() executed...");
	}
	
	default public void doOtherWork() {
		System.out.println("doOtherWork() executed ...");
	}
	
	
}
