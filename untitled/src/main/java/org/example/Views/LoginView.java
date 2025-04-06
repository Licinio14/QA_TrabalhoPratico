package org.example.Views;

import org.example.Controllers.LoginController;
import org.example.Tools.Colors;
import org.example.Tools.InputTools;

import java.io.FileNotFoundException;

public class LoginView {
    LoginController loginController;

    /**
     * create the login view with all it needs to work
     * @throws FileNotFoundException
     */
    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController("src/main/resources/Cesaeland_logins.csv");
    }

    /**
     * view with tne menu
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    public void loginMenu() throws FileNotFoundException, InterruptedException {
        int loginOption;

        do {

            System.out.println("Welcome to CesaeLand©");
            System.out.println("1. Customer");
            System.out.println("2. Staff Member");
            System.out.println("0. Exit");
            System.out.print("Choose:");

            loginOption = InputTools.getInputInt();

            switch (loginOption){
                case 1: // Customer
                    Colors.Clear();
                    CustomerView customerView = new CustomerView();
                    customerView.customerMenu();
                    break;
                case 2: // staff Member
                    Colors.Clear();

                    System.out.println("\nLogin with your cradentials");
                    System.out.print("Username: ");
                    String usernameInput = InputTools.getInputString();

                    System.out.print("Password: ");
                    String passwordInput = InputTools.getInputString();

                    validateLogin(usernameInput,passwordInput);

                    break;
                case 0:

                    break;
                default: // invalid option
                    Colors.Clear();
                    System.out.println(Colors.RED +  "Invalid option!\n" + Colors.RESET);
                    break;
            }
        }while (loginOption != 0);
    }

    /**
     * func to validate the user and send him to the correct menu
     * @param usernameInput (string)
     * @param passwordInput (string)
     * @throws InterruptedException
     * @throws FileNotFoundException
     */
    private void validateLogin(String usernameInput, String passwordInput) throws InterruptedException, FileNotFoundException {
        String access = loginController.accessType(usernameInput,passwordInput);

        switch (access){
            case "ADMIN":
                Colors.Clear();
                AdminView adminView = new AdminView();
                adminView.adminMenu();
                System.out.println("Admin logged in");
                break;
            case  "ENG":
                Colors.Clear();
                EngineerView engineerView = new EngineerView();
                engineerView.engineerMenu();
                break;
            case  "ERROR":
                Colors.Clear();
                System.out.println(Colors.RED +  "Invalid Credentials" + Colors.RESET);
                break;
        }
    }
}
