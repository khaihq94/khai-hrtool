package vn.axonactive.hrtool.services;

import java.util.List;

import vn.axonactive.hrtool.entities.Employee;


public interface EmployeeService {

	public String addEmployee(Employee employee, int dep_id);
	
	public List<Employee> getEmployee();
	
	public String removeEmployee(Employee employee);
	
	public String updateEmployee(Employee employee, int dep_id);
	
}
