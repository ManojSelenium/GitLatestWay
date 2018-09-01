package com.main;

public class Employee {

	
	private double salary;
	private double bonus;

	
	
	public void setSalary(double salary) {
		if(salary>=10000 && salary <=100000){
		this.salary=salary;
		}else {
			this.salary=0;
			System.out.println("Please enter valid number");
		}
	}

	public double getSalary() {
		return this.salary;
	}
	public void setBonus(double bonus) {
		this.bonus=bonus;
	}
	public void calculateSalary() {
		double totalSalary=salary+bonus;
		System.out.println(totalSalary);
	}
}
