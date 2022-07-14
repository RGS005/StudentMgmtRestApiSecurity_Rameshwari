package my.smvc.hib.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.smvc.hib.api.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
