package ch.heigvd.amt.projectone.model;

public class Product {

    private int id;
    private String name;
    private double unitPrice;


    public Product(int id, String name, double unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public double getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

}
