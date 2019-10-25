package ch.heigvd.amt.projectone.services;

import ch.heigvd.amt.projectone.model.Product;

public class ProductsManager {

    public Product getRandomProduct(){

        return new Product(0,"Club Maté",2);

    }
}
