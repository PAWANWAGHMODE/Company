package com.tka.CompanyManagement.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.tka.CompanyManagement.Entity.Company;

@Repository
public class CompanyDao {
public static final String url="jdbc:mysql://localhost:3306/db196";
private static final String username = "root";
private static final String password = "4580";
public static Connection con;
public static PreparedStatement prt;

public Connection getDbconnection(){
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(url,username,password);
	} catch (Exception e) {
		// TODO: handle exception
		System.err.println(e);
	}
	return con;
}
public ArrayList<Company> getallcompanies(){
	String query="select*from company";
	ArrayList<Company> aa=new ArrayList<Company>();
	try {
		prt=getDbconnection().prepareStatement(query);
		ResultSet rs=prt.executeQuery();
		while(rs.next()) {
			int id=rs.getInt(1);
			String Companyname=rs.getString(2);
			String Emailid=rs.getString(3);
			String Password=rs.getString(4);
			String Country=rs.getString(5);
			String State=rs.getString(6);
			String Phoneno=rs.getString(7);
			aa.add(new Company(id, Companyname,Emailid,Password,Country,State,Phoneno));
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
	return aa;
}
public void addcompany(Company c) {
	String query="insert into Company values(?,?,?,?,?,?,?)";
	try {
		prt=getDbconnection().prepareStatement(query);
		 prt.setInt(1, c.getId());
		prt.setString(2, c.getCompanyname());
		prt.setString(3, c.getEmailid());
		prt.setString(4, c.getPassword());
		prt.setString(5, c.getCountry());
		prt.setString(6, c.getState());
		prt.setString(7, c.getPhoneno());
		prt.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
}
public void deletecompany(Company c) {
	String query="delete from company where id=?";
	try {
		prt=getDbconnection().prepareStatement(query);
		prt.setInt(1, c.getId());
		prt.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
		// TODO: handle exception
	}
}
public void updatecompany(Company c) {
	String query="update company set Companyname=?,Emailid=?,Password=?,Country=?,State=?,Phoneno=? where id=?";
	try {
		prt=getDbconnection().prepareStatement(query);
		prt.setString(1,c.getCompanyname());
		prt.setString(2,c.getEmailid());
		prt.setString(3,c.getPassword());
		prt.setString(4,c.getCountry());
		prt.setString(5,c.getState());
		prt.setString(6,c.getPhoneno());
		prt.setInt(7, c.getId());
		int i=prt.executeUpdate();
		if(i>0) {
			System.out.println("Data update succesfully...");
		}else {
			System.out.println("Data does not updated... ");
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
}
public Company isexist(Company c) {
	String query="select * from Company where id=?";
	Company cc=null;
	try {
		prt=getDbconnection().prepareStatement(query);
		prt.setInt(1, c.getId());
		ResultSet rs= prt.executeQuery();
		while(rs.next()) {
			int id=rs.getInt(1);
			String Companyname=rs.getString(2);
			String Emailid=rs.getString(3);
			String Password=rs.getString(4);
			String Country=rs.getString(5);
			String State=rs.getString(6);
			String Phoneno=rs.getString(7);
			cc=new Company(id,Companyname,Emailid,Password,Country,State,Phoneno);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cc;
}
public Company updateorsave(Company c) {
	String query="update company set Companyname=?,Emailid=?,Password=?,Country=?,State=?,Phoneno=? where id=?";
	Company cc=null;
	try {
		prt=getDbconnection().prepareStatement(query);
		prt.setString(1, c.getCompanyname());
		prt.setString(2,c.getEmailid());
		prt.setString(3,c.getPassword());
		prt.setString(4,c.getCountry());
		prt.setString(5,c.getState());
		prt.setString(6,c.getPhoneno());
		prt.setInt(7, c.getId());
		
		int i=prt.executeUpdate();
		if(i>0) {
			System.out.println("Data update succesfully...");
		}else {
			System.out.println("Data does not updated... ");
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cc;
}
}
