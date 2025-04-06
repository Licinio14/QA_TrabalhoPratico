package org.example.Controllers;

import org.example.Model.VendasRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {

    AdminController adminController = new AdminController("src/test/resources/Cesaeland_logins_Test.csv");
    LoginController loginController = new LoginController("src/test/resources/Cesaeland_logins_Test.csv");

    AdminControllerTest() throws FileNotFoundException {
    }

    @Test
    public void stringHaveSpacesTest(){
        assertTrue(adminController.stringHaveSpaces("Tem espaços"));
        assertTrue(adminController.stringHaveSpaces("Mas isto tambem tem espaços"));
    }

    @Test
    public void stringNotHaveSpacesTest(){
        assertFalse(adminController.stringHaveSpaces("NaoTemEspaços"));
        assertFalse(adminController.stringHaveSpaces("MasIstoTambemNaoTemEspaços"));
    }

    @Test
    void createNewUserTest() throws FileNotFoundException {

        assertTrue(adminController.creatNewUser(1,"a","a"));

        assertEquals("ADMIN", loginController.accessType("a","a"));

        assertTrue(adminController.creatNewUser(2,"e","e"));

        assertEquals("ENG", loginController.accessType("e","e"));

    }

    @Test
    void createNewUserFailTypeTest() throws FileNotFoundException {

        assertFalse(adminController.creatNewUser(4,"aa","aa"));

        assertEquals("ERROR", loginController.accessType("aa","aa"));

        assertFalse(adminController.creatNewUser(0,"ee","ee"));

        assertEquals("ERROR", loginController.accessType("ee","ee"));

        assertFalse(adminController.creatNewUser(-5,"nn","nn"));

        assertEquals("ERROR", loginController.accessType("nn","nn"));

    }

    @Test
    void createNewUserEmpetyStringsTest() throws FileNotFoundException {

        assertFalse(adminController.creatNewUser(1,"","aa"));

        assertEquals("ERROR", loginController.accessType("","aa"));

        assertFalse(adminController.creatNewUser(1,"ee",""));

        assertEquals("ERROR", loginController.accessType("ee",""));

        assertFalse(adminController.creatNewUser(1,"",""));

        assertEquals("ERROR", loginController.accessType("",""));

    }



    @AfterAll
    static void tearDown() throws FileNotFoundException {

        String loginFileText = "ADMIN,root,root";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/test/resources/Cesaeland_logins_Test.csv", false));
            bw.write(loginFileText);
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}