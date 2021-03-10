package com.divergent.consolebased.project;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;


public class StudentInfomation {

	Scanner sc = new Scanner(System.in);
	public StudentInfomation() {}
	
	//Show All Student Details
	void alldetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String url = "jdbc:mysql://localhost:3306/SchoolManagmentSystem";
			final String user = "root";
			final String password = "root";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			String sql = "select * from studenttable";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)+" "+rs.getInt(5)+" "+rs.getInt(6)+" "+rs.getInt(7));
			}
		} catch (Exception e) {}
	}
	
	//Insert Student Detail
	void insertdata() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String url = "jdbc:mysql://localhost:3306/SchoolManagmentSystem";
			final String user = "root";
			final String password = "root";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			System.out.println("Enter StudentID, StudentName,StudentClass,StudentAddress,StudentContactno,StudentAttendence,studentfee");
			int studentid =Integer.parseInt(sc.nextLine());
			String studentname = sc.nextLine();
			String studentclass = sc.nextLine();
			String studentaddress = sc.nextLine();
			int studentcontact = Integer.parseInt(sc.nextLine());
			int studentattendence = Integer.parseInt(sc.nextLine());
			int studentfee = Integer.parseInt(sc.nextLine());
			String sql = "insert into StudentTable values("+studentid+",'"+studentname+"','"+studentclass
					+"','"+studentaddress+"',"+studentcontact+","+studentattendence+","+studentfee+")";
			st.executeUpdate(sql);
			System.out.println("Insert Successfully....");
		} catch (Exception e) {}
	}
	
	//Update Student Attendence
	void updateattendence() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String url = "jdbc:mysql://localhost:3306/SchoolManagmentSystem";
			final String user = "root";
			final String password = "root";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			int studentid =Integer.parseInt(sc.nextLine());
			int studentattendence =Integer.parseInt(sc.nextLine());
			String sql = "UPDATE studenttable SET student_attendence ="+studentattendence+" WHERE student_id = "+studentid+"";
			st.executeUpdate(sql);
			System.out.println("Update SuccessFully....");
			con.close();
		} catch (Exception e) {}
	}
	
	//Delete Detail of Student
	void deletedetail() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String url = "jdbc:mysql://localhost:3306/SchoolManagmentSystem";
			final String user = "root";
			final String password = "root";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			System.out.println("Enter StudentID");
			int studentid =Integer.parseInt(sc.nextLine());
			int result=st.executeUpdate("delete from studenttable where student_id="+studentid+"");  
			System.out.println("Delete SuccessFully....");
			con.close();
		} catch (Exception e) {}
	}
	
	void serachbyname() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String url = "jdbc:mysql://localhost:3306/SchoolManagmentSystem";
			final String user = "root";
			final String password = "root";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			String studentname = sc.nextLine();
			
			String sql = "select * from studenttable where student_name like '"+studentname+"%';" ;
//			String sql = "select * from studenttable where student_name like 'aman%';";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)+" "+rs.getInt(5)+" "+rs.getInt(6)+" "+rs.getInt(7));
			}
			System.out.println("Search SuccessFully....");
			con.close();
		} catch (Exception e) {
			System.out.println("Hello");
		}
	}
	
	void shortbyAbsent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String url = "jdbc:mysql://localhost:3306/SchoolManagmentSystem";
			final String user = "root";
			final String password = "root";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			String studentattendencestatus = sc.nextLine();
		
			String sql = "select Studenttable.Student_id,studenttable.Student_Name,studenttable.Student_class,\r\n" + 
					"studattedence.student_daywiseattendence, studattedence.curruntdate from studenttable\r\n" + 
					"inner join studattedence on studenttable.student_id = studattedence.student_id \r\n" + 
					"where student_daywiseattendence = \""+studentattendencestatus+"\";";
			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + "          " + rs.getString(3) + "          " + rs.getString(4)+"          "+rs.getDate(5));
			}
			System.out.println("Search SuccessFully....");
			con.close();
		} catch (Exception e) {}
	}
}
