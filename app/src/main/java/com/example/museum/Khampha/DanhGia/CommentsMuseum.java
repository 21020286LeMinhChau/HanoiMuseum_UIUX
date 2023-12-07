package com.example.museum.Khampha.DanhGia;

import java.util.List;

public class CommentsMuseum {
    private String museum;
    private List<Comment> comments;

    public CommentsMuseum(String museum, List<Comment> comments) {
        this.museum = museum;
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getMuseum() {
        return museum;
    }
}
