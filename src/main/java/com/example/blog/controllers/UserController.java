package com.example.blog.controllers;

import com.example.blog.models.ERole;
import com.example.blog.models.User;
import com.example.blog.repo.RoleRepository;
import com.example.blog.repo.UserRepository;
import com.example.blog.services.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserDetailServiceImpl userService;


    @PostMapping("/signUp")
    public void addUser(User user, HttpServletResponse response) {
        User userFromDb = userRepository.findByEmail(user.getEmail());


        if (userFromDb != null) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        } else {
            user.setRoles(roleRepository.findByRole(ERole.USER));
            userService.save(user);
        }
    }

}
