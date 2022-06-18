package newpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//import mysqlJava.SqlProject1;

public class ProjectS {

	static void insert() {
		Scanner sc=new Scanner(System.in);
		try{ Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/satyam","root","root");
		Statement st=con.createStatement();
		System.out.println("Enter your id:");
		int id=sc.nextInt();
		System.out.println("Enter your first name:");
		String fname=sc.next();
		System.out.println("Enter your last name:");
		String lname=sc.next();
		System.out.println("Enter your mobile_no:");
		long mobile=sc.nextLong();
		System.out.println("Enter your email:");
		String email=sc.next();
		System.out.println("Enter your password:");
		String passwords=sc.next();
		st.executeUpdate("insert into obito values('"+id+"','"+fname+"','"+lname+"','"+mobile+"','"+email+"','"+passwords+"')");
		System.out.println("Record is stored in the DataBase sucessfully...");
		con.close();
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());}
		System.out.println("Please check it in the MySql table....");

	}
	static void update() {
		Scanner sc=new Scanner(System.in);
		try{ Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/satyam","root","root");
		System.out.println("Enter new password:");
		String passwords=sc.next();
		System.out.println("Enter your id:");
		int id=sc.nextInt();
		Statement st=con.createStatement();
		st.executeUpdate("update obito set passwords=('"+passwords+"')  where id=('"+id+"')");
		System.out.println("Your password is updated check it in the Mysql...");
		con.close();
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());}
	}
	static void delete() {
		Scanner sc=new Scanner(System.in);
		try{ Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/satyam","root","root");
		System.out.println("Enter your id:");
		int id=sc.nextInt();
		Statement st=con.createStatement();
		st.executeUpdate("delete from obito where id=('"+id+"')");
		System.out.println("Your record is deleted check it in the Mysql...");
		con.close();
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());}
	}
	static void record() {
		try{ Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/satyam","root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from obito");
		
		while(rs.next())
		{
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
		}
		}
		catch(Exception e)
		{
		System.out.println(e.toString());}
	}
	public static void main(String args[]) {
		ProjectS s=new ProjectS();
		int a=0;
		do {
		Scanner c=new Scanner(System.in);
		System.out.println("Select an option \n1-Registration \n2-Update Password \n3-Delete record \n4-See Records \n5-Exit");
		a=c.nextInt();
		switch(a) {
		case 1:
			s.insert();
			break;
		case 2:
			s.update();
			break;
		case 3:
			s.delete();
			break;
		case 4:
			s.record();
		case 5:
			System.out.println("Exit");
		}
	}while(a!=5);
		System.out.println("Thanku for registration");
		
	}

}
