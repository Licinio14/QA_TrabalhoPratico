package org.example.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    LoginController loginController;

    /**
     * Create an engineer controller with all it needs to work
     * @throws FileNotFoundException
     */
    @BeforeEach
    void setUp() throws FileNotFoundException {
        this.loginController = new LoginController("src/main/resources/Cesaeland_logins.csv");
    }

    /**
     * Test if the function can read and verify the type of the account for admins
     * @throws FileNotFoundException
     */
    @Test
    public void aprovedAdminLoginTest() throws FileNotFoundException {
        String access = loginController.accessType("a","a");
        assertEquals("ADMIN", access);

        access = loginController.accessType("it","password123");
        assertEquals("ADMIN", access);
    }

    /**
     * Test if the function can read and verify the type of the account for engineers
     * @throws FileNotFoundException
     */
    @Test
    public void aprovedEnginerLoginTest() throws FileNotFoundException {
        String access = loginController.accessType("e","e");
        assertEquals("ENG", access);

        access = loginController.accessType("manutencao","cesaeland");
        assertEquals("ENG", access);
    }

    /**
     * Test if the function can read and verify the type of the account for non-existent accounts
     * @throws FileNotFoundException
     */
    @Test
    public void ReprovedLoginTest() throws FileNotFoundException {
        String access = loginController.accessType("imAadmin","StrongPassword9");
        assertEquals("ERROR", access);

        access = loginController.accessType("a","StrongPassword9");
        assertEquals("ERROR", access);

        access = loginController.accessType("Destro","camomila");
        assertEquals("ERROR", access);

        access = loginController.accessType("Destro","a");
        assertEquals("ERROR", access);

        access = loginController.accessType("a","a");
        assertEquals("Admin", access);
    }
}