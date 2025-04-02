package org.example.Tools;

import java.util.Scanner;

public class InputTools {

    /**
     * Func to ask and validate if the user insert a number
     * @return the number the user inserted
     */
    public static int getInputInt(){
        int number = 0;

        //to obligate the user to use only numbers
        do{
            try {
                Scanner in = new Scanner(System.in);
                number = in.nextInt();
                break;
            } catch (Exception e) {
                System.out.println(Colors.RED + "Numbers only!" + Colors.RESET);
            }
        }while(true);

        return number;
    }

    /**
     * Func to ask a string to the user
     * @return the string the user inserted
     */
    public static String getInputString(){
        String text = "";

        //just in case the user found a way of break the scanner
        do{
            try {
                Scanner in = new Scanner(System.in);
                text = in.nextLine();
                break;
            } catch (Exception e) {
                System.out.println(Colors.RED + "Letters and numbers only!" + Colors.RESET);
            }
        }while(true);

        return text;
    }
}
