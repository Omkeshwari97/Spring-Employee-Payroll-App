package com.bridgelabz.employeepayrollapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.employeedto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.IEmployeeRepository;

@Service
public class EmployeeServiceIMPL implements IEmployeeService
{
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(EmployeePayrollDTO employeePayrollDTO) 
	{
		Employee emp = new Employee(employeePayrollDTO);
		emp = employeeRepository.save(emp);
		return emp;
	}

	@Override
	public Employee getEmployeeById(long id) throws EmployeeException 
	{
		return employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Invalid user id"));
	}

	@Override
	public void updateEmployeeById(long id, EmployeePayrollDTO employeePayrollDTO) throws EmployeeException 
	{
		Employee emp = getEmployeeById(id);
		if(employeePayrollDTO.name != null)
		{
			emp.setName(employeePayrollDTO.name);
		}
		if(employeePayrollDTO.salary != 0)
		{
			emp.setSalary(employeePayrollDTO.salary);
		}
		emp = employeeRepository.save(emp);
	}

	@Override
	public void deleteEmployeebyId(long id) 
	{
		employeeRepository.deleteById(id);
	}

}
