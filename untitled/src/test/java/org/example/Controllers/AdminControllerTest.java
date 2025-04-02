package org.example.Controllers;

import org.example.Model.VendasRepository;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {

    AdminController adminController = new AdminController();

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
    public void creatNewUser
}