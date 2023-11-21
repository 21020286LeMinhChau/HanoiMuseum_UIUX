package com.example.museum.database.query;

import com.example.museum.Khampha.Thamquan.HienVat;
import com.example.museum.Trangchu.BaoTang;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ObjectQuery {
    public static HienVat FindByName(String name){
        Document docs = new Document(MongoDBQuery.queryOne("hanoi-museum","objects",new Document("name",name)));
        HienVat hienvat = new HienVat(docs.getString("name"),docs.getString("timing"), docs.getString("info"),docs.getString("topic"),docs.getString("audioSource"), docs.getInteger("pic") );
        return hienvat;
    }

    public static HienVat FindByID(String id){
        Document docs = new Document(MongoDBQuery.queryOne("hanoi-museum","objects",new Document("_id",id)));
        HienVat hienvat = new HienVat(docs.getString("name"),docs.getString("timing"), docs.getString("info"),docs.getString("topic"),docs.getString("audioSource"),  docs.getInteger("pic"));
        return hienvat;
    }

    public static List<HienVat> FindByTopic(String topic){
        List<Document> docs = new ArrayList<>(MongoDBQuery.find("hanoi-museum","objects",new Document("topic",topic)));
        List<HienVat> hienVats = new ArrayList<>();
        for(int i=0;i<docs.size();i++) {
            hienVats.add(new HienVat(docs.get(i).getString("name"),docs.get(i).getString("timing"), docs.get(i).getString("info"),docs.get(i).getString("topic"),docs.get(i).getString("audioSource") , docs.get(i).getInteger("pic")));
        }
        return hienVats;
    }
}
