
package com.pace.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
public class ReadData {
	Connection conn;
	Statement stmt;
	ResultSet rset;
	PreparedStatement pstmt;
	Scanner scnr=new Scanner(System.in);
	public void registerDriver()throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//in notes detail explination
	}
	public void getDetails()throws Exception{
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","password");
	
	//stmt=conn.createStatement();
	
	//earlier in mysql we have inserted the data
	//now we have inserted the static data 

	//int row=stmt.executeUpdate("insert into book values(2222,'Mybook','Myself',563.24)");
	//now we will insert the dynamic data
	int id;
	String name,author;
	float price;
	System.out.println("Insert book id");
	id=scnr.nextInt();
	System.out.println("Insert book name");
	name=scnr.next();
	System.out.println("Enter book author");
	author=scnr.next();
	System.out.println("Enter book price");
	price=scnr.nextFloat();
	pstmt=conn.prepareStatement("insert into book values(?,?,?,?)");
	pstmt.setInt(1,id);
	pstmt.setString(2,name);
	pstmt.setString(3,author);
	pstmt.setFloat(4,price);
	pstmt.executeUpdate();
	//int row2=stmt.executeUpdate("insert into book values("+id+",'"+name+"','"+author+"',"+price+")");
			//"insert into book values(1111,'c','balu',563.24)"
	//double quoete in single quoete to sepcify that ,if we simply place 'name' like this it will print the name as string 
	//so we use ""double quotie and single quote to specify the comma,(",'") and then add dynamically added name...so on
	int row3=pstmt.executeUpdate("delete from book where id=3456");
	rset=pstmt.executeQuery("select * from book");
	
	
	//result set object has next method it returns true if ,there are rows in the object
	//only in java value will have suffix of fs
	while(rset.next()) {
		//next will say that there are records in the rows
		System.out.print(rset.getInt(1));//to get book id
		System.out.print("\t"+rset.getString(2));//to get bookname
		System.out.print("\t"+rset.getString(3));//to get author
		System.out.println("\t"+rset.getFloat(4));//to get the price
		
		
	}
	rset.close();
	pstmt.close();
	conn.close();
}
}
