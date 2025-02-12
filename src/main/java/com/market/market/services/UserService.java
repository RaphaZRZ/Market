package com.market.market.services;

import com.market.market.dtos.UpdateUserDTO;
import com.market.market.dtos.UserDTO;
import com.market.market.exceptions.CPFAlreadyRegisteredException;
import com.market.market.exceptions.EmailAlreadyRegisteredException;
import com.market.market.exceptions.UserNotFoundException;
import com.market.market.exceptions.UsernameAlreadyRegisteredException;
import com.market.market.models.User;
import com.market.market.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class responsible for handling user-related business logic.
 * It interacts with the UserRepository to perform some operations on users.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * Finds a user by its ID.
     *
     * @param id the unique identifier of the user.
     * @return the found user.
     * @throws UserNotFoundException if the user with the given id is not found.
     */
    public User findUserById(Long id) {
        return this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user.
     * @return the found user.
     * @throws UserNotFoundException if the user with the given username is not found.
     */
    public User findUserByUsername(String username) {
        return this.userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    /**
     * Finds a user by their CPF (Cadastro de Pessoas Físicas).
     *
     * @param CPF the CPF of the user.
     * @return the found user.
     * @throws UserNotFoundException if the user with the given CPF is not found.
     */
    public User findUserByCPF(String CPF) {
        return this.userRepository.findByCPF(CPF).orElseThrow(UserNotFoundException::new);
    }

    /**
     * Finds a user by their email address.
     *
     * @param email the email of the user.
     * @return the found user.
     * @throws UserNotFoundException if the user with the given email is not found.
     */
    public User findUserByEmail(String email) {
        return this.userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

    /**
     * Saves a given user to the repository.
     *
     * @param user the user to save.
     */
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    /**
     * Updates the details of a user.
     *
     * @param updatedUser   the user to update.
     * @param updateUserDTO the DTO containing the updated user information.
     */
    public void updateUser(User updatedUser, UpdateUserDTO updateUserDTO) {
        if (userRepository.existsByUsername(updateUserDTO.username()))
            throw new UsernameAlreadyRegisteredException();

        updatedUser.setUsername(updateUserDTO.username());
        updatedUser.setPassword(updateUserDTO.password());
    }

    /**
     * Creates a new user using the provided UserDTO.
     *
     * @param userDTO the DTO containing the user information.
     * @return the newly created user.
     */
    @Transactional
    public User createUser(UserDTO userDTO) {
        if (this.userRepository.existsByUsername(userDTO.username()))
            throw new UsernameAlreadyRegisteredException();
        if (this.userRepository.existsByCPF(userDTO.CPF()))
            throw new CPFAlreadyRegisteredException();
        if (this.userRepository.existsByEmail(userDTO.email()))
            throw new EmailAlreadyRegisteredException();

        User user = new User(userDTO);
        saveUser(user);
        return user;
    }

    /**
     * Updates an existing user's details by their ID.
     *
     * @param updateUserDTO the DTO containing the updated user information.
     * @param id            the unique identifier of the user to update.
     * @throws UserNotFoundException if the user with the given id is not found.
     */
    @Transactional
    public void updateUserById(UpdateUserDTO updateUserDTO, Long id) {
        User updatedUser = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        updateUser(updatedUser, updateUserDTO);
        saveUser(updatedUser);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id the unique identifier of the user to delete.
     * @throws UserNotFoundException if the user with the given id is not found.
     */
    @Transactional
    public void deleteUserById(Long id) {
        if (!this.userRepository.existsById(id))
            throw new UserNotFoundException();
        this.userRepository.deleteById(id);
    }
}
