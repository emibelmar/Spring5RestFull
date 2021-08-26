package com.ebmdev.users;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ebmdev.users.entities.Role;
import com.ebmdev.users.entities.User;
import com.ebmdev.users.entities.UserInRole;
import com.ebmdev.users.repositories.RoleRepository;
import com.ebmdev.users.repositories.UserInRoleRepository;
import com.ebmdev.users.repositories.UserRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class UsersAppApplication implements ApplicationRunner {

	@Autowired
	public Faker faker;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserInRoleRepository userInRoleRepository;

	private static final Logger log = LoggerFactory.getLogger(UsersAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UsersAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role roles[] = { new Role("ADMIN"), new Role("USER"), new Role("SUPPORT") };

		for (Role role : roles) {
			roleRepository.save(role);
		}

		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setUsername(faker.name().username());
			user.setPassword(faker.dragonBall().character());
			User userCreated = userRepository.save(user);

			UserInRole userInRole = new UserInRole(userCreated, roles[new Random().nextInt(3)]);
			userInRoleRepository.save(userInRole);

			log.info("User created username = {} password = {} role = {}", userCreated.getUsername(),
					userCreated.getPassword(), userInRole.getRole().getName());

		}

	}

}
