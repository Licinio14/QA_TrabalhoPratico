package org.example.Controllers;

import org.example.Model.VendasRepository;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AdminController {

    private VendasRepository vendasRepository;
    private String pathLogin;

    /**
     * Create admin controller with all it needs to work
     * @throws FileNotFoundException
     */
    public AdminController(String pathLogin) throws FileNotFoundException {
        this.vendasRepository = new VendasRepository("src/main/resources/Cesaeland_vendas.csv");
        this.pathLogin = pathLogin;
    }

    /**
     * FUnc to add a new user to the bd
     * @param type 1-Admin 2-Engineer (int)
     * @param username (string)
     * @param password (string)
     * @return true = success / false = failed
     */
    public boolean creatNewUser(int type, String username, String password){
        String newUser;

        if (username == null || password == null) {
            return false;
        }

        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            return false;
        }

        if (type == 1){
            newUser = "\nADMIN,"+username+","+password;
        }else if (type == 2){
            newUser = "\nENG,"+username+","+password;
        }else {
            return false;
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.pathLogin, true));
            bw.write(newUser);
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return true;

    }

    /**
     * func to verify if the string have spaces
     * @param text string to test (string)
     * @return true = have / false = don't have
     */
    public boolean stringHaveSpaces(String text){
        if(text.contains(" ")){
            return true;
        }else {
            return false;
        }
    }
}
