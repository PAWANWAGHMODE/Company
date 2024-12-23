package com.tka.CompanyManagement.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.CompanyManagement.Entity.Company;
import com.tka.CompanyManagement.Service.CompanyService;

@RestController
public class CompanyController {
@Autowired
CompanyService companyservice;

@GetMapping("getallcompanies")
public ArrayList<Company> getallcompanies(){
	return companyservice.getallcompanies();
}
@PostMapping("addcompany")
public void addcompany(@RequestBody Company c) {
	companyservice.addcompany(c);
}
@DeleteMapping("deletecompanay")
public void deletecompany(@RequestBody Company c) {
	companyservice.deletecompany(c);
}
@PutMapping("updatecompany")
public void updatecompany(@RequestBody Company c) {
	companyservice.updatecompany(c);
}
@GetMapping("getorsave")
public Company isexist(@RequestBody Company c) {
	Company cc=companyservice.isexist(c);
	return cc;
}
@PutMapping("Updateorsave")
public void updateorsave(@RequestBody Company c) {
	companyservice.updateorsave(c);
}
}
