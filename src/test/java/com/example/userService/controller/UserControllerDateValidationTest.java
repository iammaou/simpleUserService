package com.example.userService.controller;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerDateValidationTest {

    @Test
    void goodDate() {
        UserController controller = new UserController();
        LocalDate date = LocalDate.of(2005, 7, 30);
        assertTrue(controller.dateValidation(date));
    }

    @Test
    void BadDate(){
        UserController controller = new UserController();
        LocalDate date = LocalDate.of(LocalDate.now().getYear()+1, 1, 1);
        assertFalse(controller.dateValidation(date));
    }
}