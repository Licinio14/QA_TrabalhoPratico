package org.example.Domain;

public class Atracoes {
    private int id;
    private String name;
    private double priceAdult;
    private double priceChild;
    private int seconds;

    /**
     * create the object
     * @param id (int)
     * @param name (string)
     * @param priceAdult (double)
     * @param priceChild (double)
     * @param seconds play time in seconds (int)
     */
    public Atracoes(int id, String name, double priceAdult, double priceChild, int seconds) {
        this.id = id;
        this.name = name;
        this.priceAdult = priceAdult;
        this.priceChild = priceChild;
        this.seconds = seconds;
    }

    /**
     * return the id
     * @return (int)
     */
    public int getId() {
        return id;
    }

    /**
     * return the name
     * @return (string)
     */
    public String getName() {
        return name;
    }

    /**
     * return the price of the adult ticket
     * @return (double)
     */
    public double getPriceAdult() {
        return priceAdult;
    }

    /**
     * return the price of the child ticket
     * @return (double)
     */
    public double getPriceChild() {
        return priceChild;
    }

    /**
     * return the play time of the attraction in seconds
     * @return (int)
     */
    public int getSeconds() {
        return seconds;
    }
}
