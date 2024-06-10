package org.example.casestudymodule4.config.service;

import org.example.casestudymodule4.config.UserPrinciple;
import org.example.casestudymodule4.model.User;
import org.example.casestudymodule4.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    public User findUserByName(String name){
        return userRepository.findUserByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return UserPrinciple.build(userRepository.findUserByUsername(username));
    }

    public User authenticate(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            return user; // Authentication successful
        }
        return null; // Authentication failed
    }
}
