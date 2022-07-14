package my.smvc.hib.api.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import my.smvc.hib.api.model.Employee;
import my.smvc.hib.api.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeServiceImpl;

	// GET ALL EMPLOYEES
	@GetMapping(path = "/employees")
	public ResponseEntity<List<Employee>> getEmployees() {

		List<Employee> allEmployees = employeeServiceImpl.getAllEmployees(null); // Get All Employees
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
	}

	// GET EMPLOYEE BY ID
	// http://localhost:8080/api/employees/3
	@GetMapping(path = "/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable(required = true, name = "id") Long id) {

		Employee employee = employeeServiceImpl.getEmployee(id);

		if (employee == null)
			throw new EntityNotFoundException("Employee with ID " + id + " was not Found in DB");

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	// SEARCH EMPLOYEE BY FIRST NAME
	// http://localhost:8080/api/employees/search/gl
	@GetMapping(path = "/employees/search/{firstName}")
	public ResponseEntity<List<Employee>> searchEmployeesWithFirstName(
			@PathVariable(required = true, name = "firstName") String firstName) {

		List<Employee> allEmployees = employeeServiceImpl.getAllByFirstName(firstName); // Get All Employees
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
	}

	// SEPARATE SORT URL is different than /employees/sort has "sort" in path
	// http://localhost:8080/api/employees/sort?order=”asc”
	@GetMapping(path = "/employees/sort")
	public ResponseEntity<List<Employee>> getEmployeesWithSorting(
			@RequestParam(required = true, name = "order", defaultValue = "asc") String order) {

		List<Employee> allEmployees = employeeServiceImpl.getAllEmployees(order); // Get All Employees
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
	}

}
