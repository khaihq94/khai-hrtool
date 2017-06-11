package vn.axonactive.hrtool.services;

import java.util.List;

import vn.axonactive.hrtool.entities.Department;


public interface DepartmentService {

	public String addDepartment(Department dep);
	
	public List<Department> getDepartment();
}
