package com.rantech.jdbc;
import java.sql.*;
import java.util.*;

public class Department {

	public static void main(String[] args) {
       Scanner sc=null;
       Connection con=null;
       Statement st=null;
       ResultSet rs=null;
       String city=null;
       try {
    	   sc=new Scanner(System.in);
    	   System.out.println("Enter City Name:: ");
       if(sc!=null) 
    	   city=sc.next();
           city="'"+city+"'";
    	   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mydb","mydb");
    	   if(con!=null) 
    		   st=con.createStatement();
    	       String query="DELETE FROM DEPT WHERE LOC="+city;
    	       System.out.println(query);
    	       int count=0;
    	   if(st!=null)
    		   count=st.executeUpdate(query);
    	    if(count==0)
    	    	System.out.println("No records found");
    	    else
    	    	System.out.println("No of records found are::"+count);
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
