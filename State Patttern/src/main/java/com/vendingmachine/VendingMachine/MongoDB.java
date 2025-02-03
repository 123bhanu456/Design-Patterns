package com.vendingmachine.VendingMachine;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.mongodb.client.*;
import org.bson.Document;
import java.util.*;

public class MongoDB {
    private static final String DATABASE_NAME = "VendingMachineDB";
    private static final String COLLECTION_NAME = "items";
    private static final String BALANCE_COLLECTION = "balance";
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public MongoDB() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        String mongoUri = properties.getProperty("MONGO_URI");
        mongoClient = MongoClients.create(mongoUri);
        database = mongoClient.getDatabase(DATABASE_NAME);
        collection = database.getCollection(COLLECTION_NAME);
    }

    public Map<String, Item> loadItems() {
        Map<String, Item> items = new HashMap<>();
        FindIterable<Document> docs = collection.find();
        for (Document doc : docs) {
            Item item = Item.fromDocument(doc);
            items.put(item.getName(), item);
        }
        return items;
    }

    public void updateItemCount(String itemName, int newCount) {
        collection.updateOne(new Document("name", itemName),
                new Document("$set", new Document("count", newCount)));
    }

    public int getMachineBalance() {
        Document doc = database.getCollection(BALANCE_COLLECTION).find().first();
        return doc != null ? doc.getInteger("total_balance") : 0;
    }

    public void updateMachineBalance(int newBalance) {
        database.getCollection(BALANCE_COLLECTION)
                .updateOne(new Document(), new Document("$set", new Document("total_balance", newBalance)));
    }
}
