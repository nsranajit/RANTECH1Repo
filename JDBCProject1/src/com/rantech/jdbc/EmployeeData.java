package com.rantech.jdbc;
import java.sql.*;
import java.util.Scanner;
public class EmployeeData {
	public static void main(String[] args) {
	    Scanner sc=null;
	    Connection con=null;
	    Statement st=null;
	    ResultSet rs=null;
	    String s=null;
	    try {
    	sc=new Scanner(System.in);
    	System.out.println("Enter initial character of employee name:: ");
    	  if(sc!=null)
    		  s=sc.next();
    	  s="'"+s+"%'";
    	  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mydb","mydb");
    	  if(con!=null)
    		 st=con.createStatement();
    	     String query="select empid,empname,location,job,sal from emp where empname like"+s;
    	     System.out.println(query);
    	  if(st!=null)
              rs=st.executeQuery(query);
    	  if(rs!=null) {
    		 boolean flag=false;
    		  while(rs.next()!=false) {
    			 flag=true;
    			  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getFloat(5));
    		  }
    		  if(flag==false)
     			 System.out.println("No Records Found");
    	  }
       }
	    catch(SQLException se) {
	    	se.printStackTrace();
	    }
	    finally {
	    	try {
	    		if(rs!=null)
	    			rs.close();
	    	}
	    	catch(SQLException se) {
	    		se.printStackTrace();
	    	}
	    	try {
	    		if(st!=null)
	    			st.close();
	    	}
	    	catch(SQLException se) {
	    		se.printStackTrace();
	    	}
	    	try {
	    		if(con!=null)
	    			con.close();
	    	}
	    	catch(SQLException se) {
	    		se.printStackTrace();
	    	}
	    	try {
	    		if(sc!=null)
	    			sc.close();
	    	}
	    	catch(Exception se) {
	    		se.printStackTrace();
	    	}
	    }
	}
}

