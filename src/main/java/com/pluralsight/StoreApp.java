package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f", p.getId(), p.getName(), p.getPrice());
            System.out.println();
        }

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                Product product = new Product(id, name, price);
                inventory.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;

    }
}
