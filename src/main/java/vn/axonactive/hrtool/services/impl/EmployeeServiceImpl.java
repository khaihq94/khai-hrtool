package vn.axonactive.hrtool.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vn.axonactive.hrtool.entities.Department;
import vn.axonactive.hrtool.entities.Employee;
import vn.axonactive.hrtool.services.EmployeeService;


@Stateless
public class EmployeeServiceImpl implements EmployeeService {

	@PersistenceContext(name = "CRUDDemoApp")
	private EntityManager em;

	@Override
	public String addEmployee(Employee employee, int dep_id) {
		Department department = new Department();
		department.setDepartment_id(dep_id);
		employee.setDepartment(department);
		em.persist(employee);
		em.flush();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployee() {
		List<Employee> empList = new ArrayList<>();
		
		String ejbQL = "FROM Employee";
		Query query = em.createQuery(ejbQL);
		empList = query.getResultList();
		em.flush();
		return empList;
	}

	@Override
	public String removeEmployee(Employee employee) {
		Employee emp = em.find(Employee.class, employee.getEmployee_id());
		if(emp != null) {
			em.remove(emp);
		}
		return null;
	}

	@Override
	public String updateEmployee(Employee employee, int dep_id) {
		System.out.println("Inside update employee");
		
		Employee emp = em.find(Employee.class, employee.getEmployee_id());
		System.out.println("Employee ID " + employee.getEmployee_id());
		System.out.println("Employee Name " + employee.getEmployee_name());
		System.out.println("Salary " + employee.getSalary());
		System.out.println("Department ID " + dep_id);
		if(emp != null) {
			System.out.println("Inside merge emp");
			emp.setEmployee_name(employee.getEmployee_name());
			emp.setSalary(employee.getSalary());
			Department dep = new Department();
			dep.setDepartment_id(dep_id);
			emp.setDepartment(dep);
			em.merge(emp);
			em.flush();
		}
		return null;
	}
	
}
