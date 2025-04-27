package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileManager {
    public static List<Product> readFile() {

        try {
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // skip first line
            bufferedReader.readLine();

            String input;

            List<Product> productList = new ArrayList<>();
            while ((input = bufferedReader.readLine()) != null) {
                String[] row = input.split("\\|");
                // index 0 = sku index 1 = product index 2 = price index 3 = dept
                String sku = row[0];
                String productName = row[1];
                double price = Double.parseDouble(row[2]);
                String dept = row[3];
                Product product = new Product(sku, productName, price, dept);
                productList.add(product);

            }


            bufferedReader.close();

            return productList;

        } catch (IOException ex) {
            System.out.println("Failed to load csv file.");
            ex.printStackTrace();
            return new ArrayList<>();
        }


    }
}







