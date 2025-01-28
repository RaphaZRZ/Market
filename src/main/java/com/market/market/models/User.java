package com.market.market.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "users")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @NotNull(message = "{firstName.NotNull}")
    @Size(min = 3, max = 20, message = "{firstName.Size}")
    @Column(name = "firstName")
    private String firstName;

    @NotNull(message = "{lastName.NotNull}")
    @Size(min = 3, max = 20, message = "{lastName.Size}")
    @Column(name = "lastName")
    private String lastName;

    @NotNull(message = "{username.NotNull}")
    @Size(min = 3, max = 50, message = "{username.Size}")
    @Column(name = "username", unique = true)
    private String username;

    @NotNull(message = "{CPF.NotNull}")
    @Column(name = "CPF", unique = true)
    private String CPF;

    @NotNull(message = "{email.NotNull}")
    @Size(min = 6, max = 320, message = "{email.Size}")
    @Email(message = "{email.Invalid}")
    @Column(name = "email", unique = true)
    private String email;

    @NotNull(message = "{password.NotNull}")
    @Size(min = 6, max = 60, message = "{password.Size}")
    @Column(name = "password")
    private String password;

    @NotNull(message = "{userType.NotNull}")
    @Enumerated(EnumType.STRING)
    @Column(name = "userType")
    private UserType userType;
}
