package com.example.museum.database.query;

import com.example.museum.Trangchu.BaoTang;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MuseumQuery {
    public static BaoTang FindByName(String name){
        Document docs = new Document(MongoDBQuery.queryOne("hanoi-museum","museums",new Document("name",name)));
        BaoTang baoTang = new BaoTang(docs.getString("name"), docs.getString("address"),
                docs.getString("price"),docs.getString("openings"), docs.getString("topic"), docs.getInteger("pic"));
        return baoTang;
    }

    public static List<BaoTang> FindByTopic(String topic){
        List<Document> docs = new ArrayList<>(MongoDBQuery.find("hanoi-museum","museums",new Document("topic",topic)));
        List<BaoTang> museums = new ArrayList<>();
        for(int i=0;i<docs.size();i++) {
            museums.add(new BaoTang(docs.get(i).getString("name"), docs.get(i).getString("address"),
                    docs.get(i).getString("price"),docs.get(i).getString("openings"),
                    docs.get(i).getString("topic"), docs.get(i).getInteger("pic")));
        }
        return museums;
    }

    public static List<BaoTang> FindByAddress(String address){
        List<Document> Docs = new ArrayList<>(MongoDBQuery.find("hanoi-museum","museums",new Document("address",address)));
        List<BaoTang> museums = new ArrayList<>();
        for(int i=0;i<Docs.size();i++) {
            museums.add(new BaoTang(Docs.get(i).getString("name"), Docs.get(i).getString("address"),
                    Docs.get(i).getString("price"),Docs.get(i).getString("openings"),
                    Docs.get(i).getString("topic"), Docs.get(i).getInteger("pic")));
        }
        return museums;
    }
    public static List<BaoTang> GetAllMuseum(){
        List<Document> Docs = new ArrayList<>(MongoDBQuery.findAll("hanoi-museum","museums"));
        List<BaoTang> museums = new ArrayList<>();
        for(int i=0;i<Docs.size();i++) {
            museums.add(new BaoTang(Docs.get(i).getString("name"), Docs.get(i).getString("address"),
                    Docs.get(i).getString("price"),Docs.get(i).getString("openings"),
                    Docs.get(i).getString("topic"), Docs.get(i).getInteger("pic")));
        }
        return museums;
    }

}
