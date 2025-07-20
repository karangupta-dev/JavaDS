package ProgrammingProblems.Streams;

import ProgrammingProblems.Streams.Bean.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListProducts {

    static List<Product> products = new ArrayList<>();

    private static void createMockData() {
        products.add(new Product("Laptop", 1200.0, 4.5f));
        products.add(new Product("Phone", 799.0, 4.3f));
        products.add(new Product("Tablet", 499.0, 4.1f));
        products.add(new Product("Monitor", 250.0, 4.2f));
        products.add(new Product("Keyboard", 49.99, 4.6f));
        products.add(new Product("Mouse", 29.99, 4.4f));
        products.add(new Product("Printer", 159.0, 3.9f));
        products.add(new Product("Smartwatch", 199.99, 4.0f));
        products.add(new Product("Webcam", 89.99, 4.1f));
        products.add(new Product("Headphones", 129.0, 4.7f));
        products.add(new Product("Speaker", 99.0, 4.3f));
        products.add(new Product("Charger", 19.99, 4.0f));
        products.add(new Product("USB Drive", 15.0, 4.5f));
        products.add(new Product("External HDD", 89.0, 4.1f));
        products.add(new Product("SSD", 139.0, 4.6f));
        products.add(new Product("Camera", 649.0, 4.2f));
        products.add(new Product("Drone", 999.0, 4.3f));
        products.add(new Product("Tripod", 59.0, 4.1f));
        products.add(new Product("Projector", 399.0, 3.8f));
        products.add(new Product("Game Console", 499.0, 4.7f));
    }

    private static void sortProducts() {
        DecimalFormat df = new DecimalFormat("0.##");

        products.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).toList().forEach(product -> {
            System.out.println(product.getName() + "- $" + df.format(product.getPrice()));
        });
    }

    public static void main(String[] args) {
        createMockData();
        sortProducts();
    }
}
