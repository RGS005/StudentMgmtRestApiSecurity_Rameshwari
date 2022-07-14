package my.smvc.hib.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.smvc.hib.api.model.Role;
import my.smvc.hib.api.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepo;

	public Role saveRole(Role role) {

		return roleRepo.save(role);

	}

}
