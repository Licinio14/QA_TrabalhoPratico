package org.example.Views;

import org.example.Controllers.CustomerController;
import org.example.Domain.Atracoes;
import org.example.Tools.Colors;
import org.example.Tools.InputTools;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CustomerView {
    private CustomerController customerController;

    /**
     * create the customer view with all it needs to work
     * @throws FileNotFoundException
     */
    public CustomerView() throws FileNotFoundException {
        this.customerController = new CustomerController();
    }

    /**
     * view with the menu
     */
    public void customerMenu(){
        int customerOption;

        do {

            System.out.println("Welcome to CesaeLand©");
            System.out.println(Colors.GREEN +  "1. Available attractions" + Colors.RESET);
            System.out.println(Colors.RED + "2. Favorite attractions" + Colors.RESET);
            System.out.println("0. Exit");
            System.out.print("Choose:");

            customerOption = InputTools.getInputInt();

            switch (customerOption){
                case 1:
                    Colors.Clear();
                    ArrayList<Atracoes> attList = customerController.getAllAtractions();
                    System.out.println(Colors.GREEN + "********** Attractions List **********\n" + Colors.RESET);
                    for (Atracoes selectedAt : attList){
                        System.out.println(Colors.BLUE + selectedAt.getId() + ": " + selectedAt.getName()+ "\t|\tTickets Adults: " + selectedAt.getPriceAdult() + "€ Children: " + selectedAt.getPriceChild() + "€\t|\tPLaytime: " + customerController.calcPlayTime(selectedAt.getSeconds()) + Colors.RESET);
                    }
                    System.out.println();
                    break;
                case 2:
                    Colors.Clear();
                    System.out.println(Colors.YELLOW_BOLD + "Under maintenance\n" + Colors.RESET);
                    break;
                case 0:
                    Colors.Clear();
                    break;
                default:
                    Colors.Clear();
                    System.out.println(Colors.RED +  "Invalid option!\n" + Colors.RESET);
                    break;
            }
        }while (customerOption != 0);
    }
}
