package com.database;

import java.util.Scanner;
import java.sql.*;

public class EmployeeDetail {
	
	void getData(){	
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root", "root");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from employee");
			
			while(rs.next()){
				System.out.println("employee id is: " + rs.getInt(1));
				System.out.println("Age is: " + rs.getInt(2));
				System.out.println("Name is: " + rs.getString(3));
				System.out.println("Address is: " + rs.getString(4));
				
				System.out.println("--------------------------------");
			}
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	void insertData(){
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root", "root");
			
			Statement st = con.createStatement();
			
			String query = "insert into employee(emp_id, emp_age, emp_name, emp_address ) values(?, ?, ?, ?)";
			
			PreparedStatement p = con.prepareStatement(query);
			
			System.out.println("Enter employee id, age, name, address:");
			Scanner sc = new Scanner(System.in);
			int emp_id = sc.nextInt();
			int emp_age= sc.nextInt();
			String emp_name = sc.next();
			String emp_address = sc.next();
			
			p.setInt(1, emp_id);
			p.setInt(2, emp_age);
			p.setString(3, emp_name);
			p.setString(4, emp_address);
			
			
			p.execute();
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	void deleteData(int emp_id){
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root", "root");
			
			Statement st = con.createStatement();
			
			String query = "delete from employee where emp_id = ?";
			
			PreparedStatement p = con.prepareStatement(query);
			
			p.setInt(1, emp_id);
			
			p.execute();
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	void deleteAllData( ){
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root", "root");
			
			Statement st = con.createStatement();
			
			String query = "Truncate employee ";
			
			PreparedStatement p = con.prepareStatement(query);
			
			p.execute();
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		
		EmployeeDetail cx = new EmployeeDetail();
		cx.getData();            // get all the data from employee table
		
		cx.insertData();         // you can insert the value for id, age, name, address for employee
		
		
		cx.deleteData(3);       // delete the employee entry from table by id, here employee id is 3
		
		//cx.getData();
		
		//cx.deleteAllData();  // deleted all the data from table employee
		
		cx.getData();
		
		System.out.println("Queries executed successfully !");
	}

}
