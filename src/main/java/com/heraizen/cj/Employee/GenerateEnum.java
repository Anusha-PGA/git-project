package com.heraizen.cj.Employee;

public enum GenerateEnum {
	obj;
	public static int empId = 1001;
	public static int generateEmpId() {
		return empId++;
	}


}
