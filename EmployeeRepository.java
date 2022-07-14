package my.smvc.hib.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import my.smvc.hib.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	//SEARCH FUNCTIONALITIES USUALLY LIST ALL MATCHING RATHER THAN EXACT MATCH 
	//HENCE LIKE AND NOT = 
//	@Query("SELECT e FROM EMPLOYEE e WHERE e.firstName LIKE '%:firstName%'")
//	List<Employee> findAllByFirstName(@Param("firstName") String firstName);
	
	List<Employee> findByFirstname(String firstname);


}
