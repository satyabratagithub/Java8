package com.java8.predicate;

import java.util.function.Predicate;

class SoftEngg{
	String name;
	int age;
	boolean isHavingGF;
	public SoftEngg(String name, int age, boolean isHavingGF) {
		super();
		this.name = name;
		this.age = age;
		this.isHavingGF = isHavingGF;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", isHavingGF=" + isHavingGF + "]";
	}
	
}
public class StudentInPub {

	public static void main(String[] args) {

		Predicate<SoftEngg> stP = se -> se.age >= 18 && se.age < 60 && se.isHavingGF;

		SoftEngg[] softEnggs = { new SoftEngg("satya", 26, false), new SoftEngg("naveen", 26, true),
				new SoftEngg("jagu", 29, true), new SoftEngg("hari", 16, true), new SoftEngg("xyz", 62, false),
				new SoftEngg("dfs", 65, true) };
		System.out.println("SoftEnggs allowed to pub are::::");
		for (SoftEngg softEngg : softEnggs) {
			if (stP.test(softEngg)) {
				System.out.println(softEngg);
			}
		}

	}

}
