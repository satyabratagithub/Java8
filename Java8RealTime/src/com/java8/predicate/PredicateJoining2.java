package com.java8.predicate;

import java.util.function.Predicate;

public class PredicateJoining2 {

	public static void main(String[] args) {
		
		int x[]= {5,0,7,12,4,13,18,20,23,26,29};
		//int y[]= {1,2,3,5,7,13,17,18};
		Predicate<Integer> p1 = (i)->i>10;
		System.out.println("Elements greater than 10 are :");
		m1(p1,x);
		Predicate<Integer> p2 = (i)->i%2==0;
		System.out.println("Elements divisible by 2 are :");
		m1(p2,x);
		
		System.out.println("Elements Not divisible by 2 are :");
		m1(p2.negate(),x);
		
		System.out.println("Elements Not divisible by 2 and greater than 10 are :");
		m1(p2.negate().and(p1),x);
		
		System.out.println("Elements Not divisible by 2 and less than 10 are :");
		m1(p2.negate().and(p1.negate()),x);
		
		System.out.println("Elements Not divisible by 2 or less than 10 are :");
		m1(p2.negate().or(p1.negate()),x);
		
		/*Predicate<Integer> p3 = (i)->{
			//(i%2==0)&&(i%3==0);
			for (int j = 0; j < y.length; j++) {
				for (int k = 1; k <y[j]; k++) {
					if(y[j]%k!=0) {
						return true;
					}
				}
			}
			return false;
		};
		System.out.println("prime nos  are :");
		m1(p3,y);*/
		
		/*Predicate<Integer> p1 = (i)->i>10;
		Predicate<Integer> p2 = (i)->i%2==0;
		
		Predicate<Integer> p3 = p1.and(p2);

		System.out.println(p3.test(20));
		System.out.println(p3.test(10));
		System.out.println(p3.test(51));
		System.out.println(p3.test(12));*/
		
		
	}

	private static void m1(Predicate<Integer> p, int[] x) {
		for (int i : x) {
			if(p.test(i)) {
				System.out.println(i);
			}
			
		}
		
		
	}

}
