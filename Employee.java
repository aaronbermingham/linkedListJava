/*
* File name: Employee.java
* Author: Aaron Bermingham
* Student Number: C17738539
* Description of class: User defined class for employee, contains data for employees, 
* two constructors, getter/setter methods, toString method
*/

package application;

import java.util.Scanner;

public class Employee implements Comparable<Employee> {
	// Employee data
	private String empNum;
	private String empName;
	private int yearsWorked;
	private String courseName;
	private int result;
	
	
	
	// Constructor without parameters
	public Employee() {
		this.empNum = " ";
		this.empName = " ";
		this.yearsWorked = 0;
		this.courseName = " ";
		this.result = 0;
		
	}

	// Constructor with parameters
	public Employee(String empNum, String empName, int yearsWorked, String courseName, int result) 
	{
		Scanner scan = new Scanner(System.in);
		this.empNum = empNum;
		this.empName = empName;
		this.yearsWorked = yearsWorked;
		while (this.yearsWorked < 5) 
		{
				int newYearsWorked;
				//System.out.println(this.yearsWorked);
				System.out.println("Employees with less than five years experience cannot go on training courses");
				System.out.print("Re-enter the amount of years the employees has worked: ");
				newYearsWorked = scan.nextInt();
				//System.out.println(newYearsWorked);
				setYearsWorked(newYearsWorked);
				//System.out.println(this.yearsWorked);
				scan.nextLine();
		}
		if (courseName.startsWith("FOOD"))
		{
			this.courseName = courseName;
			
		}
		else 
		{
			this.courseName = "ERROR";
		}
		this.result = result;
			
	}
	
	// Setters/mutator methods
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public void setYearsWorked(int yearsWorked) {
		this.yearsWorked = yearsWorked;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
	
	

	// Getters/accessor methods
	public String getEmpNum() {
		return this.empNum;
	}

	public String getEmpName() {
		return this.empName;
	}

	public int getYearsWorked() {
		return this.yearsWorked;
	}

	public String getCourseName() {
		return this.courseName;
	}
	
	public int getResult() {
		return this.result;
	}

	
	
	// toString method
	@Override
	public String toString() {
		
		return "\nEmployee number: " + this.empNum + "\nEmployee Name: " + this.empName + "\nNumber of years worked: " + this.yearsWorked + "\nCourse Name: "
				+ this.courseName + "\nResult: " + this.result;
		
	}
	
	// Equals method 
	/*@Override
		public boolean equals(Object obj) {
			if(this == obj) return true; //if ref to this object is same as ref to arg object return true
			if(obj == null) return false; // arg object null,return false
			if(this.getClass() != obj.getClass()) return false; // different classes, return false
			Employee that = (Employee) obj; // Cast arg from Object to Book
			if (!this.empNum.equalsIgnoreCase(that.empNum)) return false; // Any instance variables don't match return false
			if(!this.empName.equalsIgnoreCase(that.empName))return false; // Any instance variables don't match return false
			if(this.yearsWorked != that.yearsWorked) return false; // Any instance variables don't match return false
			if(this.courseName != that.courseName) return false; // Any instance variables don't match return false
			if(this.course != that.course) return false; // Any instance variables don't match return false
			return true;
		
		}*/
	
	public boolean equals(Object obj)
	{
		Employee that = (Employee) obj;
		if (!this.empNum.equalsIgnoreCase(that.empNum)) return false;
		else
		return true;
		
	}
	
	// Personal feature, used for merge sort, could not get it to work unfortunately
	@Override
	public int compareTo(Employee o) {
		if (this.result > o.result) return 1; // return one if this.result is greater
		if (this.result < o.result) return -1; // return minus one if this.result is less
		else return 0; // return zero if both are equal
	}
	
	
	




	
	

	
	
	

}
