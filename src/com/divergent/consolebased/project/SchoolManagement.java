package com.divergent.consolebased.project;

import java.util.Scanner;

public class SchoolManagement {

	public static void main(String[] args) {
		StudentInfomation studentinfo = new StudentInfomation();
		StaffInformation staffinfo = new StaffInformation();
		AccountFeeInformation accountinfo = new AccountFeeInformation();
		Scanner sc = new Scanner(System.in);
		int option = 1;
		while(option!=4) {
				System.out.println("**************************************");
				System.out.println("Welcome To The Learning Temple School");
				System.out.println("1. Students Infomation");
				System.out.println("2. Staff Information");
				System.out.println("3. Fee Structure");
				System.out.println("4. Exit");
				System.out.println("**************************************");
				System.out.print("Enter Your Choice : ");
				option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("**************************************");
					System.out.println("Student Information");
					System.out.println("1. Student Detail");
					System.out.println("2. Student Attendence");
					System.out.println("3. Insert Student Detail");
					System.out.println("4. Delete Student Detail");
					System.out.println("5. Serach By Name");
					System.out.println("6. Short by Absent");
					System.out.println("**************************************");
					System.out.println("Choose Option : ");
					
					int student = sc.nextInt();
					switch (student) {
					case 1:
						System.out.println("Student Details");
						studentinfo.alldetails();
						break;
					case 2:
						System.out.println("Student Attendence , Enter Studentid and Attendence");
						studentinfo.updateattendence();
						break;
					case 3: 
						System.out.println("Insert Student Detail");
						studentinfo.insertdata();
						break;
					case 4: 
						System.out.println("Delete Student Detail");
						studentinfo.deletedetail();
						break;
					case 5: 
						System.out.println("Search By Name");
						studentinfo.serachbyname();
						break;
					case 6: 
						System.out.println("Sort by Absent");
						studentinfo.shortbyAbsent();
						break;
					default:
						break;
					}
					break;
				case 2: 
					System.out.println("**************************************");
					System.out.println("Staff Information");
					System.out.println("1. Teacher Detail");
					System.out.println("2. Edit on Staff");
					System.out.println("3. delete on Staff");
					System.out.println("**************************************");
					System.out.println("Choose Option : ");
					int staff = sc.nextInt();
					switch (staff) {
					case 1:
						System.out.println("Teacher Details");
						staffinfo.allstaffinfo();
						break;
					case 2:
						System.out.println("Edit Staff details");
						staffinfo.editstaffinfo();
						break;
					case 3: 
						System.out.println("Detele Staff Detail");
						staffinfo.deletestaffinfo();
						break;
					default:
						break;
					}
					break;
				case 3:
					System.out.println("**************************************");
					System.out.println("Account Information");
					System.out.println("1. Student Fee Struture");
					System.out.println("2. Check Fee Status");
					System.out.println("3. Deposit Fee ");
					System.out.println("Choose Option : ");
					System.out.println("**************************************");
					int fee = sc.nextInt();
					switch (fee) {
					case 1:
						System.out.println("Student Fee Details");
						accountinfo.feestructure();
						break;
					case 2:
						System.out.println("Student Fee Status");
						accountinfo.studentfeestatus();
						break;
					case 3:
						System.out.println("Student Fee Deposite");
						accountinfo.updatefee();
						break;
					default:
						break;
					}
					break;
				case 4: 
					System.out.println("Exit");
				default:
					break;
				}
			}
	}
}
