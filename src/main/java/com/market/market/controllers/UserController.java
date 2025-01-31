package com.market.market.controllers;

import com.market.market.dtos.UserDTO;
import com.market.market.models.User;
import com.market.market.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    UserService userService;

    // GET MAPPINGS
    @GetMapping("/id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) throws Exception {
        User obj = this.userService.findUserById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) throws Exception {
        User obj = this.userService.findUserByUsername(username);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/CPF/{CPF}")
    public ResponseEntity<User> findByCPF(@PathVariable String CPF) throws Exception {
        User obj = this.userService.findUserByCPF(CPF);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) throws Exception {
        User obj = this.userService.findUserByEmail(email);
        return ResponseEntity.ok().body(obj);
    }

    // POST MAPPINGS
    @Validated
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) throws Exception{
        User user = this.userService.createUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
