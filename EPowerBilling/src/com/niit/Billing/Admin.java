package com.niit.Billing;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;




public class Admin  {
	Scanner s=new Scanner(System.in);
	
	public void getUserDetails(){
		try{
			MysqlCon.createConnection();
			System.out.println("The users details are: ");
			PreparedStatement stmt=MysqlCon.con.prepareStatement("SELECT USER_ID,USER_FNAME,USER_LNAME,USER_EMAIL,ADHAR_NUMBER,STATUS FROM USER");
			ResultSet rs=stmt.executeQuery();
			ResultSetMetaData rsm=rs.getMetaData();
			System.out.println(rsm.getColumnName(1)+" \t"+rsm.getColumnName(2)+" \t"+ rsm.getColumnName(3)+" \t"+rsm.getColumnName(4)+" \t"+rsm.getColumnName(5));
			System.out.println();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" \t"+rs.getString(2)+" \t"+rs.getString(3)+"\t "+rs.getString(4)+"\t "+rs.getString(5)+" \t"+rs.getString(6));
			}
	}catch(Exception e)
		{
		e.printStackTrace();
	}
}
	public void insertInConnectionDetails(){
		try{
			MysqlCon.createConnection();
			System.out.println("Enter USER ID of which you want to insert the data");
			String id=s.nextLine();
			System.out.println("Enter Connection ID");
			String cid=s.nextLine();
			System.out.println("Enter Connection Name");
			String cname=s.nextLine();
			System.out.println("Enter Connection TYPE");
			String cType=s.nextLine();
			System.out.println("Enter Connection DATE(YYYY-MM-DD)");
			String cDate=s.nextLine();
			Date date=Date.valueOf(cDate);
			PreparedStatement stmt1=MysqlCon.con.prepareStatement("INSERT INTO CONNECTION_DETAILS VALUES(?,?,?,?,?) ");		
			stmt1.setString(1,cid);
			stmt1.setString(2,cname);
			stmt1.setString(3,cType);
			stmt1.setDate(4,date);
			stmt1.setString(5,id);

			int r=stmt1.executeUpdate();
			if(r>0)
			{
				System.out.println("Inserted Successfully");
			}
			else
			{
				System.out.println("NOT INSERTED");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	public void updateConsumedUnits(){
		try{
			MysqlCon.createConnection();
			//System.out.println("Enter the consumption id");
			//String cId=s.next();
			System.out.println("Enter CONNECTION ID");
			String connectionId=s.next();
			System.out.println("Enter Consumed Units");
			int consumedUnit=s.nextInt();
			String consumptionId=null;
			String uId=null;
			PreparedStatement stmt=MysqlCon.con.prepareStatement("insert into consumption_details (connection_id,consumed_units) values(?,?)");
			stmt.setString(1,connectionId);
			stmt.setInt(2,consumedUnit);
			int row=stmt.executeUpdate();
			
			int billAmount=consumedUnit*8;
			PreparedStatement stmt3=MysqlCon.con.prepareStatement("select user_id  from connection_details where connection_id='"+connectionId+"' ");
			//stmt3.setString(1,connectionId);
		
			ResultSet rs=stmt3.executeQuery();
			while (rs.next()){
			uId=rs.getString(1);
			}
			
			PreparedStatement stmt4=MysqlCon.con.prepareStatement("select consumption_id   from consumption_details where connection_id='"+connectionId+"'  ");
			ResultSet rs1=stmt4.executeQuery();
			while (rs1.next()){
			consumptionId=rs1.getString(1);
			}
			PreparedStatement stmt2=MysqlCon.con.prepareStatement("INSERT INTO BILL_DETAILS (CONNECTION_ID,CONSUMPTION_ID,BILL_AMOUNT,DUE_DATE,BILL_GEN_DATE,USER_ID) VALUES (?,?,?,now()+10,now(),?)");
			//stmt2.setString(1, bId);
			stmt2.setString(1, connectionId);
			stmt2.setString(2,consumptionId);
			stmt2.setInt(3, billAmount);
			stmt2.setString(4, uId);
			stmt2.executeUpdate();
			if(row>0)
			{
				System.out.println("UPDATED Successfully and bill is generated ");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}