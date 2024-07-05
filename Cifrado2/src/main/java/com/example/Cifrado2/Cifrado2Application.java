package com.example.Cifrado2;

import com.example.Cifrado2.entities.User;
import com.example.Cifrado2.repositories.UserRepository;
import com.example.Cifrado2.security.enums.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Cifrado2Application {
	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(Cifrado2Application.class, args);
		System.out.println("CifradoApplication is running...");
		UserRepository userRepositori = context.getBean(UserRepository.class);

		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

		//User carlos = new User(null, "Carlos", "Ocampo", "carlos", "carlos@gmail.com", encoder.encode(("1234")), Role.USER);


		//userRepositori.save(carlos);
	}

}
