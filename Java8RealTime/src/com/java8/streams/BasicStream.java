package com.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStream {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(5);
		l1.add(10);
		l1.add(57);
		l1.add(44);
		l1.add(45);
		l1.add(87);
		l1.add(3);
		l1.add(2);
		System.out.println(l1);
		/*
		 * Java &7 Implementation
		*/
		List<Integer> l2 = new ArrayList<>();
		for (Integer integer : l1) {
			if(integer%2==0)
				l2.add(integer);
		}
		System.out.println(l2);
		
		/*
		 * Java 1.8 Onwords
		*/
		
		/*List<Integer> l3 = l1.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println("Afert Java 1.8 ::::");
		System.out.println(l3);
		*/
		/*List<Integer> l4 = l1.stream().map(i->i*2).collect(Collectors.toList());
		System.out.println(l4);*/ 
		
		long count = l1.stream().filter(i->i>20).count();
		System.out.println(count);
		
		l1 = l1.stream().sorted((i1,i2)->(i1>i2)?-1:(i1<i2)?1:0).collect(Collectors.toList());
		System.out.println(l1);
		
		l1=l1.stream().sorted((i1,i2)->i1.compareTo(i2)).collect(Collectors.toList());
		System.out.println(l1);
		
		int l = l1.stream().sorted().max((i1,i2)->i1.compareTo(i2)).get();
		System.out.println(l);
		
		l1.stream().forEach(i1->System.out.println(i1));
		System.out.println("_________________________________________________");
		l1.stream().forEach(System.out::println);
		
		System.out.println("_________________________________________________");
		
		Stream<?> s = Stream.of("satya",4,53.02,50.574f,'v');
		s.forEach(s1->System.out.println(s1));
		Stream<?> s2 = Stream.of("satya",4,53.02,50.574f,'v');
		s2.forEach(System.out::println);
	}

}
