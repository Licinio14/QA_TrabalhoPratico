package org.example.Controllers;

import org.example.Domain.User;
import org.example.Model.UserRepository;

import java.io.FileNotFoundException;

public class LoginController {

    private UserRepository userRepository;

    /**
     * Create a login controller with all it needs to work
     * @throws FileNotFoundException
     */
    public LoginController(String pathLogin) throws FileNotFoundException {
        userRepository = new UserRepository(pathLogin);
    }

    /**
     * Verify if the user exist and return the type
     * @param usernameInput (string)
     * @param passwordInput (string)
     * @return type of user if exist or "ERROR" if don't exist
     */
    public String accessType(String usernameInput, String passwordInput) throws FileNotFoundException {
        String accessType = "ERROR";

        //apdate with new repository
        this.userRepository = new UserRepository("src/main/resources/Cesaeland_logins.csv");

        //search for the same user and password
        for (User currentUser: this.userRepository.getUserList()){
            if (currentUser.getUserName().equals(usernameInput) && currentUser.getPassWord().equals(passwordInput)){
                // valid access
                accessType = currentUser.getAcontType();
            }
        }

        return accessType;
    }
}
