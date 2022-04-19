package com.apps.bultech.newdailytweets.tweetclasses;

public class videoTweet {


    private String title;
    private String url;

    public  videoTweet(){

    }

    public videoTweet(String title,String videoUrl){
        this.title=title;
        this.url=videoUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
