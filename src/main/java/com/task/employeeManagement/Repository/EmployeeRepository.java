package com.task.employeeManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.employeeManagement.model.EmployeeModel;

public interface EmployeeRepository  extends JpaRepository<EmployeeModel, Long>{

//	boolean existsByEmail(String email);
//	boolean existsByEmployeeCode(String employee_Code);

}
