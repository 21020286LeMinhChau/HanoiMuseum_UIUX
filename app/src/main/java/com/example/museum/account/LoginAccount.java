package com.example.museum.account;


import com.example.museum.database.query.UserQuery;

// lop nay luu account hien dang duoc dang nhap, su dung lop nay goi ra ten de lay tu csdl hoac luu vao csdl voi thong tin cua account
public class LoginAccount {
    public static Account account;

    public static void logout() {
        account = null;
    }
}
