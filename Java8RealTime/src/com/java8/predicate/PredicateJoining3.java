package com.java8.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateJoining3 {

	public static void main(String[] args) {
		
		String names[]= {"Ravi"," ","sfjsdf","",null,"assdfs"};
		List<String> list=new ArrayList<>(); 
		
		Predicate<String> p= s -> s!=null && s.trim().length()!=0;
		
		for (String string : names) {
			if(p.test(string)) {
				list.add(string);
			}
		}
		System.out.println(list);
	}



}
