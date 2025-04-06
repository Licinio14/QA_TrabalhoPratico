package org.example.Controllers;

import org.example.Domain.Atracoes;
import org.example.Model.AtracoesRepository;
import org.example.Model.VendasRepository;
import org.example.Tools.Colors;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CustomerController {
    private AtracoesRepository atracoesRepository;
    private VendasRepository vendasRepository;

    /**
     * Create a customer controller with all it needs to work
     * @throws FileNotFoundException
     */
    public CustomerController(String pathToAtracoes, String pathToVendas) throws FileNotFoundException {
        this.atracoesRepository = new AtracoesRepository(pathToAtracoes);
        this.vendasRepository = new VendasRepository(pathToVendas);
    }

    /**
     * func to get the attractions list
     * @return array with all the attractions (ArrayList Atracoes )
     */
    public ArrayList<String> getAllAtractions(){
        ArrayList<Atracoes> allAtractions = new ArrayList<>();
        ArrayList<String> allAtractionsString = new ArrayList<>();
        allAtractions = this.atracoesRepository.getAtracoesList();
        
        for (Atracoes atracoes : allAtractions){
            allAtractionsString.add(Colors.BLUE + atracoes.getId() + ": " + atracoes.getName()+ "\t|\tTickets Adults: " + atracoes.getPriceAdult() + "€ Children: " + atracoes.getPriceChild() + "€\t|\tPLaytime: " + this.calcPlayTime(atracoes.getSeconds()) + Colors.RESET);
        }


        
        return allAtractionsString;
    }

    /**
     * func to turn the seconds in a string "m:s"
     * @param secs quantati of seconds (int)
     * @return "m:s" (String)
     */
    public String calcPlayTime(int secs){

        if (secs < 0){
            return "ERROR - Negative seconds not allowed";
        }

        int minutes = secs / 60;
        int sec = secs % 60;

        return minutes + ":" + sec;
    }
}
