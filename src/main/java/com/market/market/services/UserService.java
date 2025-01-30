package com.market.market.services;

import com.market.market.exceptions.UserNotFoundException;
import com.market.market.models.User;
import com.market.market.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User findUserByCPF(String CPF) throws Exception {
        return this.userRepository.findByCPF(CPF).orElseThrow(UserNotFoundException::new);
    }

    public User findUserByUsername(String username) throws Exception {
        return this.userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }


}
