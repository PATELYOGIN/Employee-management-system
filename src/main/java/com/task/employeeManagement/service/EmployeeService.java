package com.task.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.employeeManagement.Repository.DepartmentRepository;
import com.task.employeeManagement.Repository.EmployeeRepository;
import com.task.employeeManagement.model.DepartmentModel;
import com.task.employeeManagement.model.EmployeeModel;

@Service
public class EmployeeService {
	
	 private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
    private EmployeeRepository employeeRepository;
	private  DepartmentRepository departmentRepository;
	

	 public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
	        this.employeeRepository = employeeRepository;
	        this.departmentRepository = departmentRepository;
	    }
	
//    public EmployeeModel saveEmployee(EmployeeModel employee) {
//    	
//    	 log.info("Service received Employee: {}", employee);
//    	 EmployeeModel saved = employeeRepository.save(employee);
//         log.info("Service saved Employee in DB: {}", saved);
//        return employeeRepository.save(employee);
//
//    }

	 
	 
    public EmployeeModel saveEmployee(EmployeeModel employee) {
        log.info("Service received Employee: {}", employee);
        EmployeeModel saved = employeeRepository.save(employee);
        log.info("Service saved Employee in DB: {}", saved);
        return saved;
    }
    
    
    // Get all employees
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }
  
    
    // Get employee by ID
    public Optional<EmployeeModel> getEmployeeById(Long emp_id) {
        return employeeRepository.findById(emp_id);
    }
    
 
    //delete employee
    public boolean deleteEmployeeById(Long emp_id) {
        if (employeeRepository.existsById(emp_id)) {
            employeeRepository.deleteById(emp_id);
            return true;
        }
        return false;
    }
    
public EmployeeModel updateEmployee(Long id, EmployeeModel employee) {
	    
	    EmployeeModel existing = employeeRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));
	    
	    existing.setEmployee_code(employee.getEmployee_code());
	    existing.setFirst_name(employee.getFirst_name());
	    existing.setLast_name(employee.getLast_name());
	    existing.setEmail(employee.getEmail());
	    existing.setSalary(employee.getSalary());
	    existing.setDate_of_joining(employee.getDate_of_joining());
	    existing.setDepartment(employee.getDepartment());
	    
	    return employeeRepository.save(existing);
	    
	 }
    

    
//   // this checkes the dupicates data
//    public boolean isEmailExists(String email) {
//        return employeeRepository.existsByEmail(email);
//    }
//
//    public boolean isEmployeeCodeExists(String code) {
//        return employeeRepository.existsByEmployeeCode(code);
//   }
	

    
    
}
