package io.gettarrays.userservice;

import io.gettarrays.userservice.domain.Role;
import io.gettarrays.userservice.domain.User;
import io.gettarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();

	}

	@Bean
	CommandLineRunner run(UserService userService){
		return  args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John", "doe", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "ibrahim", "doe", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Jim Carry", "doe", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Arlnod", "diaaz", "1234", new ArrayList<>()));

			userService.addRoleToUser("John", "ROLE_USER");
			userService.addRoleToUser("John", "ROLE_MANAGER");
			userService.addRoleToUser("ibrahim", "ROLE_MANAGER");
			userService.addRoleToUser("Jim Carry", "ROLE_USER_ADMIN");
			userService.addRoleToUser("Arlnod", "ROLE_USER");

		};
	}

}
