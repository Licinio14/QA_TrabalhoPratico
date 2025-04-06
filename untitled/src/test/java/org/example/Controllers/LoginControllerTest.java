package org.example.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    LoginController loginController;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        this.loginController = new LoginController("src/main/resources/Cesaeland_logins.csv");
    }


    @Test
    public void aprovedAdminLoginTest() throws FileNotFoundException {
        String access = loginController.accessType("a","a");
        assertEquals("ADMIN", access);

        access = loginController.accessType("it","password123");
        assertEquals("ADMIN", access);
    }

    @Test
    public void aprovedEnginerLoginTest() throws FileNotFoundException {
        String access = loginController.accessType("e","e");
        assertEquals("ENG", access);

        access = loginController.accessType("manutencao","cesaeland");
        assertEquals("ENG", access);
    }

    @Test
    public void ReprovedLoginTest() throws FileNotFoundException {
        String access = loginController.accessType("imAadmin","StrongPassword9");
        assertEquals("ERROR", access);

        access = loginController.accessType("Destro","camomila");
        assertEquals("ERROR", access);
    }
}