package com.klu.jdbcApp;

import java.sql.*; 
public class AppTest { 
	public static void main( String[] args ) 
			throws Exception { String url = "jdbc:mysql://localhost:3306/student_db"; 
			String username = "root"; 
			String password = "Khu1109@"; 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(url, username, password); 
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * from klustudents"); 
			while(rs.next()) {
             System.out.println("Student ID: " + rs.getInt(1)); 
             System.out.println("Student Name: " + rs.getString(2)); 
             } 
			con.close(); 
			} 
	}