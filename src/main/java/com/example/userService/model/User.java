package com.example.userService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "First name mandatory")
    private String firstName;
    @NotNull(message = "Last name mandatory")
    private String lastName;
    @NotNull(message = "E-mail mandatory")
    @Email
    private String email;
    @NotNull(message = "Birthday mandatory")
    private Date birth;
    @NotNull(message = "Postal code mandatory")
    @ManyToOne
    @JoinColumn
    private Postal postal;
}
