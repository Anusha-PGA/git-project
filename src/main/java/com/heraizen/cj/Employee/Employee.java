package com.heraizen.cj.Employee;

public class Employee {
		private String empName;
		private int id;
		private int salary;
		public String getEmpName() {
			//fkjhgsdjgh
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}        
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((empName == null) ? 0 : empName.hashCode());
			result = prime * result + id;
			result = prime * result + salary;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (empName == null) {
				if (other.empName != null)
					return false;
			} else if (!empName.equals(other.empName))
				return false;
			if (id != other.id)
				return false;
			if (salary != other.salary)
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "Employee [empName=" + empName + ", id=" + id + ", salary=" + salary + "]";
		}
		

}
