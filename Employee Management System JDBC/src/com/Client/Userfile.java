package com.Client;

import java.util.Scanner;

import com.employeeImp.Employee;

public class Userfile {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("Enter your choice");
			System.out.println("1] Registeration");
			System.out.println("2] Update Salary");
			System.out.println("3] Fetch Record");
			System.out.println("4] Resignation of Employee");
			System.out.println("5] Fetch All Detail");
			
			int choice = sc.nextInt();
			
			Employee emp = new Employee();
			
			switch(choice) {
			case 1: emp.register();
			break;
			
			case 2:emp.update();
			break;
			
			case 3:emp.fetch();
			break;
			
			case 4:emp.terminated();
			break;
			
			case 5:emp.FethAllInfo();
			break;
			
			default: System.out.println("Exist");
			break;
			}
		}
		
	}
}
