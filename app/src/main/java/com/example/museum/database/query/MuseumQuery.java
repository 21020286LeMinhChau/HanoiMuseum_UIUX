package com.example.museum.database.query;

import com.example.museum.Trangchu.BaoTang;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MuseumQuery {
    public static BaoTang[] allMuseums;

    public static void getAllMuseums_StartProgram() {
        List<Document> Docs = new ArrayList<>(MongoDBQuery.findAll("hanoi-museum","museums"));
        allMuseums = new BaoTang[Docs.size()];
        for (int i = 0; i < Docs.size(); i++) {
            allMuseums[i] = new BaoTang(Docs.get(i).getString("name"), Docs.get(i).getString("address"),
                    Docs.get(i).getString("price_min_max"),Docs.get(i).getList("opening_times", String.class),
                    Docs.get(i).getList("chude", String.class), Docs.get(i).getString("picture"), true);
        }
    }



    public static List<BaoTang> getRandomMuseum(int number_random) {
//        List<Document> Docs = new ArrayList<>(MongoDBQuery.findAll("hanoi-museum","museums"));
//        while (randomList.size() < number_random && randomList.size() < Docs.size()){
//            int randomInt = (int) (Math.random() * Docs.size());
//            if(!randomList.contains(randomInt)){
//                randomList.add(randomInt);
//            }
//        }


//        for (int i = 0; i < randomList.size(); i++) {
//            museums.add(new BaoTang(Docs.get(randomList.get(i)).getString("name"), Docs.get(randomList.get(i)).getString("address"),
//                    Docs.get(randomList.get(i)).getString("price_min_max"),Docs.get(randomList.get(i)).getList("opening_times", String.class),
//                    Docs.get(randomList.get(i)).getList("chude", String.class), Docs.get(randomList.get(i)).getString("picture"), true));
//        }

        List<BaoTang> museums = new ArrayList<>();

        List<Integer> randomList = new ArrayList<>();
        while (randomList.size() < number_random && randomList.size() < allMuseums.length){
            int randomInt = (int) (Math.random() * allMuseums.length);
            if(!randomList.contains(randomInt)){
                randomList.add(randomInt);
            }
        }






        for (int i = 0; i < randomList.size(); i++) {
            museums.add(allMuseums[randomList.get(i)]);
        }



        return museums;
    }


    public static List<BaoTang> getMaxCommentMuseum(int number_max_comment) {
        List<Integer> n_max_comment = new ArrayList<>();
        List<BaoTang> museums = new ArrayList<>();
        for (int i = 0; i < allMuseums.length; i++) {
            n_max_comment.add(allMuseums[i].getComment());
        }
        n_max_comment.sort((o1, o2) -> o2 - o1);
        for (int i = 0; i < number_max_comment; i++) {
            for (int j = 0; j < allMuseums.length; j++) {
                if (allMuseums[j].getComment() == n_max_comment.get(i) && !museums.contains(allMuseums[j])) {
                    museums.add(allMuseums[j]);
                    break;
                }
            }
        }
        return museums;
    }

    public static BaoTang getMuseumByName_ThongTinAll(String name) {
//        Document doc = MongoDBQuery.queryOne("hanoi-museum","museums",new Document("name", name));
//        BaoTang museum = new BaoTang(doc.getString("name"), doc.getString("picture"),
//                doc.getDouble("vote"), doc.getInteger("comment"));

        BaoTang museum = null;
        for (int i = 0; i < allMuseums.length; i++) {
            if (allMuseums[i].getNameOfMuseum().equals(name)) {
                museum = allMuseums[i];
                break;
            }
        }
        return museum;
    }

    public static BaoTang getMuseumByNam_ThongTinChungNew(String name) {
//        Document doc = MongoDBQuery.queryOne("hanoi-museum","museums",new Document("name", name));
//        BaoTang museum = new BaoTang(doc.getString("name"), doc.getList("opening_times", String.class),
//                doc.getList("price", String.class), doc.getList("price_free", String.class),
//                doc.getString("gioi_thieu"), doc.getDouble("x_toado"), doc.getDouble("y_toado"));

        BaoTang museum = null;
        for (int i = 0; i < allMuseums.length; i++) {
            if (allMuseums[i].getNameOfMuseum().equals(name)) {
                museum = allMuseums[i];
                break;
            }
        }
        return museum;
    }

    public static List<BaoTang> getAllMuseums() {
        return new ArrayList<>(List.of(allMuseums));
    }
}
