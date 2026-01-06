package com.task.employeeManagement.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.employeeManagement.model.DepartmentModel;
import com.task.employeeManagement.model.EmployeeModel;
import com.task.employeeManagement.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	 @Autowired
	    private DepartmentService departmentservice;
	
	
	 public DepartmentController(DepartmentService departmentservice) {
		 this.departmentservice = departmentservice;
		 
	 }
	 
	 
	@PostMapping("/create")
	public  ResponseEntity<DepartmentModel> createDepartment(@RequestBody DepartmentModel dept) {
		

		 log.info("Controller received Employee: {}",dept );

		 DepartmentModel savedepartment = departmentservice.savedepartment(dept);
	        log.info("Controller sending response: {}", savedepartment);
	        
	        return new ResponseEntity<>(savedepartment, HttpStatus.CREATED);
	    }
	
	@GetMapping("/department")
	public ResponseEntity<?> getAllDepartment(){
		
	List<DepartmentModel> department = departmentservice.getalldepartment();
	
	 if (department.isEmpty()) {
         // 404 if not found 
         return new ResponseEntity<>("No employees found", HttpStatus.NOT_FOUND);
     }
     return new ResponseEntity<>(department, HttpStatus.OK);
 }
	
	@GetMapping("/department/{dept_id}")
	public ResponseEntity<?> GetDepartmentById(@PathVariable Long dept_id){
		Optional<DepartmentModel> department = departmentservice.getdepartmentById(dept_id);

        if (department.isPresent()) {
            return new ResponseEntity<>(department.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee not found with ID: " + dept_id, HttpStatus.NOT_FOUND);
        }
		
		
	}
	
	 @PutMapping("/department/{deptId}")
	    public ResponseEntity<?> updateDepartment(
	            @PathVariable("deptId") Long deptId,
	            @RequestBody DepartmentModel departmentDetails) {

	        try {
	            DepartmentModel updatedDepartment = departmentservice.updateDepartment(deptId, departmentDetails);
	            return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>("Department not found", HttpStatus.NOT_FOUND);
	        }
		
	 }
	 
	 
	 @DeleteMapping("/department/{id}")
	 public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long id) {
	     String result = departmentservice.deleteDepartment(id);

	     if (result.contains("Cannot delete") || result.contains("not found")) {
	         return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	     }

	     return new ResponseEntity<>(result, HttpStatus.OK);
	 }
		 
	 }

	 

		
		
	
	
	

