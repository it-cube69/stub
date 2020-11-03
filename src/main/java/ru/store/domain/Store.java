package ru.store.domain;

import java.util.Random;

public class Store {
    public static void main(String[] args) {
        Product[] products = new Product[10];
        for (int i = 0; i < 10; i++) {
            Soup soup = new Soup();
            Short type = Integer.valueOf(i % 2).shortValue();
            soup.setType(type);
            Integer weight = new Random().nextInt(300);
            Double price = new Random().nextDouble() * 500;
            soup.setWeight(weight);
            soup.setPrice(price);

            products[i] = soup;
        }

        for (Product p : products) {
            System.out.println(p.show());
        }
    }
}
