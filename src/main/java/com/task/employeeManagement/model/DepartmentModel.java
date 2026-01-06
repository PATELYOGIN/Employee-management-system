package com.task.employeeManagement.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Departmenttable")
public class DepartmentModel {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dept_id;
	
	 @OneToMany(mappedBy = "department")
	    private List<EmployeeModel> employees;

    @Column(name = "dept_name", nullable = false, unique = true)
    private String dept_name;
    
    @Column(name = "dept_code", nullable = false, unique = true)
    private String dept_code;
    
    @Column(name = "dept_descr", nullable = false, unique = true)
    private String dept_descr;
    
    @Column(name = "is_active")
    private boolean is_active;
    
    @CreationTimestamp
    @Column(name = "created_at" ,updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
    
    
    //constructor 
    
    public DepartmentModel() {
    	
    }
    
    public DepartmentModel(Long dept_id, String dept_name, String dept_code, String dept_descr, String is_active,
			LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_code = dept_code;
		this.dept_descr = dept_descr;
		//this.is_active = is_active;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
    
    //getter and setter 
    
    public List<EmployeeModel> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeModel> employees) {
        this.employees = employees;
    }
    

    public Long getDeptId() {
        return dept_id;
    }

    public void setDeptId(Long deptId) {
        this.dept_id = deptId;
    }

//	public Long getDept_id() {
//		return dept_id;
//	}
//
//	public void setDept_id(Long dept_id) {
//		this.dept_id = dept_id;
//	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getDept_descr() {
		return dept_descr;
	}

	public void setDept_descr(String dept_descr) {
		this.dept_descr = dept_descr;
	}

//	public String getIs_active() {
//		return is_active;
//	}
//
//	public void setIs_active(String is_active) {
//		this.is_active = is_active;
//	}

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
