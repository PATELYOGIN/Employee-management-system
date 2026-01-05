package com.task.employeeManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.employeeManagement.Repository.EmployeeRepository;
import com.task.employeeManagement.model.EmployeeModel;
import com.task.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	 @Autowired
	    private EmployeeService employeeService;
	 
	 public EmployeeController(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	        		
	 }
	 @Autowired 
	 private EmployeeRepository employeeRepository;
	 
	 @PostMapping("/create")
	    public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel employee) {
		 
		 log.info("Controller received Employee: {}", employee);

		 EmployeeModel savedEmployee = employeeService.saveEmployee(employee);
	        log.info("Controller sending response: {}", savedEmployee);
	        
	        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	    }
	 

//	    @PostMapping("/create")
//	    public ResponseEntity<String> createEmployee(
//	            @RequestBody EmployeeModel employee) {
//
//	        if (employeeService.isEmailExists(employee.getEmail())) {
//	            return ResponseEntity
//	                    .status(HttpStatus.CONFLICT)
//	                    .body("Email already exists");
//	        }
//
//	        if (employeeService.isEmployeeCodeExists(employee.getEmployee_code())) {
//	            return ResponseEntity.status(HttpStatus.CONFLICT)
//	                    .body("Employee code already exists");
//        }
//
//	        employeeService.saveEmployee(employee);
//
//	        return ResponseEntity
//	                .status(HttpStatus.CREATED)
//	                .body("Employee created successfully");
//	    }
	    
	 
	    
	 // Get all employee
	 
	 @GetMapping("/employee")
	    public ResponseEntity<?> getAllEmployees() {
	        List<EmployeeModel> employees = employeeService.getAllEmployees();

	        if (employees.isEmpty()) {
	            // 404 if not found 
	            return new ResponseEntity<>("No employees found", HttpStatus.NOT_FOUND);
	        }

	        // if employees are found then 200
	        return new ResponseEntity<>(employees, HttpStatus.OK);
	    }
	 
	 
	 // Get emp by ID 
	    
	    @GetMapping("/employee/{emp_id}")
	    public ResponseEntity<?> getEmployeeById(@PathVariable Long emp_id) {
	        Optional<EmployeeModel> employee = employeeService.getEmployeeById(emp_id);

	        if (employee.isPresent()) {
	            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Employee not found with ID: " + emp_id, HttpStatus.NOT_FOUND);
	        }
	    }
	


	    @DeleteMapping("/employee/{emp_id}")
	    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long emp_id){
	    	employeeService.deleteEmployeeById(emp_id);

	        return new ResponseEntity<>("Employee deleted successfully with ID: " + emp_id,
	                HttpStatus.OK);
	    }


}
	
	
	

