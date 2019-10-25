package ch.heigvd.amt.projectone.model;

public class Product {

    private int id;
    private String name;
    private int unitPrice;


    public Product(int id, String name, int unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

}
