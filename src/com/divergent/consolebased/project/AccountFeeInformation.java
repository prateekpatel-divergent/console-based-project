package com.divergent.consolebased.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AccountFeeInformation {

	Scanner sc = new Scanner(System.in);
	public AccountFeeInformation() {}
	
	public void feestructure() {
		System.out.println("Class 1st to 3rd : 22350.");
		System.out.println("Class 4th to 6th : 26350.");
		System.out.println("Class 7th and 8th : 30350.");
		System.out.println("Class 9st and 10th : 33350.");
		System.out.println("Class 11th and 12th : 35500.");
	}
	
	public void studentfeestatus() {
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
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "+rs.getInt(7));
			}
		} catch (Exception e) {}
	}
	
	public void updatefee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String url = "jdbc:mysql://localhost:3306/SchoolManagmentSystem";
			final String user = "root";
			final String password = "root";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			int studentid =Integer.parseInt(sc.nextLine());
			int studentfee =Integer.parseInt(sc.nextLine());
			String sql = "UPDATE studenttable SET student_fee ="+studentfee+" WHERE student_id = "+studentid+"";
			st.executeUpdate(sql);
			System.out.println("Update SuccessFully....");
			con.close();
		} catch (Exception e) {}
	}

}
