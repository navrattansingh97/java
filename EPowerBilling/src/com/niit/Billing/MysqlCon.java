package com.niit.Billing;
import java.sql.Connection;
import java.sql.DriverManager;
public class MysqlCon {
	public static Connection con;
	public static void createConnection() {
		// TODO Auto-generated method stub
		try{	//Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Open a connection
			con =DriverManager.getConnection("jdbc:mysql://192.168.252.115:3306/bill","root","root");
			//execute a query
			//con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
