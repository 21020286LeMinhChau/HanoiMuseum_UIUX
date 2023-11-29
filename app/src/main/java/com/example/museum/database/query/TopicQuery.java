package com.example.museum.database.query;

import com.example.museum.Trangchu.ChuDe;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class TopicQuery {
    public static List<ChuDe> getTopics(){
        List<Document> docs = new ArrayList<>(MongoDBQuery.findAll("hanoi-museum","museums_chude"));
        List<ChuDe> topics = new ArrayList<>();
        for(int i=0;i<topics.size();i++) {
            topics.add(new ChuDe(docs.get(i).getString("name"),docs.get(i).getInteger("picture")));
        }
        return topics;
    }
}
