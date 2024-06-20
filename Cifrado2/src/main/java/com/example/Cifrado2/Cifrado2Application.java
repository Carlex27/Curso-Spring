package com.example.Cifrado2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Cifrado2Application {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(Cifrado2Application.class, args);
		System.out.println("CifradoApplication is running...");
		UserRepository userRepositori = context.getBean(UserRepository.class);

		//PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

		User carlos = new User(null, "Carlos", "1234");
		User Jadir = new User(null, "Jadir", "1234");
		userRepositori.save(carlos);
		//userRepositori.save(Jadir);
	}

}
