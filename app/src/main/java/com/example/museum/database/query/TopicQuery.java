package com.example.museum.database.query;

import com.example.museum.Trangchu.ChuDe;
import com.google.api.client.json.Json;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class TopicQuery {
    public static ChuDe[] allTopics;

    public static void getAllTopics_StartProgram() {
        List<Document> Docs = new ArrayList<>(MongoDBQuery.findAll("hanoi-museum","museums_chude"));
        allTopics = new ChuDe[Docs.size()];
        for (int i = 0; i < Docs.size(); i++) {
            allTopics[i] = new ChuDe(Docs.get(i).getString("name"), Docs.get(i).getString("picture"));
        }
    }




    public static List<ChuDe> getTopics() {
//        List<Document> docs = new ArrayList<>(MongoDBQuery.findAll("hanoi-museum","museums_chude"));
////        List<Document> docs = new ArrayList<>(JsonQuery.findAll("hanoi-museum", "museums_chude"));
////        System.out.println("xxxxxxxxx" + docs.size());
//        List<ChuDe> topics = new ArrayList<>();
//        for (int i = 0; i < docs.size(); i++) {
//            topics.add(new ChuDe(docs.get(i).getString("name"), docs.get(i).getString("picture")));
//        }

        List<ChuDe> topics = new ArrayList<>();
        for (int i = 0; i < allTopics.length; i++) {
            topics.add(allTopics[i]);
        }

        return topics;
    }
}
