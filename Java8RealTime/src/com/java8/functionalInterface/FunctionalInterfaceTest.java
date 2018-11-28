package com.java8.functionalInterface;

public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		test(new SimpleFunctionalInterface() {
			
			@Override
			public void hello() {
				System.out.println("Simple Functional Interface hello() executed....");
				
			}
		});
		test(()->System.out.println("no simple Args..."));
		
		test(new ComplexFuncInterface() {
			
			@Override
			public void hello() {
				System.out.println("Complex Functional Interface hello() executed....");
				
			}
		});

	}

	private static void test(SimpleFunctionalInterface simpleFunctionalInterface) {
		System.out.println("Test() executed....");
		simpleFunctionalInterface.hello();
	}
	
	

}
