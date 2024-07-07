package com.example.Cifrado2.service;

import com.example.Cifrado2.entities.User;
import com.example.Cifrado2.repositories.UserRepository;
import com.example.Cifrado2.security.User_details;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Builder
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDetails = userRepository.findByUsername(username);
        //Converting userDetail to userDetails
        return userDetails.map(User_details::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found" + username));

    }

    public String addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User added succesfully";
    }

    public User getUserProfile(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

    }
}
