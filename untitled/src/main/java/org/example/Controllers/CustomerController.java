package org.example.Controllers;

import org.example.Domain.Atracoes;
import org.example.Model.AtracoesRepository;
import org.example.Model.VendasRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CustomerController {
    private AtracoesRepository atracoesRepository;
    private VendasRepository vendasRepository;

    /**
     * Create a customer controller with all it needs to work
     * @throws FileNotFoundException
     */
    public CustomerController() throws FileNotFoundException {
        this.atracoesRepository = new AtracoesRepository("src/main/resources/Cesaeland_atracoes.csv");
        this.vendasRepository = new VendasRepository("src/main/resources/Cesaeland_vendas.csv");
    }

    /**
     * func to get the attractions list
     * @return array with all the attractions (ArrayList Atracoes )
     */
    public ArrayList<Atracoes> getAllAtractions(){

        return this.atracoesRepository.getAtracoesList();
    }

    /**
     * func to turn the seconds in a string "m:s"
     * @param secs quantati of seconds (int)
     * @return "m:s" (String)
     */
    public String calcPlayTime(int secs){
        int minutes = secs / 60;
        int sec = secs % 60;

        return minutes + ":" + sec;
    }
}
