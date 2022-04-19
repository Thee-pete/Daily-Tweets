package com.apps.bultech.newdailytweets.tweetclasses;

public class textTweet {

    public String tweet;
    public String categoryName;

    public textTweet(String  category, String tweet){
        this.categoryName = category;
        this.tweet= tweet;
    }

    public void setCategoryName(String category) {
        this.categoryName = category;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getTweet() {
        return tweet;
    }

    public String getCategoryName() {
        return categoryName;
    }


}
