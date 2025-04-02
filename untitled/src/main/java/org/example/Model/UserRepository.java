package org.example.Model;

import org.example.Domain.User;
import org.example.Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> userList;

    /**
     * create the users repository
     * @throws FileNotFoundException
     */
    public UserRepository(String filePath) throws FileNotFoundException {
        this.userList = CSVReader.readUserFileToArray(filePath);
    }

    /**
     * return all the users and types
     * @return (ArrayList USer)
     */
    public  ArrayList<User> getUserList(){
        return userList;
    }
}
