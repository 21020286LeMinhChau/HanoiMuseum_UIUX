package com.example.museum.database.query;

import android.util.Log;

import com.example.museum.database.MongoDBConnection;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import io.realm.mongodb.RealmResultTask;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.iterable.MongoCursor;

public class MongoDBQuery {
    public static Document doc = new Document("email", "test");
    public static List<Document> docs;

    public static boolean isExist(String database, String collection, Document document) {
        Document result = queryOne(database, collection, document);

        if (result == null) {
            return false;
        } else {
            return true;
        }
    }

    public static Document queryOne(String database, String collection, Document document) {
        MongoCollection<Document> mongoCollection = MongoDBConnection.accessDatabase(database, collection);
        return mongoCollection.findOne(document).get();
    }

    public static List<Document> find(String database, String collection, Document document) {
        MongoCollection<Document> mongoCollection = MongoDBConnection.accessDatabase(database, collection);
        List<Document> res = new ArrayList<>();
        RealmResultTask<MongoCursor<Document>> findTask = mongoCollection.find(document).iterator();
        MongoCursor<Document> results = findTask.get();
        while (results.hasNext()) {
            Document result = results.next();
            res.add(result);
        }
        return res;
    }


    public static List<Document> findAll(String database, String collection) {

        MongoCollection<Document> mongoCollection = MongoDBConnection.accessDatabase(database, collection);
        List<Document> res = new ArrayList<>();
        RealmResultTask<MongoCursor<Document>> findTask = mongoCollection.find().iterator();
        MongoCursor<Document> results = findTask.get();

        while (results.hasNext()) {
            Document result = results.next();
            res.add(result);
        }
        return res;
    }


}
