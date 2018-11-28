package com.java8.predicate;

import java.util.function.Predicate;

public class Predacat1 {
	public static void main(String[] args) {

		Predicate<Integer> p=(i)->(i>10)?true:false;
		
		System.out.println(p.test(100));
		System.out.println(p.test(10));
		
		Predicate<String> p1=(s)->s.isEmpty();
				
		
		System.out.println(p1.test("czccdsfsdfdsfs"));
		System.out.println(p1.test(""));
		
		Predicate<String> p2=(s)->s.length()>5;
				
		
		System.out.println(p2.test("czccdsfs"));
		System.out.println(p2.test("ss"));
	}
}
