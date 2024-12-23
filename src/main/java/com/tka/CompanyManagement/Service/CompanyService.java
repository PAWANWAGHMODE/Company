package com.tka.CompanyManagement.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.CompanyManagement.Dao.CompanyDao;
import com.tka.CompanyManagement.Entity.Company;

@Service
public class CompanyService {
@Autowired 
CompanyDao companydao;

public ArrayList<Company> getallcompanies(){
	return companydao.getallcompanies();
}
public void addcompany(Company c) {
	companydao.addcompany(c);
}
public void deletecompany(Company c) {
	companydao.deletecompany(c);
}
public void updatecompany(Company c) {
	companydao.updatecompany(c);
}
public Company isexist(Company c) {
	if(companydao.isexist(c)!=null) {
		System.out.println("Data is exist");
		return companydao.isexist(c);
	}else {
		System.out.println("data is not exist");
		companydao.addcompany(c);
	}
	return null;
}
public Company updateorsave(Company c) {
	try {
		if(companydao.updateorsave(c)!=null) {
			System.out.println("data exist and updated...");
			return companydao.updateorsave(c);
		}else {
			System.out.println("Data does not exist and save...");
			companydao.addcompany(c);
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
	return null;
}
}
