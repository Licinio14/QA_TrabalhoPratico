package org.example.Views;

import org.example.Controllers.EngineerController;
import org.example.Tools.Colors;
import org.example.Tools.InputTools;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class EngineerView {
    private EngineerController engineerController;

    /**
     * create the engineer view with all it needs to work
     * @throws FileNotFoundException
     */
    public EngineerView() throws FileNotFoundException {
        this.engineerController = new EngineerController();
    }

    /**
     * view with the menu
     */
    public void engineerMenu(){
        int EngineerOption;

        do {

            System.out.println("Welcome engineer, have a nice day!");
            System.out.println(Colors.GREEN + "1. Upcoming maintenance" + Colors.RESET);
            System.out.println(Colors.RED + "2. Maintenance history" + Colors.RESET);
            System.out.println("0. Exit");
            System.out.print("Choose:");

            EngineerOption = InputTools.getInputInt();

            switch (EngineerOption){
                case 1:
                    Colors.Clear();
                    ArrayList<String> list = engineerController.getNextManutenance();
                    for (String output : list){
                        System.out.println(output);
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
        }while (EngineerOption != 0);
    }
}
