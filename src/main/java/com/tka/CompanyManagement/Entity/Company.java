package com.tka.CompanyManagement.Entity;

public class Company {
private int id;
private String Companyname;
private String Emailid;
private String Password;
private String Country;
private String State;
private String Phoneno;


public Company() {
	super();
}


public Company(String companyname, String emailid, String password, String country, String state, String phoneno) {
	super();
	Companyname = companyname;
	Emailid = emailid;
	Password = password;
	Country = country;
	State = state;
	Phoneno = phoneno;
}





public Company(int id, String companyname, String emailid, String password, String country, String state,
		String phoneno) {
	super();
	this.id = id;
	Companyname = companyname;
	Emailid = emailid;
	Password = password;
	Country = country;
	State = state;
	Phoneno = phoneno;
}
public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}



public String getCompanyname() {
	return Companyname;
}


public void setCompanyname(String companyname) {
	Companyname = companyname;
}


public String getEmailid() {
	return Emailid;
}


public void setEmailid(String emailid) {
	Emailid = emailid;
}


public String getPassword() {
	return Password;
}


public void setPassword(String password) {
	Password = password;
}


public String getCountry() {
	return Country;
}


public void setCountry(String country) {
	Country = country;
}



public String getState() {
	return State;
}


public void setState(String state) {
	State = state;
}


public String getPhoneno() {
	return Phoneno;
}


public void setPhoneno(String phoneno) {
	Phoneno = phoneno;
}


@Override
public String toString() {
	return "Company [id="+id+",Companyname=" + Companyname + ", Emailid=" + Emailid + ", Password=" + Password + ", Country="
			+ Country + ", State=" + State + ", Phoneno=" + Phoneno + "]";
}
}
