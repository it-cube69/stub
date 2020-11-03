package ru.store.domain;

public class Soup extends Product {
    private Integer weight;
    /**
     * 0 - Банное мыло
     * 1 - Косметическое мыло
     */
    private Short type;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer w) {
        this.weight = w;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short t) {
        this.type = t;
    }

    @Override
    public String show() {
        String t = "";
        if (this.type == 0) {
            t = "Банное мыло";
        } else if (this.type == 1) {
            t = "Косметическое мыло";
        }
        return String.format("Тип: %s, Вес: %d, Цена: %.2f", t, this.weight, this.getPrice());
    }
}
