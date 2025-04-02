package org.example.Domain;

public class Custos {
    private int id;
    private double ticketCost;
    private int monthlyCost;

    /**
     * create the object
     * @param id (int)
     * @param ticketCost (double)
     * @param monthlyCost (int)
     */
    public Custos(int id, double ticketCost, int monthlyCost) {
        this.id = id;
        this.ticketCost = ticketCost;
        this.monthlyCost = monthlyCost;
    }

    /**
     * return the id
     * @return (int)
     */
    public int getId() {
        return id;
    }

    /**
     * return the costs per ticket
     * @return (double)
     */
    public double getTicketCost() {
        return ticketCost;
    }

    /**
     * return the monthly cost of the attraction
     * @return (int)
     */
    public int getMonthlyCost() {
        return monthlyCost;
    }
}
