package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;
import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.util.ProductUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductMgmtApp {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(3128874119L, "Banana", LocalDate.of(2023,01,24), 124,0.55));
        products.add(new Product(2927458265L, "Apple", LocalDate.of(2022,12,9), 18,1.09));
        products.add(new Product(9189927460L, "Carrot", LocalDate.of(2023,03,31), 89,2.99));

        products = ProductUtil.sortProductsByName(products);
        //JSON
        System.out.println("JSON-formatted list of all Products:");
        System.out.println(ProductUtil.byJsonFormat(products));

        //XML
        System.out.println("XML-formatted list of all Products:");
        System.out.println(ProductUtil.byXMLFormat(products));

        //CSV
        System.out.println("Comma-Separated Values (CSV)-formatted list of all Products:");
        System.out.println(ProductUtil.byCSVFormat(products));
    }
}
