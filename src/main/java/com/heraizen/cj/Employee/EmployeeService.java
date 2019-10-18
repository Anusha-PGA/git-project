package com.heraizen.cj.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee employee);
	Employee[] getEmployees();
	void deleteEmployee(int empno);
	Employee[] searchEmployee(String name);
	Employee updateEmployee(Employee employee);
	Employee getEmpByEmpno(int empno);
	public void removeAll();
}
