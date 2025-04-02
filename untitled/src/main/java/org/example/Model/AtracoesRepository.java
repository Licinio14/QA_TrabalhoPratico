package org.example.Model;

import org.example.Domain.Atracoes;
import org.example.Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AtracoesRepository {
    private ArrayList<Atracoes> atracoesList;

    /**
     * create the attractions repository
     * @throws FileNotFoundException
     */
    public AtracoesRepository(String filePath) throws FileNotFoundException {
        this.atracoesList = CSVReader.readAtracoesFileToArray(filePath);
    }

    /**
     * return all attractions
     * @return (ArrayList Atracoes )
     */
    public ArrayList<Atracoes> getAtracoesList() {
        return atracoesList;
    }
}
