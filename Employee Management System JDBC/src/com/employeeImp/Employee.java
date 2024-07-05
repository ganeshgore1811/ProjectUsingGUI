package com.employeeImp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.Connection.ConnectionEstablish;
import com.employeeUnimp.EmployeeUnImp;

public class Employee implements EmployeeUnImp {
	@Override
	public void register() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Id");
		int id = sc.nextInt();
		
		System.out.println("Enter your name");
		String n = sc.next();
		
		System.out.println("Enter your Slary");
		double s = sc.nextDouble();
		
		System.out.println("Enter your Experience");
		double e = sc.nextDouble();
		
		try {
			Connection con=ConnectionEstablish.createConnection();
			PreparedStatement ps = con.prepareStatement("insert into Employee values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, n);
			ps.setDouble(3, s);
			ps.setDouble(4, e);
			int row=ps.executeUpdate();
			System.out.println(row +" "+ "affected");
			ps.close();
			con.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void update() {
		try {
		Connection con	=ConnectionEstablish.createConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your id to update Salary");
			int id = sc.nextInt();
			
			System.out.println("Enter your amount to update Salary of" +id+"Employee");
			double s = sc.nextDouble();
			PreparedStatement ps = con.prepareStatement("update Employee set salary =? where id =?");
			ps.setDouble(1, s);
			ps.setInt(2, id);
			 int row=ps.executeUpdate();
			 System.out.println(row + " "+"Affected");
			 ps.close();
			 con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void fetch() {
	try {
		Connection con=ConnectionEstablish.createConnection();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id for fetching info of employee");
		int id = sc.nextInt();
		
		PreparedStatement ps=con.prepareStatement("select*from employee where id = ?;");
		ps.setInt(1, id);
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getDouble(3));
			System.out.println(rs.getDouble(4));
		}
		ps.close();
		con.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}										
		
	}

	@Override
	public void terminated() {
	try {
		Connection con=ConnectionEstablish.createConnection();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id which you want to Terminate the employee");
		 int id = sc.nextInt();
		 
		 PreparedStatement ps = con.prepareStatement("delete from employee where id = ?");
		 ps.setInt(1, id);
		 
		int rows= ps.executeUpdate();
		if(rows==0) {
			System.out.println(rows+"Employee is not terminated");
		}else {
			System.out.println(rows+ " "+ "Employee is terminated");
		}
		 ps.close();
		 con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public void FethAllInfo() {
	try {
		Connection con=ConnectionEstablish.createConnection();
		
		Statement st = con.createStatement();
		ResultSet rs =st.executeQuery("select*from employee");
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getDouble(3));
			System.out.println(rs.getDouble(4));
		}
		st.close();
		con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
}
