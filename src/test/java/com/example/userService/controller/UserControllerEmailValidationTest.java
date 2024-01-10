package com.example.userService.controller;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerEmailValidationTest {

    @Test
    void emailValidationTrue() {
        UserController controller = new UserController();
        String email = "whatever@gmail.com";

        assertTrue(controller.emailValidation(email));
    }

    @Test
    void emailValidationFalse(){
        UserController controller = new UserController();
        String email = "whatevergmail.com";

        assertFalse(controller.emailValidation(email));
    }
}