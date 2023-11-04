package com.example.museum.database.insert;

import android.util.Log;


import com.example.museum.database.MongoDBConnection;

import org.bson.Document;


import java.util.List;



import io.realm.mongodb.mongo.MongoCollection;


public class MongoDBInsert {
    public static void insertOne(String database, String collection, Document document) {
        MongoCollection<Document> mongoCollection = MongoDBConnection.accessDatabase(database, collection);

        mongoCollection.insertOne(document)
                .getAsync(result -> {
                    if (result.isSuccess()) {
                        Log.v("Data", "Data Inserted Successfully");
                    } else {
                        Log.v("Data", "Error:" + result.getError().toString());
                    }
                });

    }

    public static void insertMany(String database, String collection, List<Document> document) {
        MongoCollection<Document> mongoCollection = MongoDBConnection.accessDatabase(database, collection);

        mongoCollection.insertMany(document)
                .getAsync(result -> {
                    if(result.isSuccess())
                    {
                        Log.v("Data","Data Inserted Successfully");
                    }
                    else
                    {
                        Log.v("Data","Error:"+result.getError().toString());
                    }
                });
    }
}