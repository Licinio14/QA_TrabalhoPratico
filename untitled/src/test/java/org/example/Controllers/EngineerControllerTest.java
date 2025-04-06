package org.example.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class EngineerControllerTest {

    private EngineerController engineerController;
    private EngineerController engineerControllerControl;

    /**
     * Create a engineer controller with all it needs to work
     * @throws FileNotFoundException
     */
    @BeforeEach
    void setUp() throws FileNotFoundException {
        engineerController = new EngineerController("src/test/resources/Cesaeland_atracoes_engineer.csv","src/test/resources/Cesaeland_vendas.csv");
        engineerControllerControl = new EngineerController("src/test/resources/Cesaeland_atracoes_engineer_control.csv","src/test/resources/Cesaeland_vendas_control.csv");
    }

    /**
     * Test if the function to get the attraction o need maintenance, show the results correctly
     */
    @Test
    void getAttractionsNeedMaintenanceTest() {
        ArrayList<String> test = engineerController.getNextManutenance();

        assertEquals("\u001B[0;93mID: 2\t|\tCasa Assombrada de Projeto Final\t|\tManutenance needed in: 49 tickes!\u001B[0m", test.get(0));
        assertEquals("\u001B[0;93mID: 3\t|\tTrampolins Bases de Dados\t|\tManutenance needed in: 49 tickes!\u001B[0m", test.get(1));
        assertEquals("\u001B[0;93mID: 6\t|\tRio Lento Quality Assurance\t|\tManutenance needed in: 49 tickes!\u001B[0m", test.get(2));

        ArrayList<String> testControl = engineerControllerControl.getNextManutenance();

        assertEquals("\u001B[0;93mID: 5\t|\tCarrossel Web\t|\tManutenance needed in: 33 tickes!\u001B[0m", testControl.get(0));
        assertEquals("\u001B[0;93mID: 9\t|\tTorre da Nuvem\t|\tManutenance needed in: 41 tickes!\u001B[0m", testControl.get(1));
        assertEquals("\u001B[0;93mID: 10\t|\tLabirinto do Trabalho em Equipa\t|\tManutenance needed in: 45 tickes!\u001B[0m", testControl.get(2));
    }

    /**
     * Test if the function to get the attraction o need maintenance, throws the right expedition
     */
    @Test
    void getAtractionsNeedManutenanceNoFileTest() {
        assertThrows(FileNotFoundException.class, () -> {engineerController = new EngineerController("src/test/resources/No_File.csv","src/test/resources/Cesaeland_vendas.csv");});
        assertThrows(FileNotFoundException.class, () -> {engineerController = new EngineerController("src/test/resources/Cesaeland_atracoes.csv","src/test/resources/No_File.csv");});
        assertThrows(FileNotFoundException.class, () -> {engineerController = new EngineerController("src/test/resources/No_File.csv","src/test/resources/No_File.csv");});
    }

    /**
     * Test if the function to get the attraction o need maintenance, throws the right expedition when the file is empty
     */
    @Test
    void getAtractionsNeedManutenanceFileEmpetyTest() {

        assertThrows(NoSuchElementException.class, () -> {engineerController = new EngineerController("src/test/resources/Cesaeland_atracoes_engineer_empety.csv","src/test/resources/Cesaeland_vendas.csv");});
        assertThrows(NoSuchElementException.class, () -> {engineerController = new EngineerController("src/test/resources/Cesaeland_atracoes.csv","src/test/resources/Cesaeland_vendas_empaty.csv");});
        assertThrows(NoSuchElementException.class, () -> {engineerController = new EngineerController("src/test/resources/Cesaeland_atracoes_engineer_empety.csv","src/test/resources/Cesaeland_vendas_empaty.csv");});
    }
}