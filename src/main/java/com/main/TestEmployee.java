package com.main;

public class TestEmployee {

	
	public static void main(String[] args) {
		
		Employee john=new Employee();

		john.setSalary(40000);
		john.setBonus(50000);
		
		john.calculateSalary();
		
		System.out.println(john.getSalary());
	}
}
