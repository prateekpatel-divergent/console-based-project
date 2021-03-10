package com.divergent.consolebased.project;

import java.sql.*;
import java.util.Scanner;


public class StaffInformation {
	
	Scanner sc = new Scanner(System.in);
	public StaffInformation() {}
	
	public void allstaffinfo() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String url = "jdbc:mysql://localhost:3306/SchoolManagmentSystem";
			final String user = "root";
			final String password = "root";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			String sql = "select * from stafftable";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}
			System.out.println("Show All Details Successfully.");
		} catch (Exception e) {
			System.out.println("hello");
		}
	}
	
	public void editstaffinfo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String url = "jdbc:mysql://localhost:3306/SchoolManagmentSystem";
			final String user = "root";
			final String password = "root";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			System.out.println("Enter TeacherID, Teacher Name, Teacher Subject, Teacher JoinigDate");
			int teacherid =Integer.parseInt(sc.nextLine());
			String teachername = sc.nextLine();
			String teachersubject = sc.nextLine();
			String joinigdate = sc.nextLine();
			String sql = "insert into stafftable values("+teacherid+",'"+teachername+"','"+teachersubject+"','"+joinigdate+"')";
			st.executeUpdate(sql);
			System.out.println("Insert Successfully....");
		} catch (Exception e) {
			System.out.println("hello");
		}
	}
	
	public void deletestaffinfo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String url = "jdbc:mysql://localhost:3306/SchoolManagmentSystem";
			final String user = "root";
			final String password = "root";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			System.out.println("Enter TeacherID");
			int teacherid =Integer.parseInt(sc.nextLine());
			int result=st.executeUpdate("delete from stafftable where Teacher_id="+teacherid+"");  
			System.out.println("Delete SuccessFully....");
			con.close();
		} catch (Exception e) {}
	}

}
