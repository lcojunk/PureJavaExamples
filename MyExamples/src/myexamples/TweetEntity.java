/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

import java.util.Date;

/**
 *
 * @author odzhara-ongom
 */
public class TweetEntity {
    private String date;
    private String name;
    private String tweet;
    private long user_id;

    public TweetEntity() {
    }

    public TweetEntity(String date, String name, String tweet) {
        this.date = date;
        this.name = name;
        this.tweet = tweet;
    }

    public TweetEntity(String date, String name, String tweet, long user_id) {
        this.date = date;
        this.name = name;
        this.tweet = tweet;
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    
    public String toString(int art) {
        String result = "";
        switch (art) {
            case 0: result=this.toString(); break;
            case 1: result+="Date="+date+"\n";
                    result+="Name="+name+"\n";
                    result+="Tweet="+tweet+"\n";
                    result+="userId="+user_id+"\n";
                    break;
            default : break;
        }
        return result;
    }
            
    
    
}
