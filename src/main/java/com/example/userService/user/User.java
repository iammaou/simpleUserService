package com.example.userService.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    private Long id;
    @NotNull(message = "First name mandatory")
    private String firstName;
    @NotNull(message = "Last name mandatory")
    private String lastName;
    @NotNull(message = "E-mail mandatory")
    private String email;
    @NotNull(message = "Birthday mandatory")
    private Date birth;
    @NotNull(message = "Postal code mandatory")
    private int postal;

    public User(Long id, String firstName, String lastName, String email, Date birth, int postal) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birth = birth;
        this.postal = postal;
    }

    public User(){
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "birthday")
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Column(name = "postal_code")
    public int getPostal() {
        return postal;
    }

    public void setPostal(int postal) {
        this.postal = postal;
    }
}
