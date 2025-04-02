package org.example.Model;

import org.example.Domain.Vendas;
import org.example.Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class VendasRepository {
    private ArrayList<Vendas> vendasList;

    /**
     * create the sales repository
     * @throws FileNotFoundException
     */
    public VendasRepository(String filePath) throws FileNotFoundException {
        this.vendasList = CSVReader.readVendasFileToArray(filePath);
    }

    /**
     * return all the sales
     * @return (ArrayList Vendas)
     */
    public ArrayList<Vendas> getVendasList() {
        return vendasList;
    }
}
