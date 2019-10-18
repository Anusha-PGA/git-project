package com.heraizen.cj.Employee;

public class EmployeeServiceImplementation implements EmployeeService {
	Employee[] empArr = new Employee[0];
	int count = 0;

	private EmployeeServiceImplementation() {

	}

	private static volatile EmployeeServiceImplementation obj;

	synchronized public static EmployeeServiceImplementation getInstance() {
		if (obj == null) {
			obj = new EmployeeServiceImplementation();
		}
		return obj;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		if (empArr.length == count) {
			Employee[] temp = new Employee[empArr.length];
			System.arraycopy(empArr, 0, temp, 0, empArr.length);
			empArr = new Employee[empArr.length + 1];
			System.arraycopy(temp, 0, empArr, 0, temp.length);

		}
		empArr[count] = employee;
		return empArr[count++];
	}

	@Override
	public Employee[] getEmployees() {
		return empArr;
	}

	@Override
	public void deleteEmployee(int id) {
		if (empArr.length == 0) {
			throw new IllegalArgumentException("Element not found");
		}
		Employee[] temp = new Employee[empArr.length - 1];
		int index = -1;
		for (int i = 0; i < empArr.length; i++) {
			if (empArr[i].getId() == id) {
				index = i;
				break;

			}
		}
		if (index == -1)
			throw new IllegalArgumentException("Element not found");
		for (int i = 0, j = 0; i < empArr.length; i++) {

			if (i == index) {
				continue;
			} else {
				temp[j++] = empArr[i];
			}
		}
		empArr = new Employee[temp.length];
		System.arraycopy(temp, 0, empArr, 0, temp.length);
		count--;

	}

	@Override
	public Employee[] searchEmployee(String name) {
		int len = 0;
		for (int i = 0; i < empArr.length; i++) {
			if (empArr[i].getEmpName().contains(name)) {
				len++;
			}
		}
		if(len==0)
			return null;
		Employee[] temp = new Employee[len];
		for (int i = 0, j = 0; i < empArr.length; i++) {
			if (empArr[i].getEmpName().contains(name)) {
				temp[j++]=empArr[i];
			}
		}
		return temp;
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		int j = -1;
		for (int i = 0; i < empArr.length; i++) {
			if (empArr[i].getId() == employee.getId()) {
				empArr[i].setEmpName(employee.getEmpName());
				empArr[i].setSalary(employee.getSalary());
				j = i;
				break;
			}
		}
		return j != -1 ? empArr[j] : null;
	}

	@Override
	public Employee getEmpByEmpno(int empno) {
		for (int i = 0; i < empArr.length; i++) {
			if (empArr[i].getId() == empno) {
				return empArr[i];
			}
		}
		return null;
	}

	@Override
	public void removeAll() {
		empArr = new Employee[0];
		count = 0;

	}
}
