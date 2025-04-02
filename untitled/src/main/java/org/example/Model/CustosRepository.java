package org.example.Model;

import org.example.Domain.Custos;
import org.example.Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CustosRepository {
    private ArrayList<Custos> CustosList;

    /**
     * create the costs repository
     * @throws FileNotFoundException
     */
    public CustosRepository(String filePath) throws FileNotFoundException {
        this.CustosList = CSVReader.readCustosFileToArray(filePath);
    }

    /**
     * return all the costs per attraction
     * @return (ArrayList Custos)
     */
    public ArrayList<Custos> getCustosList() {
        return CustosList;
    }
}
