package my.smvc.hib.api.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import my.smvc.hib.api.model.Employee;
import my.smvc.hib.api.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	// 1 Add New or Update Employee
	public List<Employee> addEmployee(List<Employee> employee) {
		return employeeRepo.saveAll(employee);
	}

	public Employee updateEmployee(Employee employee) {

		Optional<Employee> optionalEmployee = employeeRepo.findById(employee.getId());

		if (optionalEmployee.isPresent()) {
			Employee existingEmp = optionalEmployee.get();

			if (employee.getEmail() != null)
				existingEmp.setEmail(employee.getEmail());
			if (employee.getFirstname() != null)
				existingEmp.setFirstname(employee.getFirstname());
			if (employee.getLastname() != null)
				existingEmp.setLastname(employee.getLastname());

			return employeeRepo.save(existingEmp);

		}

		return null;
	}

	// 2. Get All Employees in DB
	public List<Employee> getAllEmployees(String sortOrder) {

		if (sortOrder != null && "ASC".equalsIgnoreCase(sortOrder)) {

			return employeeRepo.findAll(Sort.by(Sort.Direction.ASC, "firstname"));

		} else if (sortOrder != null && "DESC".equalsIgnoreCase(sortOrder)) {

			return employeeRepo.findAll(Sort.by(Sort.Direction.DESC, "firstname"));

		}

		return employeeRepo.findAll();

	}

	// Get All with matching First Name
	public List<Employee> getAllByFirstName(String firstName) {

		return employeeRepo.findByFirstname(firstName.trim());
	}

	// Find Employee by Id
	public Employee getEmployee(long id) {

		Optional<Employee> optionalEmployee = employeeRepo.findById(id);

		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}

		return null;
	}

	// 4. Delete by Id
	public boolean deleteEmployee(long id) {

		if (this.getEmployee(id) != null) {
			employeeRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
