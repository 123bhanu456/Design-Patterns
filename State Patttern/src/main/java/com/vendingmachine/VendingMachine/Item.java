package com.vendingmachine.VendingMachine;

import org.bson.Document;

public class Item {
    private String name;
    private int price;
    private int count;

    public Item(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Document toDocument() {
        return new Document("name", name)
                .append("price", price)
                .append("count", count);
    }

    public static Item fromDocument(Document doc) {
        return new Item(doc.getString("name"), doc.getInteger("price"), doc.getInteger("count"));
    }
}
