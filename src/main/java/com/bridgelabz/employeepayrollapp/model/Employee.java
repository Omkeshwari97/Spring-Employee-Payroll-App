package com.bridgelabz.employeepayrollapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.bridgelabz.employeepayrollapp.employeedto.EmployeePayrollDTO;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private long salary;

	public Employee()
	{
		
	}
	
	public Employee(EmployeePayrollDTO employeePayrollDTO)
	{
		this.name = employeePayrollDTO.name;
		this.salary = employeePayrollDTO.salary;
	}

	@Override
	public String toString() 
	{
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public void setId(long id) 
	{
		this.id = id;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}

	public void setSalary(long salary) 
	{
		this.salary = salary;
	}

	public long getId() 
	{
		return id;
	}

	public String getName() 
	{
		return name;
	}

	public long getSalary() 
	{
		return salary;
	}
}
