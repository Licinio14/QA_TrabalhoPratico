package org.example.Views;

import org.example.Controllers.AdminController;
import org.example.Tools.Colors;
import org.example.Tools.InputTools;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminView {
    AdminController adminController;

    /**
     * create the admin view with all it needs to work
     * @throws FileNotFoundException
     */
    public AdminView() throws FileNotFoundException {
        adminController = new AdminController();
    }

    /**
     * View with the menu
     * @throws InterruptedException
     */
    public void adminMenu() throws InterruptedException {
        Scanner input = new Scanner(System.in);

        int menuOption;

        do {
            System.out.println("Hello Dear Admin. Nice to see you.");
            System.out.println(Colors.RED + "1. Total sales" + Colors.RESET);
            System.out.println(Colors.RED + "2. Total profit" + Colors.RESET);
            System.out.println(Colors.RED + "3. Total sales and profit per month" + Colors.RESET);
            System.out.println(Colors.RED + "4. Most popular attraction for adults" + Colors.RESET);
            System.out.println(Colors.RED + "5. Most popular attraction for children" + Colors.RESET);
            System.out.println(Colors.RED + "6. Most popular attraction" + Colors.RESET);
            System.out.println(Colors.RED + "7. Most profitable attraction" + Colors.RESET);
            System.out.println(Colors.RED + "8. Least profitable attraction" + Colors.RESET);
            System.out.println(Colors.RED + "9. Attraction with best price/time" + Colors.RESET);
            System.out.println(Colors.GREEN + "10. Create new user" + Colors.RESET);
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            menuOption = InputTools.getInputInt();

            switch (menuOption){
                case 1:
                    Colors.Clear();
                    System.out.println(Colors.YELLOW_BOLD + "Under maintenance\n" + Colors.RESET);
                    break;
                case 2:
                    Colors.Clear();
                    System.out.println(Colors.YELLOW_BOLD + "Under maintenance\n" + Colors.RESET);
                    break;
                case 3:
                    Colors.Clear();
                    System.out.println(Colors.YELLOW_BOLD + "Under maintenance\n" + Colors.RESET);
                    break;
                case 4:
                    Colors.Clear();
                    System.out.println(Colors.YELLOW_BOLD + "Under maintenance\n" + Colors.RESET);
                    break;
                case 5:
                    Colors.Clear();
                    System.out.println(Colors.YELLOW_BOLD + "Under maintenance\n" + Colors.RESET);
                    break;
                case 6:
                    Colors.Clear();
                    System.out.println(Colors.YELLOW_BOLD + "Under maintenance\n" + Colors.RESET);
                    break;
                case 7:
                    Colors.Clear();
                    System.out.println(Colors.YELLOW_BOLD + "Under maintenance\n" + Colors.RESET);
                    break;
                case 8:
                    Colors.Clear();
                    System.out.println(Colors.YELLOW_BOLD + "Under maintenance\n" + Colors.RESET);
                    break;
                case 9:
                    Colors.Clear();
                    System.out.println(Colors.YELLOW_BOLD + "Under maintenance\n" + Colors.RESET);
                    break;
                case 10:
                    Colors.Clear();
                    int type = 0;
                    boolean loop = true;
                    String username,password;

                    System.out.println(Colors.BLUE + "********* Creat new user *********\n" + Colors.RESET);

                    System.out.println(Colors.BLUE + "\nUser type: |1-Admin|\t|2-Engineer|" + Colors.RESET);

                    do {
                        System.out.print("✒️ ");
                        type = InputTools.getInputInt();

                        if (type != 1 && type != 2){
                            System.out.println(Colors.RED + "\nInvalid option!\n" + Colors.RESET);
                        }
                    }while (type != 1 && type != 2);

                    System.out.println(Colors.BLUE + "\nUser name, no spaces!" + Colors.RESET);

                    do {
                        System.out.print("✒️ ");
                        username = InputTools.getInputString();

                        loop = adminController.stringHaveSpaces(username);

                        if (loop){
                            System.out.println(Colors.RED + "\nNo spaces!\n" + Colors.RESET);
                        }

                    }while (loop);

                    System.out.println(Colors.BLUE + "\nPassword, no spaces!" + Colors.RESET);

                    do {
                        System.out.print("✒️ ");
                        password = InputTools.getInputString();

                        loop = adminController.stringHaveSpaces(password);

                        if (loop){
                            System.out.println(Colors.RED + "\nNo spaces!\n" + Colors.RESET);
                        }

                    }while (loop);

                    boolean vali = adminController.creatNewUser(type,username,password);

                    if (vali){
                        Colors.Clear();
                        System.out.println(Colors.GREEN + "Create new user successfully!\n" + Colors.RESET);
                    }else {
                        Colors.Clear();
                        System.out.println(Colors.RED + "Create new user failed!\n" + Colors.RESET);
                    }

                    break;
                case 0:
                    Colors.Clear();
                    break;
                default: // invalid option
                    System.out.println("Invalid option!");
                    break;
            }
        }while (menuOption != 0);
    }
}
