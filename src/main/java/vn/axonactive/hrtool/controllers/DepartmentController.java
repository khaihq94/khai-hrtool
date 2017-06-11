package vn.axonactive.hrtool.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import vn.axonactive.hrtool.entities.Department;
import vn.axonactive.hrtool.services.DepartmentService;

@ManagedBean
public class DepartmentController {
	
	private Department department = new Department();
	
	@EJB
	DepartmentService service;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public String saveDepartment(Department department) {
		service.addDepartment(department);
		return "home";
	}
	
	public List<Department> getDepartmentList() {
		return service.getDepartment();
	}

}
