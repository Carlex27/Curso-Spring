package com.example.SpringSecurity.service;

import com.example.SpringSecurity.entities.User;
import com.example.SpringSecurity.entities.UserDetails2;
import com.example.SpringSecurity.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> userDetails = userRepository.findByUsername(username);
        //Converting userDetail to userDetails
        return userDetails.map(UserDetails2::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found" + username));

    }
    public String addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User added succesfully";
    }
}
