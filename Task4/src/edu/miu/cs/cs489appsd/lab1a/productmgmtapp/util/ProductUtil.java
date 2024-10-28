package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.util;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductUtil {
    public static List<Product> sortProductsByName(List<Product> products) {
        return products.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }
    public static String byJsonFormat(List<Product> products){
        return products.stream()
                        .map(x->String.format("  {\n    \"id\": \"%s\",\n    \"name\": \"%s\",\n    \"dateSupplied\": \"%s\",\n    \"quantityInStock\": %d,\n    \"unitPrice\": %.2f\n  }",
                                x.getProductId(),
                                x.getName(),
                                x.getDateSupplied(),
                                x.getQuantityInStock(),
                                x.getUnitPrice()))
                        .collect(Collectors.joining(",\n", "[\n", "\n]"));
    }
    public static String byXMLFormat(List<Product> products){
        return products.stream()
                .map(x->String.format("  <product>\n    <id>%s</id>\n    <name>%s</name>\n    <dateSupplied>%s</dateSupplied>\n    <quantityInStock>%d</quantityInStock>\n    <unitPrice>%.2f</unitPrice>\n  </product>",
                        x.getProductId(),
                        x.getName(),
                        x.getDateSupplied(),
                        x.getQuantityInStock(),
                        x.getUnitPrice()))
                .collect(Collectors.joining("\n", "<products>\n", "\n</products>"));
    }

    public static String byCSVFormat(List<Product> products){
        String csvHeader = "Id,Name,DateSupplied,QuantityInStock,UnitPrice";
        String csvOutput = products.stream().map(x -> String.format("%s,%s,%s,%d,%.2f",
                        x.getProductId(),
                        x.getName(),
                        x.getDateSupplied(),
                        x.getQuantityInStock(),
                        x.getUnitPrice()))
                .collect(Collectors.joining("\n", csvHeader + "\n", ""));
        return csvHeader+csvOutput;
    }

}
