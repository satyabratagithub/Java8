package com.java8.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Employee{
	String empId;
	String empName;
	String empDesg;
	Double salary;
	public Employee(String empId, String empName, String empDesg, Double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesg = empDesg;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesg=" + empDesg + ", salary=" + salary
				+ "]";
	};
	
	
}
public class EmployeeFilter {

	public static void main(String[] args) {
	
		List<Employee> listEmp=new ArrayList<>();
		populate(listEmp);
		
		Predicate<Employee> empPred1 = emp->emp.empDesg.equalsIgnoreCase("developer");
		System.out.println("Employees who are developers::::::::");
		display(empPred1,listEmp);
		
		Predicate<Employee> empPred2 = emp->emp.salary>30000;
		System.out.println("Employees whose salary>30000 are ::::");
		display(empPred2,listEmp);
		
		System.out.println("Employees who are developers and salary>30000 are ::::");
		display(empPred1.and(empPred2),listEmp);
		
		System.out.println("Employees who are developers or salary>30000 are ::::");
		display(empPred1.or(empPred2),listEmp);
		
		System.out.println("Employees who are not developers::::::::");
		display(empPred1.negate(),listEmp);
		
		Predicate<Employee> empPred3 = Predicate.isEqual(listEmp.get(2));
		//System.out.println(empPred3.test(listEmp.get(1)));
		System.out.println(":::::::::::::::::::::::::::::::");
		display(empPred3,listEmp);
		
	}

	private static void display(Predicate<Employee> empPred1, List<Employee> listEmp) {
		for (Employee employee : listEmp) {
			if (empPred1.test(employee)) {
				System.out.println(employee);
			}
		}
		
	}

	private static void populate(List<Employee> listEmp) {
		listEmp.add(new Employee("101", "abc", "developer", 30000.00));
		listEmp.add(new Employee("102", "def", "manager", 80000.00));
		listEmp.add(new Employee("103", "ghi", "lead", 60000.00));
		listEmp.add(new Employee("104", "jkl", "developer", 35000.00));
		listEmp.add(new Employee("105", "mno", "developer", 55000.00));
		listEmp.add(new Employee("106", "pqr", "lead", 65000.00));
		listEmp.add(new Employee("107", "stu", "manager", 100000.00));
		listEmp.add(new Employee("108", "vaw", "developer", 20000.00));
		listEmp.add(new Employee("109", "xyz", "developer", 25000.00));
		
	}
}
