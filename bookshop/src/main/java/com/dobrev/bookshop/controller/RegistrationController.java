package com.dobrev.bookshop.controller;

import com.dobrev.bookshop.entity.Role;
import com.dobrev.bookshop.entity.UserEntity;
import com.dobrev.bookshop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserEntity user, Map<String, Object> model) {
        UserEntity userFromDb = userRepo.findByUsername(user.getUsername());
        System.out.println(userRepo.findByUsername(user.getUsername()));

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
