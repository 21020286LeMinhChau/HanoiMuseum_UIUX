//package com.example.museum.database.query;
//
//import android.content.res.AssetManager;
//import android.util.Log;
//
//import com.example.museum.database.MongoDBConnection;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import org.bson.Document;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import io.realm.mongodb.RealmResultTask;
//import io.realm.mongodb.mongo.MongoCollection;
//import io.realm.mongodb.mongo.iterable.MongoCursor;
//
//public class JsonQuery {
//    public static Document doc = new Document("email","test");
//    public static List<Document> docs;
//
////    public static boolean isExist(String database, String collection, Document document) {
////        Document result = queryOne(database, collection, document);
////
////        if (result == null) {
////            return false;
////        } else {
////            return true;
////        }
////    }
////    public static Document queryOne(String database, String collection, Document document) {
////        MongoCollection<Document> mongoCollection = MongoDBConnection.accessDatabase(database, collection);
////        return mongoCollection.findOne(document).get();
////    }
////    public static List<Document> find(String database, String collection, Document document) {
////        MongoCollection<Document> mongoCollection = MongoDBConnection.accessDatabase(database, collection);
////        List<Document> res = new ArrayList<>();
////        RealmResultTask<MongoCursor<Document>> findTask = mongoCollection.find(document).iterator();
////        MongoCursor<Document> results = findTask.get();
////        while (results.hasNext())
////        {
////            Document result = results.next();
////            res.add(result);
////        }
////        return res;
////    }
//
//
//    public static List<Map<String, Object>> readJson(String pathToFile) {
//        List<Map<String, Object>> res = new ArrayList<>();
//        try {
////            path: file:///android_asset/DbJ/museums_chude.json
//            JsonReader jsonReader = new JsonReader();
////             public static List<Map<String, Object>> readJson(Context context, String pathToFile)
//            return jsonReader.readJson(pathToFile)
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return res;
//    }
//    public static List<Document> find(String database, String collection, Document document) {
////        read file "file:///android_asset/DbJ/ + database + "/" + collection + ".json"
//        List<Map<String, Object>> res = readJson("file:///android_asset/DbJ/"  + collection + ".json");
//        List<Document> result = new ArrayList<>();
//        for (Map<String, Object> doc : res) {
//            Document document1 = new Document(doc);
////            if document contains the document1
//            if (document1.entrySet().containsAll(document.entrySet())) {
//                result.add(document1);
//            }
//        }
//        return result;
//    }
//
//
//
//    public static List<Document> findAll(String database, String collection) {
//        List<Map<String, Object>> res = readJson("file:///android_asset/DbJ/"  + collection + ".json");
//        System.out.println("xxxxxxxxx" + "file:///android_asset/DbJ/"  + collection + ".json");
//        List<Document> result = new ArrayList<>();
//        for (Map<String, Object> doc : res) {
//            Document document = new Document(doc);
//            result.add(document);
//        }
//        return result;
//    }
//
//
//}
