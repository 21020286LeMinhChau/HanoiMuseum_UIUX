package com.example.museum.Khampha.DanhGia;

import java.util.List;

public class CommentsMuseum {
    private String museum;
    private List<Comment> comments;
    private int count_vote;
    private double avg_vote;
    private int percentage_vote_5;
    private int percentage_vote_4;
    private int percentage_vote_3;
    private int percentage_vote_2;
    private int percentage_vote_1;

    public CommentsMuseum(String museum, List<Comment> comments) {
        this.museum = museum;
        this.comments = comments;
        processAllData();
    }

    private void processAllData() {
        count_vote = comments.size();
        int sum = 0;
        int count_5 = 0;
        int count_4 = 0;
        int count_3 = 0;
        int count_2 = 0;
        int count_1 = 0;
        for (int i = 0; i < comments.size(); i++) {
            sum += comments.get(i).getVote();
            switch (comments.get(i).getVote()) {
                case 5:
                    count_5++;
                    break;
                case 4:
                    count_4++;
                    break;
                case 3:
                    count_3++;
                    break;
                case 2:
                    count_2++;
                    break;
                case 1:
                    count_1++;
                    break;
            }
        }
        avg_vote = sum * 1.0 / count_vote;
        percentage_vote_5 = count_5 * 100 / count_vote;
        percentage_vote_4 = count_4 * 100 / count_vote;
        percentage_vote_3 = count_3 * 100 / count_vote;
        percentage_vote_2 = count_2 * 100 / count_vote;
        percentage_vote_1 = count_1 * 100 / count_vote;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getMuseum() {
        return museum;
    }

    public int getCount_vote() {
        return count_vote;
    }

    public double getAvg_vote() {
        return avg_vote;
    }

    public int getPercentage_vote_5() {
        return percentage_vote_5;
    }

    public int getPercentage_vote_4() {
        return percentage_vote_4;
    }

    public int getPercentage_vote_3() {
        return percentage_vote_3;
    }

    public int getPercentage_vote_2() {
        return percentage_vote_2;
    }

    public int getPercentage_vote_1() {
        return percentage_vote_1;
    }
}
