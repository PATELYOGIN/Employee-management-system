package com.task.employeeManagement.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employeetable")
public class EmployeeModel {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long emp_id;
	  
	  @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "dept_id", nullable = false) // FK column
	    private DepartmentModel  dept_id;

	    @Column(name = "employee_code", nullable = false, unique = true)
	    private String employee_code;

	    @Column(name = "first_name" , nullable = false)
	    private String first_name;

	    @Column(name = "last_name" ,nullable = false)
	    private String last_name;

	    @Column(name = "email" ,nullable = false, unique = true)
	    private String email;

	    @Column(name = "department")
	    private String department;

	    @Column(name = "salary" ,nullable = false)
	    private BigDecimal salary;

	    @Column(name = "date_of_joining", nullable = false)
	    private LocalDate date_of_joining;

	    @CreationTimestamp
	    @Column(name = "created_at" ,updatable = false)
	    private LocalDateTime created_at;

	    @UpdateTimestamp
	    private LocalDateTime updated_at;
	    
	    //constructor
	    
	    
	    public EmployeeModel() {
	    	
	    }
	    
		public EmployeeModel(Long emp_id, DepartmentModel dept_id, String employee_code, String first_name,
				String last_name, String email, String department, BigDecimal salary, LocalDate date_of_joining,
				LocalDateTime created_at, LocalDateTime updated_at) {
			super();
			this.emp_id = emp_id;
			this.dept_id = dept_id;
			this.employee_code = employee_code;
			this.first_name = first_name;
			this.last_name = last_name;
			this.email = email;
			//this.department = department;
			this.salary = salary;
			this.date_of_joining = date_of_joining;
			this.created_at = created_at;
			this.updated_at = updated_at;
		}


		public DepartmentModel getDept_id() {
			return dept_id;
		}

		public void setDept_id(DepartmentModel dept_id) {
			this.dept_id = dept_id;
		}

		public Long getEmp_id() {
			return emp_id;
		}

		public void setEmp_id(Long emp_id) {
			this.emp_id = emp_id;
		}

		public String getEmployee_code() {
			return employee_code;
		}

		public void setEmployee_code(String employee_code) {
			this.employee_code = employee_code;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		
		public BigDecimal getSalary() {
			return salary;
		}

		public void setSalary(BigDecimal salary) {
			this.salary = salary;
		}

		public LocalDate getDate_of_joining() {
			return date_of_joining;
		}

		public void setDate_of_joining(LocalDate date_of_joining) {
			this.date_of_joining = date_of_joining;
		}

		public LocalDateTime getCreated_at() {
			return created_at;
		}

		public void setCreated_at(LocalDateTime created_at) {
			this.created_at = created_at;
		}

		public LocalDateTime getUpdated_at() {
			return updated_at;
		}

		public void setUpdated_at(LocalDateTime updated_at) {
			this.updated_at = updated_at;
		}
 
           
}
