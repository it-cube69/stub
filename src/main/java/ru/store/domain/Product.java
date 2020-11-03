package ru.store.domain;

abstract public class Product {
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double p) {
        this.price = p;
    }

    abstract public String show();
}
