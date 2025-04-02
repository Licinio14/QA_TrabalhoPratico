package org.example.Domain;

public class User {
    private String acontType;
    private String userName;
    private String passWord;

    /**
     * create the object
     * @param acontType (string)
     * @param userName (string)
     * @param passWord (string)
     */
    public User(String acontType, String userName, String passWord) {
        this.acontType = acontType;
        this.userName = userName;
        this.passWord = passWord;
    }

    /**
     * return the account type
     * @return (string)
     */
    public String getAcontType() {
        return acontType;
    }

    /**
     * return the username
     * @return (string)
     */
    public String getUserName() {
        return userName;
    }

    /**
     * return the password
     * @return (string)
     */
    public String getPassWord() {
        return passWord;
    }
}
