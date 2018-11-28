package com.java8.predicate;

import java.util.function.Predicate;

public class PredicateJoining1 {

	public static void main(String[] args) {
		Predicate<Integer> p1 = (i)->i>10;
		Predicate<Integer> p2 = (i)->i%10==10;
		
		Predicate<Integer> p3 = p1.and(p2);
		System.out.println(p2.test(20));
		/*System.out.println(p3.test(20));
		System.out.println(p3.test(10));
		System.out.println(p3.test(51));
		System.out.println(p3.test(12));*/
		
		
	}

}
