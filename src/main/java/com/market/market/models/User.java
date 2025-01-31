package com.market.market.models;

import com.market.market.dtos.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Represents a user in the system.
 * A user has a first name, last name, username, CPF, email, password, and type.
 * It is mapped to the "users" table in the database.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "users")
@Table(name = "users")
public class User {
    /**
     * Unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    /**
     * First name of the user. Must be between 3 and 20 characters long.
     */
    @NotBlank(message = "{firstName.NotBlank}")
    @Size(min = 3, max = 20, message = "{firstName.Size}")
    @Column(name = "first_name")
    private String firstName;

    /**
     * Last name of the user. Must be between 3 and 20 characters long.
     */
    @NotBlank(message = "{lastName.NotBlank}")
    @Size(min = 3, max = 20, message = "{lastName.Size}")
    @Column(name = "last_name")
    private String lastName;

    /**
     * Username of the user. Must be between 3 and 50 characters long.
     */
    @NotBlank(message = "{username.NotBlank}")
    @Size(min = 3, max = 50, message = "{username.Size}")
    @Column(name = "username", unique = true)
    private String username;

    /**
     * CPF of the user. Must have exactly 11 characters long and be unique.
     */
    @NotBlank(message = "{CPF.NotBlank}")
    @Column(name = "CPF", unique = true)
    private String CPF;

    /**
     * Email of the user. Must be between 6 and 320 characters.
     */
    @NotBlank(message = "{email.NotBlank}")
    @Size(min = 6, max = 320, message = "{email.Size}")
    @Email(message = "{email.Invalid}")
    @Column(name = "email", unique = true)
    private String email;

    /**
     * Password of the user. Must be between 6 and 60 characters.
     */
    @NotBlank(message = "{password.NotBlank}")
    @Size(min = 6, max = 60, message = "{password.Size}")
    @Column(name = "password")
    private String password;

    /**
     * Type of the user, indicating their role or permission level in the system.
     */
    @NotNull(message = "{userType.NotNull}")
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;


    /**
     * Constructs a new User instance from a UserDTO object.
     * Initializes the user with the provided first name, last name, username, CPF, email, password, and user type.
     *
     * @param userDTO The UserDTO containing user data.
     * @throws Exception if an error occurs during object creation.
     */
    public User(UserDTO userDTO) throws Exception {
        this.firstName = userDTO.firstName();
        this.lastName = userDTO.lastName();
        this.username = userDTO.username();
        this.CPF = userDTO.CPF();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.userType = userDTO.userType();
    }
}
