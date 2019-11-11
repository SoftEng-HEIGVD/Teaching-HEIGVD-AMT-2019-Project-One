package ch.heigvd.amt.projectone;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Product {

    private int id;
    private String name;
    private double unitPrice;
    private String description;

    public Product(int id, String name, double unitPrice, String description) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.description = description;
    }
}
