package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.employeedto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeException;
import com.bridgelabz.employeepayrollapp.model.Employee;

public interface IEmployeeService 
{
	public Employee addEmployee(EmployeePayrollDTO employeePayrollDTO);
	public Employee getEmployeeById(long id) throws EmployeeException;
	public void updateEmployeeById(long id, EmployeePayrollDTO employeePayrollDTO) throws EmployeeException;
	public void deleteEmployeebyId(long id);
}
