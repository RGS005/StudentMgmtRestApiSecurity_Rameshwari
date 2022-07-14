package my.smvc.hib.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import my.smvc.hib.api.model.User;
import my.smvc.hib.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
//	private PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();

	public User saveUser(User user) {

		String password = user.getPassword();
		String bCryptedPassword = passwordEncoder.encode(password);
		user.setPassword(bCryptedPassword);

		return userRepo.save(user);

	}

}
