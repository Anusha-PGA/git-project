package com.heraizen.cj.Employee;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
	static EmployeeServiceImplementation empImp;

	@BeforeEach
	public void beforeEach() {
		Employee emp = new Employee();
		empImp = EmployeeServiceImplementation.getInstance();
	}
	@AfterEach 
	public void afterAll(){
		empImp.removeAll();
	}

	@Test
	public void addEmployeeTest() {
		Employee emp = new Employee();
		emp.setId(GenerateEnum.generateEmpId());
		emp.setEmpName("Anusha");
		emp.setSalary(1234);
		assertEquals(emp.toString(), empImp.addEmployee(emp).toString());
	}

	@Test
	public void getEmployeeTest() {
		Employee emp1 = new Employee();
		emp1.setId(GenerateEnum.generateEmpId());
		emp1.setEmpName("Anusha");
		emp1.setSalary(1234);
		empImp.addEmployee(emp1).toString();
		Employee emp2 = new Employee();
		emp2.setId(GenerateEnum.generateEmpId());
		emp2.setEmpName("Anu");
		emp2.setSalary(1234);
		empImp.addEmployee(emp2).toString();
		Employee emp3 = new Employee();
		emp3.setId(GenerateEnum.generateEmpId());
		emp3.setEmpName("Andu");
		emp3.setSalary(12354);
		empImp.addEmployee(emp3).toString();
		Employee[] empArr = new Employee[] { emp1, emp2, emp3 };
		assertEquals(Arrays.toString(empArr), Arrays.toString(empImp.getEmployees()));
	}

	@Test
	public void deleteEmployeeIdNotFoundTest() {
		int a = 1001;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			empImp.deleteEmployee(a);
		});
	}

	//@Test
	public void deleteEmployeeTest() {
		Employee emp1 = new Employee();
		emp1.setId(GenerateEnum.generateEmpId());
		emp1.setEmpName("Anusha");
		emp1.setSalary(1234);
		empImp.addEmployee(emp1).toString();
		Employee emp2 = new Employee();
		emp2.setId(GenerateEnum.generateEmpId());
		emp2.setEmpName("Anu");
		emp2.setSalary(1234);
		empImp.addEmployee(emp2).toString();
		Employee emp3 = new Employee();
		emp3.setId(GenerateEnum.generateEmpId());
		emp3.setEmpName("Andu");
		emp3.setSalary(12354);
		empImp.addEmployee(emp3).toString();
		Employee[] empsArr = empImp.getEmployees();
		empImp.deleteEmployee(empsArr[0].getId());
		Employee[] empArr = new Employee[] { emp2, emp3 };
		assertArrayEquals(empArr, empImp.getEmployees());
	}
	

	@Test
	public void UpdateEmployeeTest() {
		Employee emp1 = new Employee();
		emp1.setId(GenerateEnum.generateEmpId());
		emp1.setEmpName("Anusha");
		emp1.setSalary(1234);
		empImp.addEmployee(emp1).toString();
		Employee emp2 = new Employee();
		emp2.setId(GenerateEnum.generateEmpId());
		emp2.setEmpName("Anu");
		emp2.setSalary(1234);
		empImp.addEmployee(emp2).toString();
		Employee[] empsArr = empImp.getEmployees();
		Employee emp3 = new Employee();
		emp3.setId(empsArr[0].getId());
		emp3.setEmpName("Andu");
		emp3.setSalary(12354);
		assertEquals(emp3, empImp.updateEmployee(emp3));
	}
	
	@Test
	public void getEmpByEmpnoTest() {
		Employee emp1 = new Employee();
		emp1.setId(GenerateEnum.generateEmpId());
		emp1.setEmpName("Anusha");
		emp1.setSalary(1234);
		empImp.addEmployee(emp1).toString();
		Employee emp2 = new Employee();
		emp2.setId(GenerateEnum.generateEmpId());
		emp2.setEmpName("Anu");
		emp2.setSalary(1234);
		empImp.addEmployee(emp2).toString();
		Employee[] empsArr = empImp.getEmployees();
		Employee emp3 = new Employee();
		assertEquals(emp1, empImp.getEmpByEmpno(empsArr[0].getId()));
	}
	
	@Test
	public void searchEmployeeTest() {
		Employee emp1 = new Employee();
		emp1.setId(GenerateEnum.generateEmpId());
		emp1.setEmpName("Anusha");
		emp1.setSalary(1234);
		empImp.addEmployee(emp1).toString();
		Employee emp2 = new Employee();
		emp2.setId(GenerateEnum.generateEmpId());
		emp2.setEmpName("Anu");
		emp2.setSalary(1234);
		empImp.addEmployee(emp2).toString();
		Employee[] empsArr = empImp.getEmployees();
		Employee[] empArr = new Employee[] {emp1};
		assertEquals(Arrays.toString(empArr), Arrays.toString(empImp.searchEmployee(empsArr[0].getEmpName())));
	}

}
