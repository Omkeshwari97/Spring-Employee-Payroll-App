package com.bridgelabz.employeepayrollapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.employeedto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployeeService;

@RestController
@RequestMapping("hello")
public class EmployeePayrollController 
{
	@Autowired
	IEmployeeService empService;
	
	@GetMapping("/")
	public ResponseEntity<String> getEmployeeData()
	{
		return new ResponseEntity("Get call success", HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<String> getEmployeeDataById(@PathVariable("empId") long empId) throws EmployeeException
	{
		Employee emp = empService.getEmployeeById(empId);
		return new ResponseEntity("Get call success for id: " + emp, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO)
	{
		Employee emp = empService.addEmployee(employeePayrollDTO);
		return new ResponseEntity<String>("Created Employee Payroll Data for: " + emp, HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<Void> updateEmployeePayrollData(@PathVariable("empId") Long empId, @RequestBody EmployeePayrollDTO employeePayrollDTO) throws EmployeeException
	{
		empService.updateEmployeeById(empId, employeePayrollDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId)
	{
		empService.deleteEmployeebyId(empId);
		return new ResponseEntity<String>("Delete call success for id: " + empId, HttpStatus.OK);
	}

}
