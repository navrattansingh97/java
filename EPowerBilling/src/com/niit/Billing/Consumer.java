package com.niit.Billing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;




public class Consumer {
	Scanner s=new Scanner(System.in);
public void insertNewRecord(){
	try{
		MysqlCon.createConnection();
		System.out.println("New users enter the details as you were asked ");
		System.out.println("Enter user first name: ");
		String fname=s.nextLine();
		System.out.println("Enter user last name: ");
		String lname=s.nextLine();
		System.out.println("Enter user mobile number: ");
		long mobNum=s.nextLong();
		System.out.println("Enter user email address: ");
		s.nextLine();
		String email=s.nextLine();
		System.out.println("Enter password: ");
		String password=s.nextLine();
		
		/*System.out.println("Enter user address: ");
		String address=s.nextLine();
		System.out.println("Enter user connection type: ");
		String conType=s.nextLine();*/
		System.out.println("Enter user Adhar Number: ");
		String adharNumber=s.nextLine();
		
		PreparedStatement stmt=MysqlCon.con.prepareStatement("INSERT INTO user(USER_ID,USER_FNAME,USER_MOB_NUM,USER_PASSWORD,USER_EMAIL,USER_LNAME, ADHAR_NUMBER) "
				+ "values(?,?,?,?,?,?,?)");		
		stmt.setString(1,email);
		stmt.setString(2,fname);
		stmt.setLong(3,mobNum);
		stmt.setString(4,password);
		stmt.setString(5,email);
		stmt.setString(6,lname);
		stmt.setString(7,adharNumber);
		int rowcount=stmt.executeUpdate();

		if(rowcount>0)
		{
			System.out.println("Inserted Successfully");
		}
		stmt.close();
		MysqlCon.con.close();
		s.close();
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
public void passwordUpdate(){
	try{
		MysqlCon.createConnection();
		System.out.println("Enter USER_ID");
		String userId=s.next();
		System.out.println("Enter new password: ");
		String pass=s.next();
		System.out.println("Enter new Mobile Number: ");
		String mobNum=s.next();
		PreparedStatement ps=MysqlCon.con.prepareStatement("UPDATE user set USER_PASSWORD=?,USER_MOB_NUM=? WHERE USER_ID='"+userId+"'");		
		ps.setString(1,pass);
		ps.setString(2,mobNum);
		//ps.setString(2,id);
		int row2=ps.executeUpdate();
		if(row2>0)
		{
			System.out.println("UPDATED Successfully");
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
public void getBill(){
	try{
		MysqlCon.createConnection();
		System.out.println("Enter the user id of which you want to get the bill");
		String userId=s.next();
		System.out.println("The Bill details are:\n ");
		PreparedStatement stmt=MysqlCon.con.prepareStatement("SELECT USER_ID,BILL_ID,CONNECTION_ID,BILL_AMOUNT,DUE_DATE,BILL_GEN_DATE,BILL_STATUS FROM BILL_DETAILS  WHERE USER_ID='"+userId+"'");
		ResultSet rs=stmt.executeQuery();
		ResultSetMetaData rsm=rs.getMetaData();
		System.out.println(rsm.getColumnName(1)+" \t"+rsm.getColumnName(2)+" \t"+ rsm.getColumnName(3)+" \t"+rsm.getColumnName(4)+" \t"+rsm.getColumnName(5)+" \t"+rsm.getColumnName(6)+" \t"+rsm.getColumnName(7));
		
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" \t"+rs.getString(2)+" \t"+rs.getString(3)+"\t "+rs.getString(4)+"\t "+rs.getString(5)+" \t"+rs.getString(6)+" \t"+rs.getString(7));
		}
}catch(Exception e)
	{
	e.printStackTrace();
}
}
}
