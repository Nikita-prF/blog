package com.example.blog.services;

import com.example.blog.models.ERole;
import com.example.blog.models.Role;
import com.example.blog.models.User;
import com.example.blog.repo.RoleRepository;
import com.example.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    /**
     * Implementation of PasswordEncoder that uses the BCrypt strong hashing function.
     */
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDetailServiceImpl() {
    }


    /**
     * A method that performs user search and authentication
     *
     * @param username Name or in this case the user's email
     * @return the object of the found user if it exists in the database.
     * @throws UsernameNotFoundException Exception when there is no user in the database
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }



    /**
     * The method registers a new user, saving it in a database.
     * @param newUser Object of a new user
     */
    public void save(User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}

