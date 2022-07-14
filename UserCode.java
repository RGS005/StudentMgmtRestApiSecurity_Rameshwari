package my.smvc.hib.api;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.smvc.hib.api.model.Employee;
import my.smvc.hib.api.model.Role;
import my.smvc.hib.api.model.User;

public class UserCode {

	public static ObjectMapper objMapper = new ObjectMapper();

	public static void main(String... strings) {
		
		
		BCryptPasswordEncoder bcrupt = new BCryptPasswordEncoder();
		String encode = bcrupt.encode("password");
		System.out.println("'" + encode + "'");//$2a$10$riFxrsP8fAsyKLnofi08h.7AwIxCIp9YAdHAZm2BE/Nx1S/nKUpL6

		//==USER
		User user = new User();
		user.setEmail("a@a.com");
		user.setPassword("password");
		user.setUsername("username");
		
		TreeSet<Role> roles = new TreeSet<>();
		Role adminRole = new Role();
		adminRole.setRole("ADMIN");
		Role userRole = new Role();
		userRole.setRole("USER");
		roles.add(adminRole);
		roles.add(userRole);
		
		user.setRoles(roles);
		//==USER
		String json;
		
		//Employee
		Employee employee = new Employee();
		employee.setEmail("a@a.com");
		employee.setFirstname("fname");
		employee.setLastname("fname");
		
		
		List<Employee> employees = new ArrayList<>();
		employees.add(employee);
		
		
		try {
			json = objMapper.writeValueAsString(user);
			System.out.println("User:\n'" + json + "'");
			
			//Role
			json = objMapper.writeValueAsString(userRole);
			System.out.println("userRole:\n'" + json + "'");
			
			//employee
			json = objMapper.writeValueAsString(employee);
			System.out.println("employee:\n'" + json + "'");
			
			//employees
			json = objMapper.writeValueAsString(employees);
			System.out.println("employees:\n'" + json + "'");
			
			
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
