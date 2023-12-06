package com.example.museum.database.query;

import com.example.museum.Khampha.Thamquan.HienVat;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ObjectQuery {
    public static HienVat[] allHienvat;

    public static void getAllHienvat_StartProgram() {
        List<Document> Docs = new ArrayList<>(MongoDBQuery.findAll("hanoi-museum", "objects"));
        allHienvat = new HienVat[Docs.size()];
        for (int i = 0; i < Docs.size(); i++) {
//            public HienVat(String id, String tenHienVat, List<String> listImage, String information, String audioSource, String museum, String author) {
            allHienvat[i] = new HienVat(Docs.get(i).getString("id"), Docs.get(i).getString("name"), Docs.get(i).getList("picture", String.class), Docs.get(i).getString("information"), Docs.get(i).getString("audioSource"), Docs.get(i).getString("museum"));
        }
    }


    public static List<HienVat> getRandom_n_HienVat(int n) {
//        get random n hien vat in allHienvat
        List<HienVat> hienVats = new ArrayList<>();
        int i = 0;
        while (hienVats.size() < n && i < allHienvat.length) {
            HienVat hienVat = allHienvat[(int) (Math.random() * allHienvat.length)];
            if (!hienVats.contains(hienVat)) {
                hienVats.add(hienVat);
                i++;
            }

        }
        return hienVats;

    }

    public static HienVat getObjectFromId(String id) {
        for (int i = 0; i < allHienvat.length; i++) {
            if (allHienvat[i].getID().equals(id)) {
                return allHienvat[i];
            }
        }
        return null;
    }
}
