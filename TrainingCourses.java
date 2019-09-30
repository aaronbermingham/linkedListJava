/*
* File name: TrainingCourses.java
* Author: Aaron Bermingham
* Student Number: C17738539
* Description of class: Driver class for FoodCo staff training software
*/

package application;

import java.util.Scanner;

import dataStructures.LinkedList;

public class TrainingCourses {
	// ArrayList of books declaration
	LinkedList<Employee> empList;

	public TrainingCourses() {
		empList = new LinkedList<Employee>();
	}

	// 1 Input employee details method
	public void inputEmp() {
		String empNum;
		String empName;
		int yearsWorked;
		//String courseAnswer;
		String courseName;
		int result;
		Employee anEmployee;
		Scanner scan = new Scanner(System.in);

		do {

			System.out.print("Please enter the employees number: ");
			empNum = scan.nextLine();

			System.out.print("Please enter the employees name: ");
			empName = scan.nextLine();

			System.out.print("Please enter the amount of years the employees has worked: ");
			yearsWorked = scan.nextInt();
			scan.nextLine();
			anEmployee = new Employee(empNum, empName, yearsWorked, "" , 0);

			System.out.print("Please enter the name of the course: ");
			courseName = scan.nextLine();
			anEmployee.setCourseName(courseName);
			
			anEmployee = new Employee(empNum, empName, yearsWorked, courseName,0);
			do {
			System.out.print("Please enter the employees result from the course, NB results must be between 0-100: ");
			result = scan.nextInt();
			scan.nextLine();
			}while (result > 100 || result < 0);
			anEmployee = new Employee(empNum, empName, yearsWorked, courseName,result);
				
				if (empList.contains(anEmployee)) {
					System.out.println("Duplicate employee, reenter correct details");
				}
				

			
		} while (empList.contains(anEmployee) == true);

		if (empList.contains(anEmployee) == false) {
			empList.add(anEmployee);
		}
	}

	// 2 Display all employees method
	public void displayAll() {
		if (!empList.isEmpty()) {
			System.out.println("---Employee Course List---\n");
			System.out.println(empList.toString());
			System.out.println();
		} else
			System.out.println("The list is empty");
	}

	// 3 Remove an employee using their employee number method
	public void removeEmpByNum() {
		String empNum;
		Employee tempEmp;
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter employee number that you wish to remove:");
		empNum = scan.nextLine();
		tempEmp = new Employee(empNum, null, 5, "FOOD", 0);
		if (empList.contains(tempEmp)) {
			empList.remove(tempEmp);
		} else
			System.out.println("No employee with that number");

	}

	// 5 Delete all employees on a specified course method
	public void deleteEmpCourse() {
		String courseName;
		Employee first;
		boolean found = false;
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter course you wish to delete employees from: ");
		courseName = scan.nextLine();
		
		/*
		 * Loop using boolean found until it is not found Use first method from
		 * LinkedList class, iterate through linked list, find emp on course and delete
		 * them using standard remove method
		 */

		while (!found) 
			{ // loop continues while found not found
			//found = false; // found set to false
			first = empList.first(); // employee first intialised as first node in the LinkedList
			while (first != null && !found) // loop continues while first is not null and not found				
				{	
					if (courseName.equalsIgnoreCase(first.getCourseName())) // if the course name equals firsts course name
					{
						found = true;
					} 
					 
					else{		
						first = empList.next(first);
					}
				}
			
			
				if(found) 
				{
					empList.remove(first); // if found, the node is removed (dereferenced)	
					found = false;
				}
				
				else {
					found = true;
				}
		
				
			}
		}
	

	
	 /* public void next() { String empNum; Employee tempEmp; String empName = null;
	  int yearsWorked = 0;  
	  String courseName = null;
	  Scanner scan = new Scanner(System.in);
	  
	  System.out.print("Enter employee number that you see adjacent node:"); 
	  empNum = scan.nextLine(); 
	  tempEmp = new Employee(empNum, empName, yearsWorked,courseName); 
	  if(empList.contains(tempEmp)) { 
		  empList.next(tempEmp); 
		  }
	  else 
		  System.out.println("No employee with that number"); 
	  }*/
	  
	 /* public void addPos() { 
		  int position;
		  Scanner scan = new Scanner(System.in);
		  Employee anEmployee;
		  
		  do {

				System.out.print("Please enter the employees number: ");
				String empNum = scan.nextLine();

				System.out.print("Please enter the employees name: ");
				String empName = scan.nextLine();

				System.out.print("Please enter the amount of years the employees has worked: ");
				int yearsWorked = scan.nextInt();
				scan.nextLine();
				anEmployee = new Employee(empNum, empName, yearsWorked, "");

				System.out.print("Please enter the name of the course: ");
				String courseName = scan.nextLine();
				anEmployee.setCourseName(courseName);
				anEmployee = new Employee(empNum, empName, yearsWorked, courseName);
					
					if (empList.contains(anEmployee)) {
						System.out.println("Duplicate employee, reenter correct details");
					}

				
			} while (empList.contains(anEmployee) == true);
		  	System.out.print("Please enter the position: ");
			position = scan.nextInt();
			scan.nextLine();
		  
			if (empList.contains(anEmployee) == false) {
				  empList.add(anEmployee, position);
			}
		
		  
	  }*/
	  
	  
	  /*Personal function - could not properly implement mergesort
	  so this is my alternative personal feature*/
	  public void personalFunction() {
		  String line = "\t-------------------------";
	        int choice; // Variable for user inputted choice
	        Scanner scan= new Scanner(System.in);

	        do{ // Do while loop to return to the menu after a module or method is called
	            System.out.print("\n\tSelect an option by typing the number option and then enter.\n\te.g. if you want to make a delete the entire list, press 2 and then enter\n");
	            System.out.println(line);
	            System.out.print("\n\tPress 1 to remove an employee by postion in the list");
	            System.out.print("\n\tPress 2 to see employees sorted by results ");
	            System.out.print("\n\tPress 3 to delete all from the list");
	            System.out.print("\n\tPress 4 to find an employee by position");
	            System.out.println("\n\tPress 5 to exit the program");
	            System.out.println("\n");
	            System.out.println(line);
	            System.out.print("\n");
	            while (!scan.hasNextInt()) { 
	                System.out.println("\t\t***Please enter a valid numerical option***");
	                scan.nextLine(); 
	            }

	            choice = scan.nextInt(); // Variable to take in user choice for switch case

	            scan.nextLine(); // Clears scanner

	            switch(choice)
	            {   

	                case 1 : 
	                	System.out.println("\f");
	                	removePosition();
	                	break;
	                case 2: 
	                	System.out.println("\f");
	                	avgResult();
	                	break;
	                case 3: 
	                	removeAll();
	                	break;
	                case 4:
	                	nodePostion();
	                	break;
	                case 5:
	                	System.exit(0);
	                	break;
	                default: 
	                	System.out.println("\t\tEnter a valid option");
	                	break;
	            }

	        }while (choice != 5); // Menu loops until 5 is entered
	  }
	  
	 

	  // Personal function - remove everything from list
	  public void removeAll() {
		  empList.removeAll();
	  }
	  
	  // Personal function - show all employees on a specified course
	 private int avgResult() {
		 int avg;
		 int total = 0;
		 int count = 0;
		 Employee first;
		 first = empList.first();
		 while (first != null) {
			 total += first.getResult();
			 count ++; 
		 }
		 avg = total/count;
		 System.out.println(avg);
		 return avg;
	 }
	  
	  // Personal function - get an employee by inputting a postion
	  public void nodePostion(){
			Scanner scan = new Scanner(System.in);
			System.out.print("Please enter the position of the employee you wish to see: ");
			int position = scan.nextInt();
			scan.nextLine();
			empList.nodePostion(position);
		}
	  
	  // Personal function - remove an employee by inputting a position
	  public void removePosition() {
		  	Scanner scan = new Scanner(System.in);
			System.out.print("Please enter the position of the employee you wish to delete: ");
			int position = scan.nextInt();
			scan.nextLine();
			empList.remove(position);
	  }
	 

	public static void main(String[] args) {
		TrainingCourses driver = new TrainingCourses();
		Scanner scan = new Scanner(System.in);
		int numEmp;
		System.out.println("\t\t------Food Co Employee Training System------");
		System.out.print("\t\tHow many employees details do you wish to enter?");
		numEmp = scan.nextInt();
		// Input up to 10 employees
		
			
			if (numEmp > 10)
			{
				System.out.println("You can only input up to ten employees at a time");
				System.out.print("\t\tHow many employees details do you wish to enter?");
				numEmp = scan.nextInt();
			} 
			

		for (int i = 0; i < numEmp; i++)
		{
			driver.inputEmp();
		}
		driver.displayAll();
		driver.avgResult();
		driver.displayAll();
		//driver.removePosition();
		//driver.showEmpCourse();
		//driver.nodePostion();
		//driver.removeAll();
		/*driver.removeEmpByNum();
		driver.displayAll();
		driver.deleteEmpCourse();*/
		
	}

}
