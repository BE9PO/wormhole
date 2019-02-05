package com.example.wormhole.controller;

import com.example.wormhole.domain.Role;
import com.example.wormhole.domain.User;
import com.example.wormhole.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user,
                          String fullName,
                          String surname,
                          Model model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.addAttribute("message", "User already exist");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setFullUserName(fullName);
        user.setFullUserSurname(surname);
        user.setDateOfRegistration(System.currentTimeMillis());
        userRepository.save(user);
        return "redirect:/login";
    }

}
