package org.example.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    LoginController loginController;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        this.loginController = new LoginController();
    }


    @Test
    public void aprovedAdminLoginTest() throws FileNotFoundException {
        String access = loginController.accessType("a","a");
    }

    @Test
    public void aprovedEnginerLoginTest() throws FileNotFoundException {
        String access = loginController.accessType("e","e");

    }
}