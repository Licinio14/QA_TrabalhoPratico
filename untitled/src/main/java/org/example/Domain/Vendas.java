package org.example.Domain;

public class Vendas {
    private int id;
    private String date;
    private String Type;

    /**
     * create the object
     * @param id (int)
     * @param date "mm/yyyy" (string)
     * @param type adulto or crianca (string)
     */
    public Vendas(int id, String date, String type) {
        this.id = id;
        this.date = date;
        Type = type;
    }

    /**
     * return the id
     * @return (int)
     */
    public int getId() {
        return id;
    }

    /**
     * return the date of the sale
     * @return "mm/yyyy" (string)
     */
    public String getDate() {
        return date;
    }

    /**
     * return the type of the ticket
     * @return adulto or crianca (string)
     */
    public String getType() {
        return Type;
    }
}
