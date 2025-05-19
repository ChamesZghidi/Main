package com.teckUP.demo.Service;

import com.teckUP.demo.models.User;
import com.teckUP.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

    @Service
    public class UserService {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        public User registerUser(User user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }

        public boolean authenticateUser(String username, String password) {
            User user = userRepository.findByNom(username);

            if (user != null) {
                return passwordEncoder.matches(password, user.getPassword());
            }
            return false;
        }

    }

