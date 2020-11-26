package com.bridgelabz.employeepayrollapp.employeedto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmployeePayrollDTO 
{
	@NotEmpty(message = "Name should not be null")
	public String name;
	@NotNull(message = "")
	public long salary;
	
}
