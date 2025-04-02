package org.example.Main;

import org.example.Views.LoginView;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        //call the login view to initiate the program
        LoginView loginView = new LoginView();
        loginView.loginMenu();
    }
}
