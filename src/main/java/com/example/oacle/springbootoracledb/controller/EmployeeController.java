package com.example.oacle.springbootoracledb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oacle.springbootoracledb.model.Employee;
import com.example.oacle.springbootoracledb.service.EmployeeService;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee emp) {
		Employee employee =  empService.addEmployee(emp);
		return employee;
	}
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> emp =  empService.getAllEmployees();
		return ResponseEntity.ok(emp);
		}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Integer id,@RequestBody Employee updateEmployee) {
		Employee emp = empService.updateEmployeeById(id,updateEmployee);
		return emp;
}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id) {
		 if (id == null) {
		        return ResponseEntity.badRequest().body("ID must not be null.");
		    }
		empService.deleteEmployeeById(id);
		return ResponseEntity.ok("success");
		
	}
	
	@GetMapping(value= "/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {
		Employee emp = empService.getEmployeeById(id);
			return emp;
	} 

}
