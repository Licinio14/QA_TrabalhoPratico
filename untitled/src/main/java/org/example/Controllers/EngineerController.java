package org.example.Controllers;

import org.example.Domain.Atracoes;
import org.example.Domain.Vendas;
import org.example.Model.AtracoesRepository;
import org.example.Model.VendasRepository;
import org.example.Tools.Colors;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EngineerController {
    private AtracoesRepository atracoesRepository;
    private VendasRepository vendasRepository;

    /**
     * Create a engineer controller with all it needs to work
     * @throws FileNotFoundException
     */
    public EngineerController() throws FileNotFoundException {
        this.atracoesRepository = new AtracoesRepository("src/main/resources/Cesaeland_atracoes.csv");
        this.vendasRepository = new VendasRepository("src/main/resources/Cesaeland_vendas.csv");
    }

    /**
     * func to discover what are the next 3 attraction that need manutenance
     * @return
     */
    public ArrayList<String> getNextManutenance(){
        ArrayList<String> finalResults = new ArrayList<>();
        int maxAttractions = this.atracoesRepository.getAtracoesList().size() + 1;

        // created a temp array to not afet the main one
        ArrayList<Atracoes> tempList = new ArrayList<Atracoes>();

        // copy the main to the temp array
        tempList.addAll(this.atracoesRepository.getAtracoesList());

        // created int array to keep the last sold tickets in the same order the attractions id (0 stay empty)
        int[] attManutenance = new int[maxAttractions];

        // created a temp array to be able to sort the array and have the main one to know the attraction id, integer to be able to sort reverse
        Integer[] tempArray = new Integer[maxAttractions];

        // get the total os tickets sold
        for (Vendas sale : this.vendasRepository.getVendasList()) {
            attManutenance[sale.getId()] = attManutenance[sale.getId()] + 1;
        }

        // get the number of tickets sold since last manutenance
        for (int i = 0; i < maxAttractions; i++) {
            attManutenance[i] = attManutenance[i] % 50;
            tempArray[i] = attManutenance[i] % 50;
        }

        //sort the temp array in reverse order
        Arrays.sort(tempArray, Collections.reverseOrder());

        //to show only 3
        for (int i = 0; i < 3; i++) {
            //to search for the first in the array
            for (int j = 0; j < attManutenance.length; j++) {
                if (attManutenance[j] == tempArray[i]) {
                    //to search the attraction with the same id
                    for (Atracoes att : tempList) {
                        if (att.getId() == j) {
                            //add the final string to the array to return
                            finalResults.add(Colors.YELLOW_BRIGHT + "ID: " + att.getId() + "\t|\t" + att.getName() + "\t|\tManutenance needed in: " + (50 - attManutenance[j]) + " tickes!" + Colors.RESET);
                            //delet from the temp array so it nop appear duplicated
                            tempList.remove(att);
                            //stop the search
                            break;
                        }
                    }
                }
            }
        }

        return finalResults;
    }
}
