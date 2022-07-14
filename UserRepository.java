package my.smvc.hib.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.smvc.hib.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
