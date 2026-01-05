package com.task.employeeManagement.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.employeeManagement.Repository.DepartmentRepository;
import com.task.employeeManagement.model.DepartmentModel;
import com.task.employeeManagement.model.EmployeeModel;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentrepository;
	
	
	public DepartmentModel savedepartment (DepartmentModel dept) {
		return departmentrepository.save(dept);
	}
	
	public List<DepartmentModel> getalldepartment() {
		return departmentrepository.findAll();
		
	}
	
	public Optional <DepartmentModel>getdepartmentById (Long dept_id){
		return departmentrepository.findById(dept_id);
	}
	
	
	  public DepartmentModel updateDepartment(Long deptId, DepartmentModel departmentDetails) {
	        // Fetch existing department
	        DepartmentModel department = departmentrepository.findById(deptId)
	                .orElseThrow(() -> new NoSuchElementException("Department not found"));

	        // Update fields
	        department.setDept_code(departmentDetails.getDept_code());
	        department.setDept_name(departmentDetails.getDept_name());
	        department.setDept_descr(departmentDetails.getDept_descr());
	       // department.setIsActive(departmentDetails.getIsActive());

	        // Save updated department
	        return departmentrepository.save(department);
	    }
	
}
