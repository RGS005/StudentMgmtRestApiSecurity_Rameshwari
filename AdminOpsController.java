package my.smvc.hib.api.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.smvc.hib.api.model.Employee;
import my.smvc.hib.api.model.Role;
import my.smvc.hib.api.model.User;
import my.smvc.hib.api.service.EmployeeService;
import my.smvc.hib.api.service.RoleService;
import my.smvc.hib.api.service.UserService;

@RestController
@RequestMapping("/secure")
public class AdminOpsController {

	private static final String EMPLOYEE_WITH_ID = "Employee with id ";

	@Autowired
	private UserService userServiceImpl;

	@Autowired
	private RoleService roleServiceImpl;

	@Autowired
	EmployeeService employeeServiceImpl;
	

	// http://localhost:8080/api/employees/3
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(path = "/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(required = true, name = "id") Long id) {

		boolean deleted = employeeServiceImpl.deleteEmployee(id);
		String msg = deleted ? EMPLOYEE_WITH_ID + id + " was deleted" : EMPLOYEE_WITH_ID + id + " not found!!!";

		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}


	//ADD LIST OF NEW EMPLOYEES - IF 1 EMPLOYEE THEN PASS 1 OTHERWISE LIST OF EMPLOYEES
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping(path = "/employees")
	public ResponseEntity<List<Employee>> addEmployees(@RequestBody List<Employee> employees) {

		List<Employee> addedEmployees = employeeServiceImpl.addEmployee(employees);

		return new ResponseEntity<List<Employee>>(addedEmployees, HttpStatus.OK);
	}
	

	// PUT Employee
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(path = "/employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

		Employee updatedEmployee = employeeServiceImpl.updateEmployee(employee);
		
		if(updatedEmployee == null)
			throw new EntityNotFoundException(EMPLOYEE_WITH_ID + employee.getId() + " Not Found!!!");

		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/user")
	public ResponseEntity<User> user(@RequestBody User user) {
		
		User savedUser = userServiceImpl.saveUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/role")
	public ResponseEntity<Role> userRole(@RequestBody Role role) {
		Role savedRole = roleServiceImpl.saveRole(role);
		return new ResponseEntity<Role>(savedRole, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
