package com.example.museum.database;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmDB {
    public static void configFile(){
        // Lấy đối tượng RealmConfiguration mặc định hiện tại
        RealmConfiguration config = Realm.getDefaultConfiguration();
        // Xóa file Realm hiện tại
        Realm.deleteRealm(config);
        // Tạo file Realm mới với tên bất kỳ
        RealmConfiguration newConfig = new RealmConfiguration.Builder()
                .build();
        Realm.setDefaultConfiguration(newConfig);
    }
}
