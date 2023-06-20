package com.ltnecc.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPgm {
	
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	Registeration r=new Registeration();
	
	
	
	public static Connection getCon()
	{
		Connection con1=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/lbjb2jdbc","root","1234");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Class Not Found Exception");
		}
		catch(SQLException sqle)
		{
			System.out.println("SQL Exception ");
		}
		return con1;
	}
	
	void insertData() 
	{
		try {
			
			System.out.println("Enter the Student Name ");
			r.setName(br.readLine());
			System.out.println("Enter the Department ");
			r.setDept(br.readLine());
			System.out.println("Enter the Gender ");
			r.setGender(br.readLine());
			Connection c=JDBCPgm.getCon();
			PreparedStatement ps1=c.prepareStatement("insert into registeration(name,dept,gender) value(?,?,?)");
			ps1.setString(1, r.getName());
			ps1.setString(2, r.getDept());
			ps1.setString(3, r.getGender());
			int output=ps1.executeUpdate();
			
			if(output>0)
			{
				System.out.println("  Insert Operation is Success");
			}
			else
			{
				System.out.println("Error in Insertion");
			}
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle);
		}
		catch(IOException ioe)
		{
			System.out.println(ioe);
		}
	}
	
	void reteiveValues() throws SQLException
	{
		Connection c=JDBCPgm.getCon();
		PreparedStatement ps=c.prepareStatement("select * from registeration");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("***************************");
			System.out.println("Registeration No is "+rs.getInt(1));
			System.out.println("Name is "+rs.getString(2));
			System.out.println("Department is "+rs.getString(3));
			System.out.println("Gender is "+rs.getString(4));
		}
		
		
	}
	void deleteRecords() throws SQLException,IOException
	{
		System.out.println("Enter the Registeration Number u want to Delete ");
		int regi=Integer.parseInt(br.readLine());
		Connection c=JDBCPgm.getCon();
		PreparedStatement ps=c.prepareStatement("delete from registeration where id=?");
		ps.setInt(1, regi);
		int output=ps.executeUpdate();
		if(output>0)
		{
			System.out.println("One record is Deleted");
		}
		else
		{
			System.out.println("Error in Deletion");
		}
		
	}
	
	
	
	
	
	
	
	void getChoice() throws IOException,SQLException
	{
		System.out.println("Enter ur Options \n 1.Insert \n 2.Reterive\n 3.Delete \n 4.Update");
		int getOptions=Integer.parseInt(br.readLine());
		switch(getOptions)
		{
		case 1:
			this.insertData();
			break;
		case 2:
		this.reteiveValues();
			break;
		case 3:
			this.reteiveValues();
			this.deleteRecords();
			break;
		case 4:
			System.out.println("Coming Soon");
			break;
		default:
				System.out.println("Please Enter Correct Options");
				break;
		}
		
	}
	
	

	public static void main(String[] args) throws IOException,SQLException{
		
		JDBCPgm jdbcp=new JDBCPgm();
		jdbcp.getChoice();
	}
}
