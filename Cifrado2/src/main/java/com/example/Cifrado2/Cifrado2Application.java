package com.example.Cifrado2;

import com.example.Cifrado2.entities.User;
import com.example.Cifrado2.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Cifrado2Application {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(Cifrado2Application.class, args);
		System.out.println("CifradoApplication is running...");
		UserRepository userRepositori = context.getBean(UserRepository.class);

		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

		User carlos = new User(null, "Carlos", encoder.encode("1234"));
		User Jadir = new User(null, "Jadir", "1234");
		userRepositori.save(carlos);
		userRepositori.save(Jadir);
	}

}
