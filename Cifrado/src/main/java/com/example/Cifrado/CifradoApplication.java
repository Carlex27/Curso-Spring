package com.example.Cifrado;

import com.example.Cifrado.entities.User;
import com.example.Cifrado.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CifradoApplication {


	public static void main(String[] args) {
		ApplicationContext context =
		SpringApplication.run(CifradoApplication.class, args);
		System.out.println("CifradoApplication is running...");
		UserRepository userRepositori = context.getBean(UserRepository.class);

		//PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

		User carlos = new User(null, "Carlos", "1234");
		User Jadir = new User(null, "Jadir", "1234");
		userRepositori.save(carlos);
		//userRepositori.save(Jadir);

	}

}
