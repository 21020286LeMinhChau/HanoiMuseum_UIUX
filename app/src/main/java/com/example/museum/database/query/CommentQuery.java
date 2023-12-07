package com.example.museum.database.query;

import com.example.museum.Khampha.DanhGia.Comment;
import com.example.museum.Khampha.DanhGia.CommentsMuseum;
import com.example.museum.Khampha.Thamquan.HienVat;
import com.google.api.client.util.DateTime;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentQuery {
    public static CommentsMuseum[] allCommentsMuseum;

    public static void getAllCommentsMuseum_StartProgram() throws JSONException {
        List<Document> Docs = new ArrayList<>(MongoDBQuery.findAll("hanoi-museum", "comments"));
        allCommentsMuseum = new CommentsMuseum[Docs.size()];
        for (int i = 0; i < Docs.size(); i++) {
            List<Comment> comments = new ArrayList<>();
            List<Document> commentDocs = Docs.get(i).getList("comment", Document.class);

            for (Document commentDoc : commentDocs) {
                String user = commentDoc.getString("user");
                String comment = commentDoc.getString("comment");
                int vote = commentDoc.getInteger("vote");

                Date timeCommentDate = commentDoc.getDate("time_comment");
                DateTime timeComment = new DateTime(timeCommentDate);

                comments.add(new Comment(user, comment, timeComment, vote));
            }

            allCommentsMuseum[i] = new CommentsMuseum(Docs.get(i).getString("museum"), comments);
        }
    }

    public static CommentsMuseum getCommentsMuseumFromMuseum(String museum) {
        for (int i = 0; i < allCommentsMuseum.length; i++) {
            if (allCommentsMuseum[i].getMuseum().equals(museum)) {
                return allCommentsMuseum[i];
            }
        }
        return null;
    }


}
