package com.task.employeeManagement.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.employeeManagement.Repository.DepartmentRepository;
import com.task.employeeManagement.Repository.EmployeeRepository;
import com.task.employeeManagement.model.DepartmentModel;
import com.task.employeeManagement.model.EmployeeModel;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentrepository;
	private EmployeeRepository employeeRepository;
	
	
	// create department 
	public DepartmentModel savedepartment (DepartmentModel dept) {
		return departmentrepository.save(dept);
	}
	
	// get all department 
	public List<DepartmentModel> getalldepartment() {
		return departmentrepository.findAll();
		
	}
	
	// get department by id
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
	  
	  
	// Delete department only if no employees exist
	  public String deleteDepartment(Long deptId) {
	      // Fetch department by id
	      Optional<DepartmentModel> deptOpt = departmentrepository.findById(deptId);

	      if (!deptOpt.isPresent()) {
	          return "Department not found with id: " + deptId;
	      }
	      DepartmentModel department = deptOpt.get();
	      // Check if employees exist
	      if (department.getEmployees() != null && !department.getEmployees().isEmpty()) {
	          return "Cannot delete department because it has employees.";
	      }

	      // Safe to delete
	      departmentrepository.delete(department);
	      return "Department deleted successfully.";
	  
	      
	  }
	  
	
}
