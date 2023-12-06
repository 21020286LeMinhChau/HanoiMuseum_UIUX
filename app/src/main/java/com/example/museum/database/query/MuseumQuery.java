package com.example.museum.database.query;

import com.example.museum.Trangchu.BaoTang;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MuseumQuery {
//    public static BaoTang findByName(String name){
//        Document docs = new Document(MongoDBQuery.queryOne("hanoi-museum","museums",new Document("name",name)));
//        BaoTang baoTang = new BaoTang(docs.getString("name"), docs.getString("address"),
//                docs.getString("price"),docs.getString("openings"), docs.getString("topic"), docs.getInteger("pic"));
//        return baoTang;
//    }

//    public static List<BaoTang> findByTopic(String topic){
//        List<Document> docs = new ArrayList<>(MongoDBQuery.find("hanoi-museum","museums",new Document("topic",topic)));
//        List<BaoTang> museums = new ArrayList<>();
//        for(int i=0;i<docs.size();i++) {
//            museums.add(new BaoTang(docs.get(i).getString("name"), docs.get(i).getString("address"),
//                    docs.get(i).getString("price"),docs.get(i).getString("openings"),
//                    docs.get(i).getString("topic"), docs.get(i).getInteger("pic")));
//        }
//        return museums;
//    }
//
//    public static List<BaoTang> findByAddress(String address){
//        List<Document> Docs = new ArrayList<>(MongoDBQuery.find("hanoi-museum","museums",new Document("address",address)));
//        List<BaoTang> museums = new ArrayList<>();
//        for(int i=0;i<Docs.size();i++) {
//            museums.add(new BaoTang(Docs.get(i).getString("name"), Docs.get(i).getString("address"),
//                    Docs.get(i).getString("price"),Docs.get(i).getString("openings"),
//                    Docs.get(i).getString("topic"), Docs.get(i).getInteger("pic")));
//        }
//        return museums;
//    }
//    public static List<BaoTang> getAllMuseum(){
//        List<Document> Docs = new ArrayList<>(MongoDBQuery.findAll("hanoi-museum","museums"));
//        List<BaoTang> museums = new ArrayList<>();
//        for(int i=0;i<Docs.size();i++) {
//            museums.add(new BaoTang(Docs.get(i).getString("name"), Docs.get(i).getString("address"),
//                    Docs.get(i).getString("price"),Docs.get(i).getString("openings"),
//                    Docs.get(i).getString("topic"), Docs.get(i).getInteger("pic")));
//        }
//        return museums;
//    }

    public static List<BaoTang> getRandomMuseum(int number_random) {
        List<Document> Docs = new ArrayList<>(MongoDBQuery.findAll("hanoi-museum","museums"));
        List<BaoTang> museums = new ArrayList<>();

        List<Integer> randomList = new ArrayList<>();
        while (randomList.size() < number_random && randomList.size() < Docs.size()){
            int randomInt = (int) (Math.random() * Docs.size());
            if(!randomList.contains(randomInt)){
                randomList.add(randomInt);
            }
        }


        for (int i = 0; i < randomList.size(); i++) {
            museums.add(new BaoTang(Docs.get(randomList.get(i)).getString("name"), Docs.get(randomList.get(i)).getString("address"),
                    Docs.get(randomList.get(i)).getString("price_min_max"),Docs.get(randomList.get(i)).getList("opening_times", String.class),
                    Docs.get(randomList.get(i)).getList("chude", String.class), Docs.get(randomList.get(i)).getString("picture"), true));
        }
        return museums;
    }

    public static BaoTang getMuseumByName_ThongTinAll(String name) {
        Document doc = MongoDBQuery.queryOne("hanoi-museum","museums",new Document("name", name));
        BaoTang museum = new BaoTang(doc.getString("name"), doc.getString("picture"),
                doc.getDouble("vote"), doc.getInteger("comment"));
        return museum;
    }

    public static BaoTang getMuseumByNam_ThongTinChungNew(String name) {
        Document doc = MongoDBQuery.queryOne("hanoi-museum","museums",new Document("name", name));
        BaoTang museum = new BaoTang(doc.getString("name"), doc.getList("opening_times", String.class),
                doc.getList("price", String.class), doc.getList("price_free", String.class),
                doc.getString("gioi_thieu"), doc.getDouble("x_toado"), doc.getDouble("y_toado"));
        return museum;
    }

}
