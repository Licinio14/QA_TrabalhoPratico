package org.example.Controllers;

import org.example.Model.AtracoesRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {

    private CustomerController customerController;
    private CustomerController customerControllerControl;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        customerController = new CustomerController("src/test/resources/Cesaeland_atracoes.csv","src/test/resources/Cesaeland_vendas.csv");
        customerControllerControl = new CustomerController("src/test/resources/Cesaeland_atracoes_control.csv","src/test/resources/Cesaeland_vendas.csv");
    }

    @Test
    void getPLayTimeStringTeste() {

        assertEquals("2:0", customerController.calcPlayTime(120) );
        assertEquals("4:30", customerController.calcPlayTime(270) );

        assertEquals("2:0", customerControllerControl.calcPlayTime(120) );
        assertEquals("4:30", customerControllerControl.calcPlayTime(270) );
    }

    @Test
    void getPLayTimeStringWithNegativeNumbersTeste() {

        assertEquals("ERROR - Negative seconds not allowed", customerController.calcPlayTime(-120) );
        assertEquals("ERROR - Negative seconds not allowed", customerControllerControl.calcPlayTime(-270) );

    }

    @Test
    void getPLayTimeStringWithNumberZeroTeste() {

        assertEquals("0:0", customerController.calcPlayTime(0) );
        assertEquals("0:0", customerControllerControl.calcPlayTime(0) );

    }

    @Test
    void getAllAtracoesTeste(){

        ArrayList<String> testArray = customerController.getAllAtractions();
        String teste = testArray.getFirst();
        ArrayList<String> testArrayControl = customerControllerControl.getAllAtractions();
        String testeControl = testArrayControl.getFirst();

        assertEquals("\u001B[0;34m3: Trampolins Bases de Dados\t|\tTickets Adults: 10.0€ Children: 5.0€\t|\tPLaytime: 10:0\u001B[0m",teste);
        assertEquals("\u001B[0;34m7: Elevador de Servicos\t|\tTickets Adults: 10.0€ Children: 8.0€\t|\tPLaytime: 2:0\u001B[0m",testeControl);
    }

    @Test
    void getAllAtracoesNoFileException(){
        assertThrows(FileNotFoundException.class, () -> {customerController = new CustomerController("src/test/resources/No_File.csv","src/test/resources/Cesaeland_vendas.csv");});
        assertThrows(FileNotFoundException.class, () -> {customerController = new CustomerController("src/test/resources/Cesaeland_atracoes.csv","src/test/resources/No_File.csv");});
        assertThrows(FileNotFoundException.class, () -> {customerController = new CustomerController("src/test/resources/No_File.csv","src/test/resources/No_File.csv");});
    }
}