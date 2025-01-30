package com.market.market.controllers;

import com.market.market.models.User;
import com.market.market.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    // GET MAPPINGS
    @GetMapping("/id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) throws Exception {
        User obj = this.userService.findUserById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/CPF/{CPF}")
    public ResponseEntity<User> findByCPF(@PathVariable String CPF) throws Exception {
        User obj = this.userService.findUserByCPF(CPF);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) throws Exception {
        User obj = this.userService.findUserByUsername(username);
        return ResponseEntity.ok().body(obj);
    }
}
